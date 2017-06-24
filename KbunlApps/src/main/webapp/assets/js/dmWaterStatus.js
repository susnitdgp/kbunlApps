goog.provide('kbunl.start');

//Required Google Library
goog.require('goog.dom');

goog.require('goog.events');
goog.require('goog.events.EventType');

goog.require('goog.date.DateTime');
goog.require('goog.i18n.DateTimeFormat');
goog.require('goog.i18n.DateTimeParse');

goog.require('goog.ui.InputDatePicker');
goog.require('goog.ui.LabelInput');
goog.require('goog.ui.Dialog');

goog.require('goog.ui.Checkbox');
goog.require('goog.ui.Checkbox.State');


kbunl.start=function(){
	var PATTERN = "dd'/'MM'/'yyyy";
	var formatter = new goog.i18n.DateTimeFormat(PATTERN);
	var parser = new goog.i18n.DateTimeParse(PATTERN);
	
	var idp1 = new goog.ui.InputDatePicker(formatter, parser);
	idp1.decorate(goog.dom.getElement('fromDate'));

	var idp2 = new goog.ui.InputDatePicker(formatter, parser);
	idp2.decorate(goog.dom.getElement('toDate'));
	
	var fieldLabelInput1= new goog.ui.LabelInput('DD/MM/YYYY');
    fieldLabelInput1.decorate(goog.dom.getElement('fromDate'));
    var fieldLabelInput2= new goog.ui.LabelInput('DD/MM/YYYY');
    fieldLabelInput2.decorate(goog.dom.getElement('toDate'));
    
    var production = new goog.ui.Checkbox();
    //production.setLabel(goog.dom.getElement('productionCheck').parentNode);
    production.decorate(goog.dom.getElement('productionCheck'));
   
	
    goog.events.listen(goog.dom.getElement('showButton'),goog.events.EventType.CLICK,function(event){
    	
    	var alert_message="Message:";
    	
    	var idp1Stat;
    	var idp2Stat;
    	
    	var fromDate;
    	var toDate;
    	
    	var fromTime;
    	var toTime;
    	
    	var dialog1 = new goog.ui.Dialog();
    	dialog1.setTitle('Date Range Error Box');
    	dialog1.setButtonSet(goog.ui.Dialog.ButtonSet.createOk());
    	
    	//idp1 check
    	if(goog.isDateLike(idp1.getDate())){
    		idp1Stat=true;
    		fromDate=idp1.getDate();
    		fromTime=fromDate.getTime();
    		
    	}else{
    		idp1Stat=false;
    		alert_message +='Error in From Date';
    	}
    	//idp2 Check
    	if(goog.isDateLike(idp2.getDate())){
    		idp2Stat=true;
    		toDate=idp2.getDate();
    		toTime=toDate.getTime();
    	}else{
    		idp2Stat=false;
    		alert_message +='Error in To Date';
    	}
    	
    	if(idp1Stat && idp2Stat){
    		
    		if ((toTime-fromTime)>5){
    			
    			var queryFrom=fromDate.getDate()+'/'+(fromDate.getMonth()+1)+ '/'+fromDate.getFullYear();
    			var queryTo=toDate.getDate()+'/'+(toDate.getMonth()+1)+ '/'+toDate.getFullYear();
    			
    			console.log(queryFrom);
    			//Visualization Function Called
                handleQuery(queryFrom,queryTo);
    		}else{
    			alert_message +="From-Time Equal OR Greater Than To-Time";
    			dialog1.setTextContent(alert_message);
                dialog1.setVisible(true);
    		}
 
    	}else{
    		dialog1.setTextContent(alert_message);
            dialog1.setVisible(true);
    	}
 
    });

};

goog.exportSymbol('kbunl.start', kbunl.start);


