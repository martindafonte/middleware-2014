package services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Action;

@WebService(name="AddressingSenderInterface", targetNamespace="http://ws-addressing")
public interface AddressingSenderInterface {
	
	@WebMethod
	public String returnString (String parm1);

}
