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
 <script type="text/javascript" src="/assets/js/dmWaterProdConsumption.js"></script>
 
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
      			<p>DM Water Production and Consumption</p>
      			<small>Form Generated<cite title="Source Title">From GAE</cite></small>
      			<br/>
      					
      					
      			        <form class="form-horizontal" action="/Chemistry/DmWaterProdConsumption" method="post">
      			        <fieldset>
					      
					      	<legend>Input Form: DM Water Production And Consumption</legend>
					      	
					      	
					      	
						      <div class="${errors.production ? 'control-group error' : 'control-group'}">
						        <label class="control-label" for="production"><strong>DM Water Production:</strong></label>
						        <div class="controls">
						          <input type="text" class="input-small" id="production" name="production" placeholder="">
						          <span class="help-inline">m3</span>
						        </div>
						      </div>
						      <div class="control-group">
						        <label class="control-label" for="stage1Consumption"><strong>Stage1 Water Consumption:</strong></label>
						        <div class="controls">
						          <input type="text" class="input-small" id="stage1Consumption" name="stage1Consumption" placeholder="">
						          <span class="help-inline">m3</span>
						        </div>
						      </div>
						      
						      <div class="control-group">
						        <label class="control-label" for="stage2Consumption"><strong>Stage2 Water Consumption:</strong></label>
						        <div class="controls">
						          <input type="text" class="input-small" id="stage2Consumption" name="stage2Consumption" placeholder=""/>
						          <span class="help-inline">m3</span>
						        </div>
						      </div>
						      
						      <div class="control-group">
						        <label class="control-label" for="stage2Consumption"><strong>DM Water Stock:</strong></label>
						        <div class="controls">
						          <input type="text" class="input-small" id="stock" name="stock" placeholder=""/>
						          <span class="help-inline">m3</span>
						        </div>
						      </div>
						      
						      <div class="control-group">
						        <label class="control-label" for="dateInput">Uploaded For Date:</label>
						        <div class="controls">
						          <input type="text" id="dateInput" name="dateInput"/>
						         
						        </div>
						      </div>
						      
						       <div class="form-actions">
							      <button type="submit" class="btn btn-primary">Save changes</button>
							      <button type="button" class="btn">Cancel</button>
							    </div>
							    
							    <c:if test="${fn:length(errors) gt 0}">
  										<div class="alert alert-block">
									    	<h4>Warning!</h4>
									    	<span>${errors.production}</span>
									     	<span>${errors.stage1Consumption}</span>
									      	<span>${errors.stage2Consumption}</span>
									      	<span>${errors.stock}</span>
									      	<span>${errors.dateInput}</span>
			     						</div>
	     						
	     						</c:if>
	     						
	     					</fieldset>
    						</form>
      			
      			
      			
    		 </blockquote>
    		 <script type="text/javascript">
    		 
    		 	kbunl.chemistry.datePicker();
	  			
  			</script>
          
        </div>
    </div>
  
  
  </div>
 
</body>
</html>
