package services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name="AddressingSenderInterface")
public interface AddressingSenderInterface {
	
	@WebMethod
	public String returnString (String parm1);

}
