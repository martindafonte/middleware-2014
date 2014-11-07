/**
 * ServicePortBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package fing.midd;

import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(targetNamespace="prueba2", portName="Sender", serviceName="BancoSender", endpointInterface="fing.midd.IService")
@Addressing
public class ServiceImplementation implements IService{
@Override
@WebMethod
    public void receive(long id, fing.midd.Transaction[] transaction) throws java.rmi.RemoteException {
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
	public static HashMap<Long,Boolean> l_dic;
	
	public Diccionario (){
		l_dic= new HashMap<Long,Boolean>(); 
	}
	
	public static synchronized boolean existe(long id){
		if(l_dic == null) l_dic = new HashMap<Long,Boolean>(); 
		return l_dic.containsKey(id);
	}
	public static synchronized void add(long id){
		if(l_dic == null) l_dic = new HashMap<Long,Boolean>();
		l_dic.put(id, true);
	}
	
}
