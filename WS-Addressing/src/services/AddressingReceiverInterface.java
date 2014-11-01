package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface AddressingReceiverInterface {
	
	@WebMethod
	public void recieveString (String parm1);

}

