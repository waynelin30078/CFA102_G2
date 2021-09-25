package com.chat.jedis;
import java.util.List;

import com.chat.model.ChatMessage;
import com.google.gson.Gson;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisHandleMessage {
	

	private static JedisPool pool = JedisPoolUtil.getJedisPool();

	public static List<String> getHistoryMsg(String sender, String receiver) {
		
		Gson gson = new Gson();
		
		String key = new StringBuilder(sender).append(":").append(receiver).toString();
		String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
		Jedis jedis = null;
		jedis = pool.getResource();
		//jedis.auth("123456");
		List<String> historyData = jedis.lrange(key, 0, -1);    //全部
		
		List<String> receiverHistoryData = jedis.lrange(receiverKey, 0, -1);
		
		String senderInList = sender;
		

		for(String receiverData : receiverHistoryData) {
		
			ChatMessage dataOfReceiver = gson.fromJson(receiverData, ChatMessage.class);

			if(dataOfReceiver.getReceiver().equals(senderInList) && dataOfReceiver.getReadState() == null ) {
				dataOfReceiver.setReadState("已讀");
				String newReceiverData = gson.toJson(dataOfReceiver);
				
				jedis.lrem(receiverKey, 0, receiverData);
				jedis.rpush(receiverKey, newReceiverData);
			}
		}

		jedis.close();
		return historyData;
	}

	public static void saveChatMessage(String sender, String receiver, String message) {
		// 雙方都存歷史聊天紀錄
		String senderKey = new StringBuilder(sender).append(":").append(receiver).toString();
		String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
		Jedis jedis = pool.getResource();
		//jedis.auth("123456");
		jedis.rpush(senderKey, message);
		jedis.rpush(receiverKey, message);

		jedis.close();
	}
	
	public static String checkUnreadNumber(String sender, String receiver) {
		
		Gson gson = new Gson();
		
		String key = new StringBuilder(sender).append(":").append(receiver).toString();
		Jedis jedis = null;
		jedis = pool.getResource();
		
		int count = 0;
		
		List<String> historyData = jedis.lrange(key, 0, -1);
		
		for(String data : historyData) {
			
			ChatMessage jsonData = gson.fromJson(data, ChatMessage.class);
			if(jsonData.getSender().equals(sender) && jsonData.getReadState() == null) {
				count ++;
			}
			
		}
		
		jedis.close();
		return Integer.toString(count);
	}
	
	public static void checkMessage(String sender, String receiver) {
		
		String receiverKey = new StringBuilder(receiver).append(":").append(sender).toString();
		Jedis jedis = null;
		jedis = pool.getResource();
		//jedis.auth("123456");
		
		List<String> receiverHistoryData = jedis.lrange(receiverKey, 0, -1);
		
		for(String receiverData : receiverHistoryData) {
			if(!receiverData.contains("readState")) {	
				
				String newReceiverData = receiverData.substring(0, receiverData.length()-1) + ", \"readState\": \"已讀\"}";
				jedis.lrem(receiverKey, 0, receiverData);
				jedis.rpush(receiverKey, newReceiverData);
				
			}
		}
		jedis.close();

	}
	
	
	
}
