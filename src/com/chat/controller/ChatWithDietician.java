package com.chat.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

import com.chat.jedis.JedisHandleMessage;
import com.chat.model.ChatMessage;
import com.chat.model.State;

@ServerEndpoint("/ChatWithDietician/{userName}")
public class ChatWithDietician {
	private static Map<String, Session> sessionsMap = new ConcurrentHashMap<>();//java5的時候加入, concurrent並行
	
	
	//hashtable跟HashMap結構差不多, hashtable有實作synchronized, 但使用的是老方法, 同步較大的範圍
	//現在使用比較新的做法ConcurrentHashMap,同步較小的範圍，執行效率提高
	//訊息用session存
	//用map存  使用者-訊息, 只有特定的人可以取, 記得使用這不能重複
	
	Gson gson = new Gson();
	

	@OnOpen
	public void onOpen(@PathParam("userName") String userName, Session userSession) throws IOException {
		//onOpen=>前端new websocket的時候觸發
		//打開的時候確認session的人在不在
		//前端同樣會有自己的onOpen
		//此處的userName, userSession都是前端js webSocket = new WebSocket(endPointURL);所帶來的資訊
		
		/* save the new user in the map */
		sessionsMap.put(userName, userSession);  
		/* Sends all the connected users to the new user */
		Set<String> userNames = sessionsMap.keySet();
		State stateMessage = new State("open", userName, userNames); 
		//通知使用者的狀態, 會送一個state的type為open的json過去給前端
		
		String stateMessageJson = gson.toJson(stateMessage);
		Collection<Session> sessions = sessionsMap.values();
		for (Session session : sessions) {
			if (session.isOpen()) {
				session.getAsyncRemote().sendText(stateMessageJson);  //推送有人上線
				//丟給前端, 而前端用onMessage做反應
			}
		}

		String text = String.format("Session ID = %s, connected; userName = %s%nusers: %s", userSession.getId(),
				userName, userNames);
		System.out.println(text);
	}

	@OnMessage
	public void onMessage(Session userSession, String message) {   //message是前端sendMessage()丟過來的json字串
		ChatMessage chatMessage = gson.fromJson(message, ChatMessage.class); //給你一個字串, 你自己去看那個說明書class做處理
		String sender = chatMessage.getSender();   //有註明上面的class就可以直接用getter
		String receiver = chatMessage.getReceiver();
		String time = chatMessage.getTime();
		
	
		if ("history".equals(chatMessage.getType())) {   //去對應chatMessage.java的變數名稱, 對面的addListener送過來的
			List<String> historyData = JedisHandleMessage.getHistoryMsg(sender, receiver); 
			//存在redis的訊息, 每一個都是json
			String historyMsg = gson.toJson(historyData);
			ChatMessage cmHistory = new ChatMessage("history", sender, receiver, historyMsg, time); //ChatMessage的constructor
			if (userSession != null && userSession.isOpen()) {
				userSession.getAsyncRemote().sendText(gson.toJson(cmHistory));   //這行會觸發js的onMessage
				System.out.println("history = " + gson.toJson(cmHistory));

				return;    //取得歷史訊息後跳出
			}
		}
		
		if ("chat".equals(chatMessage.getType())) {
			Session receiverSession = sessionsMap.get(receiver);   //一般聊天, 取得對方的session, 同時丟給對方
		
			if (receiverSession != null && receiverSession.isOpen()) {
				
				receiverSession.getAsyncRemote().sendText(message);   //對雙方都發出訊息
			} 
			
			userSession.getAsyncRemote().sendText(message);   //對雙方都發出訊息
	
			JedisHandleMessage.saveChatMessage(sender, receiver, message);  //存入redis
			
			return;
		}
		

		if ("check".equals(chatMessage.getType())) {   //去對應chatMessage.java的變數名稱, 對面的addListener送過來的
			JedisHandleMessage.checkMessage(sender, receiver);
			return;
		}
		
		if ("showUnreadCount".equals(chatMessage.getType())) {   //去對應chatMessage.java的變數名稱, 對面的addListener送過來的
			String unreadCount = JedisHandleMessage.checkUnreadNumber(sender, receiver);
			
			ChatMessage cmHistory = new ChatMessage("showUnreadCount", sender, receiver, unreadCount); //ChatMessage的constructor
			userSession.getAsyncRemote().sendText(gson.toJson(cmHistory));
			
			return;
		}
		

		
		System.out.println("Message received: " + message);
	}

	@OnError
	public void onError(Session userSession, Throwable e) {     //直接貼
		System.out.println("Error: " + e.toString());
	}   

	@OnClose
	public void onClose(Session userSession, CloseReason reason) {
		String userNameClose = null;
		Set<String> userNames = sessionsMap.keySet();  
		for (String userName : userNames) {     //迴圈從所有session找出自己, 然後移除
			if (sessionsMap.get(userName).equals(userSession)) {
				userNameClose = userName;
				sessionsMap.remove(userName);
				break;     //移除掉自己的就可以中斷了
			}
		}

		if (userNameClose != null) {
			State stateMessage = new State("close", userNameClose, userNames);   //State裡面放open跟close兩種type
			String stateMessageJson = gson.toJson(stateMessage);
			Collection<Session> sessions = sessionsMap.values();
			for (Session session : sessions) {
				session.getAsyncRemote().sendText(stateMessageJson);
			}
		}

		String text = String.format("session ID = %s, disconnected; close code = %d%nusers: %s", userSession.getId(),
				reason.getCloseCode().getCode(), userNames);
		System.out.println(text);
	}
}
