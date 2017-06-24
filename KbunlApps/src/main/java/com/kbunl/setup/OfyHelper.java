package com.kbunl.setup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.googlecode.objectify.ObjectifyService;
import com.kbunl.chemistry.entity.DmWaterProdConsumption;
import com.kbunl.chemistry.entity.GenHydrogenPurity;
import com.kbunl.chemistry.entity.SteamWaterAnalysis;
import com.kbunl.chemistry.entity.SteamWaterDetails;
import com.kbunl.entity.DailyParameter;
import com.kbunl.entity.Greeting;
import com.kbunl.entity.GuestBook;

public class OfyHelper implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// This will be invoked as part of a warm up request, 
		// or the first user request if no warm up
	    // request.
	    ObjectifyService.register(GuestBook.class);
	    ObjectifyService.register(Greeting.class);
	    
	    ObjectifyService.register(DailyParameter.class);
	    ObjectifyService.register(GenHydrogenPurity.class);
	    ObjectifyService.register(DmWaterProdConsumption.class);
	    
	    ObjectifyService.register(SteamWaterAnalysis.class);
	    ObjectifyService.register(SteamWaterDetails.class);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// APP Engine does not currently invoke this method.
		
	}

}
