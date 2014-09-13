package org.pruebamagica;

import javax.jms.Message;

public class PruebaActivator {

	
	public String process(String m){
//		System.out.println("ACTIVATOR 1: "+ m);
		return m == "hola" ? "chau" : "hola";
	}

}
