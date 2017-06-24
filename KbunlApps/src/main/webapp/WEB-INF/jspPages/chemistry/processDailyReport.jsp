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
          		 	<jsp:param name="param1" value="value1" />
          		</jsp:include>
          
        </div>
        <div class="span9" style="margin-left:0px;">
          <!--Body content-->

				<blockquote style="height:550px;">
					<p>Chemistry Daily Report List</p>
					<small>List of Uploaded Files <cite title="Source Title">From
							GAE</cite></small> <br />

					<table class="table table-condensed">
					  <thead>
					    <tr>
					      <th>Filename</th>
					      <th>File Type</th>
					      <th>Upload Date</th>
					      <th>File Size</th>
					      <th>Action</th>
					    </tr>
					  </thead>
						<c:forEach var="file" items="${listOfFiles}">
							<tr>
							<td>${file.fileName}</td>
							<td>${file.fileType}</td>
							<td>${file.uploadDate}</td>
							<td>${file.size}</td>
							<td><a href="/Chemistry/DailyReportProcess?blob-key=${file.blobKey}" class="btn btn-mini"><i class="icon-cog"></i> Process</a></td>
							</tr>
							
						</c:forEach>
					</table>




				</blockquote>



			</div>
      </div>
  
  
  </div>
 
</body>
</html>
