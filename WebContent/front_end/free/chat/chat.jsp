<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath() %>/front_end/free/chat/css/friendchat.css" type="text/css" />
<style type="text/css">

</style>
<title>最大私人聊天室</title>
</head>
<body onload="connect();" onunload="disconnect();">
	<h3 id="statusOutput" class="statusOutput"></h3>
	<div id="row"></div>
	<div id="messagesArea" class="panel message-area" ></div>
	<div class="panel input-area">
		<input id="message" class="text-field" type="text" placeholder="Message" onkeydown="if (event.keyCode == 13) sendMessage();" /> 
		<input type="submit" id="sendMessage" class="button" value="Send" onclick="sendMessage();" /> 
		<input type="button" id="connect" class="button" value="Connect" onclick="connect();" /> 
		<input type="button" id="disconnect" class="button" value="Disconnect" onclick="disconnect();" />
	</div>
</body>
<script>
	var MyPoint = "/FriendWS/${userName}";   //用EL接NameServlet傳過來的req.setAttribute("userName", userName);
	var host = window.location.host;
	var path = window.location.pathname;
	var webCtx = path.substring(0, path.indexOf('/', 1));   //indexOf('/', 1), 後面的1指的是從path的第一個index(W)開始找起, 不然會找到前面最一開始的/而不是/chat.do那個"/"
	var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;

	
	var statusOutput = document.getElementById("statusOutput");  //顯示聊天對象的地方
	var messagesArea = document.getElementById("messagesArea");  //聊天視窗
	var self = '${userName}';   //用EL接的userName
	var webSocket;    //在connect()執行的時候一併註冊webSocket的各種事件對應

	function connect() {     
		// create a websocket
		webSocket = new WebSocket(endPointURL);     //自己上線, 開一個ws session
		console.log('1');
		webSocket.onopen = function(event) {      //event是js websocket實做好onopen得到的event object
			console.log("Connect Success!");
			document.getElementById('sendMessage').disabled = false;
			document.getElementById('connect').disabled = true;
			document.getElementById('disconnect').disabled = false;     //這裡是先註冊, 並沒有執行
		};
		console.log('2');
		webSocket.onmessage = function(event) {       //這邊可以視為前端的controller
			var jsonObj = JSON.parse(event.data);     //event裡面放什麼是websocket在js實作好的event object內容
			if ("open" === jsonObj.type) {		//  equals.(action)  有人上線觸發後端onOpen事件時, 這邊就會收到一個type是open的State.java物件
				refreshFriendList(jsonObj);    //下面寫好的js方法
			} else if ("history" === jsonObj.type) {    //show出之前的對話紀錄, 延續對話
				messagesArea.innerHTML = '';
				var ul = document.createElement('ul');   //用ul呈現對話
				ul.id = "area";
				messagesArea.appendChild(ul);
				// 這行的jsonObj.message是從redis撈出跟好友的歷史訊息，再parse成JSON格式處理
				var messages = JSON.parse(jsonObj.message);
				for (var i = 0; i < messages.length; i++) {     //for迴圈尻出所有對話
					var historyData = JSON.parse(messages[i]);
					var showMsg = historyData.message;
					var li = document.createElement('li');
					// 根據發送者是自己還是對方來給予不同的class名, 以達到訊息左右區分
					historyData.sender === self ? li.className += 'me' : li.className += 'friend';
											//判斷發訊息的人是誰, 去改寫class套用css
					li.innerHTML = showMsg;
					ul.appendChild(li);
				}
				messagesArea.scrollTop = messagesArea.scrollHeight;
			} else if ("chat" === jsonObj.type) {   //  equals.(action)
				var li = document.createElement('li');
				jsonObj.sender === self ? li.className += 'me' : li.className += 'friend';
				li.innerHTML = jsonObj.message;
				console.log(li);
				document.getElementById("area").appendChild(li);
				messagesArea.scrollTop = messagesArea.scrollHeight;
			} else if ("close" === jsonObj.type) {
				refreshFriendList(jsonObj);        //  equals.(action) 
			}	//更新好友列表
			
		};

		webSocket.onclose = function(event) {
			console.log("Disconnected!");
		};
	}
	
	function sendMessage() {
		var inputMessage = document.getElementById("message");
		var friend = statusOutput.textContent;   //
		var message = inputMessage.value.trim();

		if (message === "") {
			alert("Input a message");
			inputMessage.focus();
		} else if (friend === "") {
			alert("Choose a friend");
		} else {
			var jsonObj = {
				"type" : "chat",     //一般聊天就丟type是chat物件java
				"sender" : self,   //self就是${userName}
				"receiver" : friend,  //從statusOutput來的
				"message" : message
			};
			webSocket.send(JSON.stringify(jsonObj));    //send會觸發java的onMessage
			inputMessage.value = "";
			inputMessage.focus();
		}
	}
	
	// 有好友上線或離線就更新列表
	function refreshFriendList(jsonObj) {   //onopen跟onclose的時候觸發
		var friends = jsonObj.users;
		var row = document.getElementById("row");
		row.innerHTML = '';
		for (var i = 0; i < friends.length; i++) {
			if (friends[i] === self) { continue; }  //自己也在map裡面, 遇到自己就continue略過
			row.innerHTML +='<div id=' + i + ' class="column" name="friendName" value=' + friends[i] + ' ><h2>' + friends[i] + '</h2></div>';
		}						//動態新增好友列表的div
		addListener();  //對這個row註冊同樣的事件處理
	}
	// 註冊列表點擊事件並抓取好友名字以取得歷史訊息
	function addListener() {
		var container = document.getElementById("row"); 
		container.addEventListener("click", function(e) {    //註冊點擊事件=> click就送history給java
			var friend = e.srcElement.textContent;
			updateFriendName(friend);
			var jsonObj = {
					"type" : "history",	//會對到ChatMessage.java的資料, 變數名稱一定要一樣才可以
					"sender" : self,
					"receiver" : friend,
					"message" : ""
				};
			webSocket.send(JSON.stringify(jsonObj));  //去觸發java的onMessage, 
		});
	}
	
	function disconnect() {
		webSocket.close();
		document.getElementById('sendMessage').disabled = true;
		document.getElementById('connect').disabled = false;
		document.getElementById('disconnect').disabled = true;
	}
	
	function updateFriendName(name) {
		statusOutput.innerHTML = name;    //聊天的對象, 會做為receiver的值
	}
</script>
</html>