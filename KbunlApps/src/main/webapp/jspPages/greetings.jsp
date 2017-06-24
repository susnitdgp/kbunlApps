<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang=en>

<head>
    <title>KBUNL: Web Site</title>
  	<link rel="shortcut icon" href="/favicon.ico">
    <link href='/assets/css/b.min.css' rel='stylesheet' type='text/css'/>
  	<link href='/assets/css/b-r.min.css' rel='stylesheet' type='text/css'/>
  	<link href='/assets/css/t-b.min.css' rel='stylesheet' type='text/css'/>
    <style>
        body,
        html {
            height: 100%
        }
        #wrap {
            min-height: 100%;
            height: auto!important;
            height: 100%;
            margin: 0 auto -60px
        }
        #footer,
        #push {
            height: 60px
        }
        #footer {
            background-color: #f5f5f5
        }
        
    </style>
   
     </head>

<body>
    <div id=wrap>
      <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">
          <!--Sidebar content-->
        </div>
        <div class="span10">
          <!--Body content-->
          
          	<ul>
			<c:forEach var="greet" items="${greetings}">
    		<li>${greet.author_email}</li>
			</c:forEach>
			</ul>
          
          
        </div>
      </div>
    </div>
        
        
        <div id=push></div>
    </div>
    <div id=footer>
        
            <p class="muted credit">Example courtesy <a href=http://martinbean.co.uk>Martin Bean</a> 
            </p>
        
    </div>
   
    </body>
    </html>