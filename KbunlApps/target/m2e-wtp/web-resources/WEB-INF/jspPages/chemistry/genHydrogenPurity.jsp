<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
  <title>KBUNL: Web Site</title>
  <jsp:include page="staticResource.jsp">
  	 <jsp:param name="firstname3" value="Chaitanya" />
  </jsp:include>
  <script type="text/javascript" src="/assets/js/genHydrogenPurity.js"></script>
</head>
<body>

  <div class="container">

  <!-- Header Bar -->
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
      			<p>Generator Hydrogen Purity</p>
      			<small>Form Generated<cite title="Source Title">From GAE</cite></small>
      			<br/>
      					
      					
      			       <form class="form-horizontal" action="/Chemistry/HydrogenPurity" method="post">
      			       <fieldset>
					      
					      	<legend>Input Form: Generator Hydrogen Purity</legend>
					      	
					      	<h4>Hydrogen Purity Form</h4>
					      	
					      
					      	<label for="dateInput"><strong>For Date:</strong></label>
					      	<input type="text" class="input-medium" id="dateInput" name="dateInput"/>
					      	
					      	<div class="form-actions">
							      <input type="submit" class="btn btn-primary" value="Submit"/>
							      <input type="reset" class="btn" value="Reset"/>
							</div>
					      	
						   
	     				</fieldset>
    					</form>
      			
      			
      			
    		 </blockquote>
    		
          
        </div>
    </div>

  </div>
  <script type="text/javascript">
   	myproject.start();
  </script>
 
</body>
</html>
