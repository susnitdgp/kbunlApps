<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.kbunl.HelloInfo" %>
<!DOCTYPE html>
<html>
<head>
  <title>KBUNL: Web Site</title>
  <link rel="shortcut icon" href="/favicon.ico">
  <link href='/assets/css/b.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/b-r.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/t-b.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/d-p.min.css' rel='stylesheet' type='text/css'/>
  <!-- Cloud CDN Library -->
  <script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="/assets/js/d-p.min.js"></script>
 
</head>
<body>
  <h1>Hello App Engine -- Standard!</h1>

  <p>This is <%= HelloInfo.getInfo() %>.</p>
  
  <div class="container-fluid">
  	
  	 <div class="row-fluid">
        <div class="span2">
          <!--Sidebar content-->
          
          
              <ul class="nav nav-list">
      			<li class="nav-header">Report Menu</li>
      			<li class="divider"></li>
      			<li><a href="/">Line Chart of Parameter</a></li>
      			<li><a href="#">Tabular Data of Parameter</a></li>
      			<li class="nav-header">Chemistry Menu</li>
      			<li class="divider"></li>
      			<li class="active"><a href="/Chemistry/UpdateDaily">Update Daily Report</a></li>
      			<li><a href="#">Settings</a></li>
      			<li><a href="#">Library</a></li>
      			<li><a href="/Hello">Hello Servlet</a></li>
      			<li><a href="/Test">Test Servlet</a></li>
  	
    			</ul>
          
          
        </div>
        <div class="span10">
          <!--Body content-->
          
              <blockquote>
      			<p>Chemistry Daily Update</p>
      			<small>Someone famous <cite title="Source Title">Source Title</cite></small>
      			<br/>
      			
      			        <h1>Updated Successfully</h1>
      			
      			
      			
    		 </blockquote>
          
          		
          
        </div>
      </div>
  
  
  </div>
 
</body>
</html>
