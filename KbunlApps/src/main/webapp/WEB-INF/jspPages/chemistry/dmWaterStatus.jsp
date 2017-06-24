<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
  <title>KBUNL: Web Site</title>
  <jsp:include page="staticResource.jsp">
  	 <jsp:param name="tempParam" value="dmWaterStatus" />
  </jsp:include>
 
  <!-- Cloud CDN Library -->
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript" src="/assets/js/dmWaterStatus.min.js"></script>

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
      			<p>DM Water Status From GAE</p>
      			<small>DM Water Status <cite title="Source Title">From GAE</cite></small>
      			<br/>
      			
      			    <form class="form-inline">
  						<div class="control-group">
      			    		<label class="control-label" for="fromDate"><strong>FromDate:</strong></label>
      			    		<div class="controls">
      							<input type="text"  name="fromDate" id="fromDate"/>
      						</div>
      					</div>
      					<div class="control-group">
      			    		<label class="control-label" for="toDate"><strong>ToDate:</strong></label>
      			    		<div class="controls">
      							<input type="text" name="toDate" id="toDate" />
      						</div>
      					</div>
      					
      					<button class="btn btn-primary" type="button" id="showButton"><i class="icon-arrow-right icon-white "></i> Show Trend</button>
      					
   					 </form>
      			
      			<div class="row-fluid">
			          <div class="span10">
			          <div id="curve_chart_div"></div>
			          </div>
			          <div class="span2">
			          			<span id="productionCheck" class="goog-checkbox-checked"></span>DM Water Production
			          </div>
        		</div>
      			
      			<br/>
      			
    			<div id="table_div"></div>
    			
    			
      			
    		 </blockquote>
          
          		
          
        </div>
      </div>
  
  
 </div>
 <script type="text/javascript">
  		
 
	    kbunl.start();
 		//Load the Visualization API and the corechart package.
	  	google.charts.load('current', {'packages':['corechart','table']});

	  	// Set a callback to run when the Google Visualization API is loaded.
	  	google.charts.setOnLoadCallback(drawChart);
	
	  	function drawChart(){
	  		drawTable();

	  	};
	  	
	    function drawTable() {
	    	 var query=new google.visualization.Query('/Chemistry/DmWaterDataSource');
	    	 query.send(handleQueryResponse);
	    };
	    function handleQueryResponse(response){
	    	 if(! response.isError()){
	    		 var data=response.getDataTable();
	    		 var table = new google.visualization.Table(document.getElementById('table_div'));
	    		 table.draw(data,{title:'Datewise DM Water Status','showRowNumber': true,width:"100%"});
	    		 
	    		 var line_chart_options = {
	    				 hAxis: {
	    			          title: 'Date Range'
	    			        },
	    			     vAxis:{
	    			    	title: 'Cubic Meter'	 
	    			     },
	    		         title: 'Datewise DM Water Status',
	    		        
	    		         legend: { position: 'bottom' }
	    		        };

	    		 var chart = new google.visualization.LineChart(document.getElementById('curve_chart_div'));

	    		 chart.draw(data, line_chart_options);
	    		
	    	 }
	    };
	    
	    function handleQuery(fromDate,toDate){
	    	var query=new google.visualization.Query('/Chemistry/DmWaterDataSource?'+'fromDate='+fromDate+'&'+'toDate='+toDate);
		  	//query.setQuery('select production,stock');
		  	query.send(handleQueryResponse);
	    };

  </script> 
  
 
</body>
</html>

