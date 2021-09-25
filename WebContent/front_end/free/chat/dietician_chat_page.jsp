<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.dietician.model.*"%>
<%@ page import="java.util.*"%>

<%

DieticianService dieticianSvc = new DieticianService();
request.setAttribute("dieticianSvc", dieticianSvc);

%>




<!DOCTYPE html>
<html>

<head>
<title>營材食教</title>

<!-- *************每一頁head裡面都要include這個css連結******************* -->
<%@ include file="/front_end_example/CSS_link.jsp" %>
<!-- *************每一頁head裡面都要include這個css連結******************* -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet">
<style>



#unread {
	width: 90px;
	position: fixed;
	bottom:  110px;
	right : 30px;
	z-index: 6;
	color: red;
	font-weight:bold;

}

.inbox_people {
  background: #f8f8f8 none repeat scroll 0 0;
  float: left;
  overflow-y: auto;
  width: 40%; 
  height: 500px;
  border-right:1px solid #c4c4c4;
}

.top_spac{ margin: 20px 0 0;}

.recent_heading {float: left; width:40%;}

.srch_bar {
  display: inline-block;
  text-align: right;
  width: 60%;
}
.headind_srch{ padding:10px 29px 10px 20px; overflow:hidden; border-bottom:1px solid #c4c4c4;}

.recent_heading h4 {
  color: #05728f;
  font-size: 21px;
  margin: auto;
}

.srch_bar input{ border:1px solid #cdcdcd; border-width:0 0 1px 0; width:80%; padding:2px 0 4px 6px; background:none;}
.srch_bar .input-group-addon button {
  background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
  border: medium none;
  padding: 0;
  color: #707070;
  font-size: 18px;
}
.srch_bar .input-group-addon { margin: 0 0 0 -27px;}

.chat_ib h5{ font-size:15px; color:#464646; margin:0 0 8px 0;}
.chat_ib h5 span{ font-size:13px; float:right;}
.chat_ib p{ font-size:14px; color:#989898; margin:auto}
.chat_img {
  float: left;
  width: 11%;
}

.chat_ib {
  float: left;
  padding: 0 0 0 15px;
  width: 88%;
}

.chat_people{ overflow:hidden; clear:both;}
.chat_list {
  border-bottom: 1px solid #c4c4c4;
  margin: 0;
  padding: 18px 16px 10px;
}









.chat_box_container {
	width: 100%;
	height: 50%;
	background-color: white;
	z-index: 5;
}

.inbox_msg {
  border: 1px solid #c4c4c4;
  clear: both;
  overflow: hidden;
}

.srch_bar {
  display: inline-block;
  text-align: right;
  width: 60%;
}

.active_chat{ background:#ebebeb;}

.incoming_msg_img {
  display: inline-block;
  width: 6%;
}
.received_msg {
  display: inline-block;
  padding: 0 0 0 10px;
  vertical-align: top;
  width: 92%;
 }
 .received_withd_msg p {
  background: #ebebeb none repeat scroll 0 0;
  border-radius: 3px;
  color: #646464;
  font-size: 14px;
  margin: 0;
  padding: 5px 10px 5px 12px;
  width: 100%;
}
.time_date {
  color: #747474;
  display: block;
  font-size: 12px;
  margin: 8px 0 0;
}
.received_withd_msg { width: 57%;}

.mesgs {
float: left;
  padding: 30px 15px 5px 25px;
 
}

 .sent_msg p {
  background: #40ff00 none repeat scroll 0 0;
  border-radius: 3px;
  font-size: 14px;
  margin: 0; color:#fff;
  padding: 5px 10px 5px 12px;
  width:100%;
}
.outgoing_msg{ overflow:hidden; margin:26px 0 26px;}

.sent_msg>p {
color: black;
}


.sent_msg {
  float: right;
  width: 46%;
}


.input_msg_write input {
  background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
  border: medium none;
  color: #4c4c4c;
  font-size: 15px;
	
  width: 100%;
  
}



.msg_send_btn {
  background: #0084ff none repeat scroll 0 0;
  border: medium none;
  border-radius: 50%;
  color: #fff;
  cursor: pointer;
  font-size: 17px;
  height: 33px;
  position: relative;
  left: 93%;
  bottom: 43px;
  width: 33px;
}

.messaging { padding: 0 0 5px 0;}

.msg_history {
  height: 400px;
  overflow-y: auto;
}		

</style>

</head>


<body onload="connect();">
<!-- *************每一頁body最前面都要include這個header連結******************* -->
<%@ include file="/front_end_example/header_link.jsp" %>
<!-- *************每一頁body最前面都要include這個header連結******************* -->
<div class="container this_page">
 
 <h3>訂閱客戶文字諮詢</h3>
 <br>
 <div id="chat_box_container" class="chat_box_container">
<h3 id="statusOutput" class="text-center"></h3>
<div class="messaging">
      <div class="inbox_msg row">
              <div class="inbox_people col-4">

          <div class="inbox_chat">
            <div class="chat_list active_chat">
              <div class="chat_people">
                <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                <div class="chat_ib">
                  <h5>Sunil Rajput <span class="chat_date">Dec 25</span></h5>
                  <p>Test, which is a new approach to have all solutions 
                    astrology under one roof.</p>
                </div>
              </div>
            </div>
            <div class="chat_list">
              <div class="chat_people">
                <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                <div class="chat_ib">
                  <h5>Sunil Rajput <span class="chat_date">Dec 25</span></h5>
                  <p>Test, which is a new approach to have all solutions 
                    astrology under one roof.</p>
                </div>
              </div>
            </div>

            <div class="chat_list">
              <div class="chat_people">
                <div class="chat_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
                <div class="chat_ib">
                  <h5>Sunil Rajput <span class="chat_date">Dec 25</span></h5>
                  <p>Test, which is a new approach to have all solutions 
                    astrology under one roof.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div  id="messagesArea" class="mesgs col-7">
         
         
          <div id="msg_history" class="msg_history">
		            <div class="incoming_msg">
		              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
		              <div class="received_msg">
		                <div class="received_withd_msg">
		                  <p>Test which is a new approach to have all
		                    solutions</p>
		                  <span class="time_date"> 11:01 AM    |    June 9</span></div>
		              </div>
		            </div>
		            <div class="outgoing_msg">
		              <div class="sent_msg">
		                <p>Test which is a new approach to have all
		                  solutions</p>
		                <span class="time_date"> 11:01 AM    |    June 9</span> </div>
            			</div>
            					            <div class="incoming_msg">
		              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
		              <div class="received_msg">
		                <div class="received_withd_msg">
		                  <p>Test which is a new approach to have all
		                    solutions</p>
		                  <span class="time_date"> 11:01 AM    |    June 9</span></div>
		              </div>
		            </div>
		            <div class="outgoing_msg">
		              <div class="sent_msg">
		                <p>Test which is a new approach to have all
		                  solutions</p>
		                <span class="time_date"> 11:01 AM    |    June 9</span> </div>
            			</div>
            					            <div class="incoming_msg">
		              <div class="incoming_msg_img"> <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil"> </div>
		              <div class="received_msg">
		                <div class="received_withd_msg">
		                  <p>Test which is a new approach to have all
		                    solutions</p>
		                  <span class="time_date"> 11:01 AM    |    June 9</span></div>
		              </div>
		            </div>
		            <div class="outgoing_msg">
		              <div class="sent_msg">
		                <p>Test which is a new approach to have all
		                  solutions</p>
		                <span class="time_date"> 11:01 AM    |    June 9</span> </div>
            			</div>

          </div>
          <div class="type_msg">
            <div class="input_msg_write">
              <input id="sendMessage" type="text" class="write_msg" placeholder="Type a message" onkeydown="if (event.keyCode == 13) sendMessage();"/>
              <button class="msg_send_btn" type="button" onclick="sendMessage();"><i class="fa fa-paper-plane-o" aria-hidden="true"></i></button>
            </div>
          </div>
        </div>
      </div>
    </div>
   </div>
 
</div>




<p id="unread"></p>



</div>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<%@ include file="/front_end_example/footer_link.jsp" %>
<!-- *************每一頁body最後面都要include這個footer連結******************* -->
<!-- *************每一頁body最後面都要include這個js連結******************* -->
<%@ include file="/front_end_example/js_link.jsp" %>
<!-- *************每一頁body最後面都要include這個js連結******************* -->
<script>





var MyPoint = "/ChatWithDietician/${memberVO1.mid}";   //用EL接NameServlet傳過來的req.setAttribute("userName", userName);
var host = window.location.host;
var path = window.location.pathname;
var webCtx = path.substring(0, path.indexOf('/', 1));   //indexOf('/', 1), 後面的1指的是從path的第一個index(W)開始找起, 不然會找到前面最一開始的/而不是/chat.do那個"/"
var endPointURL = "ws://" + window.location.host + webCtx + MyPoint;


var statusOutput = document.getElementById("statusOutput");  //顯示聊天對象的地方
var msg_history = document.getElementById("msg_history");  //聊天視窗
var self = '${memberVO1.mid}';   //用EL接的userName
var webSocket;    //在connect()執行的時候一併註冊webSocket的各種事件對應

function connect() {     
	// create a websocket
	webSocket = new WebSocket(endPointURL);     //自己上線, 開一個ws session
	webSocket.onopen = function(event) {      //event是js websocket實做好onopen得到的event object
		console.log("Connect Success!");
//		document.getElementById('sendMessage').disabled = false;
	};
	
	webSocket.onmessage = function(event) {       //這邊可以視為前端的controller
		var jsonObj = JSON.parse(event.data);     //event裡面放什麼是websocket在js實作好的event object內容
		//var messages = JSON.parse(jsonObj.message);
		
		
		if ("open" === jsonObj.type) {		//  equals.(action)  有人上線觸發後端onOpen事件時, 這邊就會收到一個type是open的State.java物件
			statusOutput.style.color = "green";
		
		
		} else if ("history" === jsonObj.type) {    //show出之前的對話紀錄, 延續對話
			var messages = JSON.parse(jsonObj.message);
			msg_history.innerHTML = '';
			
			for (var i = 0; i < messages.length; i++) {
		
				var historyData = JSON.parse(messages[i]);
		
				if(historyData.sender === self){     
				
					var chat_div = document.createElement('div');  
					chat_div.className='outgoing_msg';
					
					
					var sent_msg_div = document.createElement('div')
					sent_msg_div.className='sent_msg';
					
					var message_sent = document.createElement('p')
					message_sent.innerHTML = historyData.message;
					
					var message_time = document.createElement('span')
					
					if(historyData.readState !== undefined){
					message_time.innerHTML = historyData.time + historyData.readState;
					}else {
					message_time.innerHTML = historyData.time;
					}
					
					message_time.className='time_date';
					
					msg_history.appendChild(chat_div);
					chat_div.appendChild(sent_msg_div);
					sent_msg_div.appendChild(message_sent);
					sent_msg_div.appendChild(message_time);
				
				}else {
					var chat_div = document.createElement('div'); 
					chat_div.className='incoming_msg';
					
					
					var recrive_msg_div_img = document.createElement('div')
					recrive_msg_div_img.className='incoming_msg_img';
					
					var recrive_img = document.createElement('img')
<!-- recrive_img.src='<%=request.getContextPath()%>${dieticianSvc.findByPrimaryKey(memberVO1.dno).dpic}'; -->
					recrive_img.src='<%=request.getContextPath()%>/front_end/free/dietician/images/dietician3.jpg';
					
					var recrive_msg = document.createElement('div')
					recrive_msg.className='received_msg';
					
					var received_withd_msg = document.createElement('div')
					received_withd_msg.className='received_withd_msg';
					
					var message_sent = document.createElement('p')
					message_sent.innerHTML = historyData.message;
					
					var message_time = document.createElement('span')
					message_time.innerHTML = historyData.time;
					
					msg_history.appendChild(chat_div);
					chat_div.appendChild(recrive_msg_div_img);
					chat_div.appendChild(recrive_msg);
					recrive_msg_div_img.appendChild(recrive_img);
					recrive_msg.appendChild(received_withd_msg);
					received_withd_msg.appendChild(message_sent);
					received_withd_msg.appendChild(message_time);
				}
			}
			
			if(msg_history.scrollTop < 1){   //滾到中間不會被強制推到最下面
			msg_history.scrollTop = msg_history.scrollHeight;
			}
	
		
		} else if ("chat" === jsonObj.type) {   

			
			if(jsonObj.sender === self){     
				
				var chat_div = document.createElement('div');  
				chat_div.className='outgoing_msg';
				
				
				var sent_msg_div = document.createElement('div')
				sent_msg_div.className='sent_msg';
				
				var message_sent = document.createElement('p')
				message_sent.innerHTML = jsonObj.message;
				
				var message_time = document.createElement('span')
				message_time.innerHTML = jsonObj.time
				message_time.className='time_date';
				
				msg_history.appendChild(chat_div);
				chat_div.appendChild(sent_msg_div);
				sent_msg_div.appendChild(message_sent);
				sent_msg_div.appendChild(message_time);
			
			}else {
				var chat_div = document.createElement('div');  
				chat_div.className='incoming_msg';
				
				
				var recrive_msg_div_img = document.createElement('div')
				recrive_msg_div_img.className='incoming_msg_img';
				
				var recrive_img = document.createElement('img')
<!-- recrive_img.src='<%=request.getContextPath()%>${dieticianSvc.findByPrimaryKey(memberVO1.dno).dpic}'; -->
					recrive_img.src='<%=request.getContextPath()%>/front_end/free/dietician/images/dietician3.jpg';
				
				var recrive_msg = document.createElement('div')
				recrive_msg.className='received_msg';
				
				var received_withd_msg = document.createElement('div')
				received_withd_msg.className='received_withd_msg';
				
				var message_sent = document.createElement('p')
				message_sent.innerHTML = jsonObj.message;
				
				var message_time = document.createElement('span')
				message_time.innerHTML = jsonObj.time;
				
				msg_history.appendChild(chat_div);
				chat_div.appendChild(recrive_msg_div_img);
				chat_div.appendChild(recrive_msg);
				recrive_msg_div_img.appendChild(recrive_img);
				recrive_msg.appendChild(received_withd_msg);
				received_withd_msg.appendChild(message_sent);
				received_withd_msg.appendChild(message_time);
			}
		
			msg_history.scrollTop = msg_history.scrollHeight;
		
		} else if ("showUnreadCount" === jsonObj.type){
			if(jsonObj.unreadCount>0){
			var showUnread = document.getElementById("unread");
			showUnread.innerHTML=jsonObj.unreadCount+ '則未讀訊息';
			}
		} else if ("close" === jsonObj.type) {
			statusOutput.style.color = "red";
		}
		
	};

	webSocket.onclose = function(event) {
		console.log("Disconnected!");
	};

}

function sendMessage() {
	var inputMessage = document.getElementById("sendMessage");
//	var friend = '${dieticianSvc.findByPrimaryKey(memberVO1.dno).daccount}';  
	var friend = self==='shi123'? 'pi123' : 'shi123';
	var message = inputMessage.value.trim();
	var now = new Date();
	now= moment().format('h:mma') + " | " + moment().format('MMMM.DD');
	
	if (message === "") {
		alert("Input a message");
		inputMessage.focus();
	} else if (friend === "") {
		alert("Choose a friend");
	} else {
		
		var jsonObj = {
			"type" : "chat",     
			"sender" : self,   
			"receiver" : friend,  
			"message" : message,
			"time" : now
		};
		
		webSocket.send(JSON.stringify(jsonObj));   
		inputMessage.value = "";
		inputMessage.focus();
		console.log(now);
	}
}


function showHistory() {

	var now = new Date();
	now= moment().format('h:mma') + " | " + moment().format('MMMM.DD');
		
//		var friend = '${dieticianSvc.findByPrimaryKey(memberVO1.dno).daccount}';
		var friend = self==='shi123'? 'pi123' : 'shi123';
		var jsonObj = {
				"type" : "history",	
				"sender" : self,
				"receiver" : friend,
				"message" : "",
				"time" : now
				
			};
		webSocket.send(JSON.stringify(jsonObj));  
//	});
	console.log('listener');
}


function checkMessage() {
	
	if(!$("#chat_box_container").is(":hidden")){
	var friend = self==='shi123'? 'pi123' : 'shi123';
	var jsonObj = {
			"type" : "check", 
			"sender" : self,   
			"receiver" : friend  

		};
		webSocket.send(JSON.stringify(jsonObj)); 
	}
}

function refreshRead() {
	
	if(!$("#chat_box_container").is(":hidden")){
		showHistory();	 
	}
}

function showUnreadCount() {
	
	if($("#chat_box_container").is(":hidden")){
		var friend = self==='shi123'? 'pi123' : 'shi123';
		var jsonObj = {
				"type" : "showUnreadCount",     //一般聊天就丟type是chat物件java
				"sender" : self,   //self就是${userName}
				"receiver" : friend  //從statusOutput來的
			};
			webSocket.send(JSON.stringify(jsonObj)); 
		}
}


$(document).ready(function(){
	setInterval(refreshRead,2000);
	setInterval(showUnreadCount,2000);
});



</script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.20.0/moment.min.js"></script>
</body>
</html>