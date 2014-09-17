/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bancows;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author bruno
 */
@WebService(serviceName = "Service")
public class Service {

	/**
	 * This is a sample web service operation
	 * @param l
	 */
	@WebMethod(operationName = "receive")
	public void receive(@WebParam(name = "transactions") List<Transaction> l) {
		System.out.println("#############################");
		for(Transaction t : l){
			System.out.println( t.toString() );
		}		
		System.out.println("#############################");
	}
}
