<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>KBUNL: Web Site</title>
  <jsp:include page="staticResource.jsp">
  	 <jsp:param name="firstname3" value="Chaitanya" />
  </jsp:include>
 
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
      			<p>Chemistry Daily Update</p>
      			<small>Update Status <cite title="Source Title">From GAE</cite></small>
      			<br/>
      	
      			        <h3>Form Submitted Successfully</h3>
      					<h4>${message}</h4>
      					<h4>${key}</h4>
      			
      			
    		 </blockquote>
          
          		
          
        </div>
      </div>
  
  
  </div>
 
</body>
</html>
