package org.bancodispatcher;

import javax.jms.Message;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

public class ErrorHandler {
	
	static Logger log = Logger.getLogger(ErrorHandler.class.getName());
	
	public void handleFailed(Throwable m){
		
//		LogFactory lfac = LogFactory.getFactory();
//		System.out.println("LLEGO AL LOGG: "+ m.getMessage());
		log.error(m.getMessage());
	}
}
