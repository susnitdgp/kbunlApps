<ul class="nav nav-list">
				
<li class="nav-header"><strong>Report Menu</strong></li>
<li class="divider"></li>

<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/dmWaterStatus.jsp') ? 'active' : ''}">
	<a href="/">DM Water Status</a>
</li>
<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/hydrogenPurityStatus.jsp') ? 'active' : ''}">
	<a href="/Chemistry/HyrogenPurityStatus">Hydrogen Purity Status</a>
</li>
<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/steamWaterStatus.jsp') ? 'active' : ''}">
	<a href="/Chemistry/SteamWaterStatus">Steam Water Status</a>
</li>
<li>
	<a href="/Chemistry/AshCombustibleStatus">Ash Combustibles Status </a>
</li>
<li>
	<a href="/Chemistry/MillFinenessStatus">Mill Fineness Status </a>
</li>
<li>
	<a href="/Chemistry/OilAnalysisStatus">Oil Analysis Status </a>
</li>
<li>
	<a href="/Chemistry/FlueGasAnalysis">Flue Gas Analysis Status </a>
</li>


<li class="nav-header"><strong>Chemistry Form Menu</strong></li>
<li class="divider"></li>


<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/dmWaterProdConsumption.jsp') or(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/chemSubmitSuccess.jsp') ? 'active' : ''}">
	<a href="/Chemistry/DmWaterProdConsumption">Update DM Water Status </a>
</li>
<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/genHydrogenPurity.jsp') ? 'active' : ''}">
	<a href="/Chemistry/HydrogenPurity">Update Hydrogen Purity Status </a>
</li>
<li>
	<a href="/Chemistry/SteamWaterAnalysis">Update Steam Water Status </a>
</li>
<li>
	<a href="/Chemistry/SteamWaterAnalysis">Update Ash Combustibles Status </a>
</li>
<li>
	<a href="/Chemistry/SteamWaterAnalysis">Update Mill Fineness Status </a>
</li>
<li>
	<a href="/Chemistry/SteamWaterAnalysis">Update Oil Analysis Status </a>
</li>
<li>
	<a href="/Chemistry/SteamWaterAnalysis">Update Flue Gas Analysis Status </a>
</li>


<li class="nav-header"><strong>Chemistry Report Upload</strong></li>
<li class="divider"></li>

<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/uploadDailyReport.jsp') ? 'active' : ''}">
	<a href="/Chemistry/UploadDailyReport">Upload Daily Chemistry Report</a>
</li>

<li class="${(pageContext.request.requestURI eq '/WEB-INF/jspPages/chemistry/processDailyReport.jsp') ? 'active' : ''}">
	<a href="/Chemistry/ProcessDailyReport">Process Daily Chemistry Report</a>
</li>

<!--  
<li><a href="#">Settings</a></li>
<li><a href="#">Library</a></li>
<li><a href="/Hello">Hello Servlet</a></li>
-->


</ul> 