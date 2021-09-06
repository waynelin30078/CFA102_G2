<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>選擇食物tab</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.12.4.js"></script>
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
        .highlight {
            background: green;
        }
</style>
 <script>
        $(function () {
            $("#gfg").tabs({
                event: 'click',
                classes: {
                    "ui-tabs": "highlight",
                }
            });
        });
    </script>

</head>




<body>

	 <h1 style="color: green;">GeeksforGeeks</h1>
	    <h3>jQuery UI tabs classes option</h3>
	  
	    <div id="gfg">
	        <ul>
	            <li><a href="#gfg1">Tab 1</a></li>
	            <li><a href="#gfg2">Tab 2</a></li>
	            <li><a href="#gfg3">Tab 3</a></li>
	        </ul>
	        <div id="gfg1">
	              
	<p>Welcome to GeeksforGeeks</p>
	  
	        </div>
	  
	        <div id="gfg2">
	              
	<p>GeeksforGeeks</p>
	  
	        </div>
	  
	        <div id="gfg3">
	              
	<p>Welcome Geeks!</p>
	  
	        </div>
	    </div>






</body>
</html>