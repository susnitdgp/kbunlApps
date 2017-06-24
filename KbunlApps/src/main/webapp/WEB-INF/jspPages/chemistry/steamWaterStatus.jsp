<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>KBUNL: Web Site</title>
  <link rel="shortcut icon" href="/favicon.ico">
  <link href='/assets/css/b.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/b-r.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/t-b.min.css' rel='stylesheet' type='text/css'/>
  <link href='/assets/css/d-p2.min.css' rel='stylesheet' type='text/css'/>
  <!-- Cloud CDN Library -->
  <script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="/assets/js/d-p2.min.js"></script>
  <script type="text/javascript" src="/assets/js/d-p2.en.min.js"></script>
  <script type="text/javascript">
   $(document).ready(function(){
   
   });
   </script>
</head>
<body>
 
  <div class="container">
  	
  <div class="row-fluid">
  		
  	  <jsp:include page="header.jsp">
	  	 <jsp:param name="firstname1" value="Chaitanya" />
	  </jsp:include>
  		
  	</div>
  	
  <hr style="margin:0px;background-color:#0099cc;border-top:1px solid #0099cc" />
  	
  	
  <div class="row-fluid">
        <div class="span3">
          <!--Sidebar content-->
          
          	<jsp:include page="leftMenu.jsp">
          		 <jsp:param name="firstname2" value="Chaitanya" />
          	</jsp:include>
             
          
          
        </div>
        <div class="span9" style="margin-left:0px;">
          <!--Body content-->
          
              <blockquote style="height:550px;">
      			<p>Steam Water Status From GAE</p>
      			<small>Steam Water Status <cite title="Source Title">From GAE</cite></small>
      			<br/>
      			
      			   <h4>Steam Water Status</h4>
      			
      			
      			<div id="curve_chart_div"></div>
      			
      			<br/>
      			
    			<div id="table_div"></div>
    			
    			
      			
    		 </blockquote>
          
          		
          
        </div>
      </div>
  
  
  </div>
  
  
 
</body>
</html>

