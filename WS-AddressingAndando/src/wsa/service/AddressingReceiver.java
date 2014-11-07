package wsa.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

@WebService
public class AddressingReceiver {

	public void returnStringResponse(@WebParam(name="return") String parm1) {

		System.out.println("AddressingReceiver: " + parm1);

	}

}
