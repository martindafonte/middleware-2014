package wsa.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

@WebService(endpointInterface="wsa.service.AddressingSenderInterface")
@Addressing(enabled=true)
public class AddressingSender implements AddressingSenderInterface{
	
	public String returnString (@WebParam(name="sndMsg") String sndMsg){
		
		try{
			Thread.sleep(10000);
		} catch (InterruptedException e){
			e.printStackTrace();
			
		}
		System.out.println("AddressingSender: " + sndMsg);
		return sndMsg;
	}

}
