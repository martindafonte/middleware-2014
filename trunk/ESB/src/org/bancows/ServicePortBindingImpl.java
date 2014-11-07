/**
 * ServicePortBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.bancows;

import java.util.HashMap;

public class ServicePortBindingImpl implements org.bancows.Service_PortType{
    public void receive(long id, org.bancows.Transaction[] transaction) throws java.rmi.RemoteException {
    	if(Diccionario.existe(id))return;
    	System.out.println("#############################");
		for(Transaction t : transaction){
			System.out.println( t.toString() );
		}		
		System.out.println("#############################");
		Diccionario.add(id);
    }
}

class Diccionario {
	static HashMap<Long,Boolean> l_dic;
	
	public Diccionario (){
		l_dic= new HashMap<Long,Boolean>(); 
	}
	
	public static synchronized boolean existe(long id){
		return l_dic.containsKey(id);
	}
	public static synchronized void add(long id){
		l_dic.put(id, true);
	}
	
}
