package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="AddressingReceiverInterface", targetNamespace="http://ws-addressing/")
public interface AddressingReceiverInterface {
	
	@WebMethod
	public void recieveString (String parm1);

}

