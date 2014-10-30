package data;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

import services.AddressingSenderInterface;

@WebService(portName="AddressingSenderPort", serviceName="AddressingSender", endpointInterface="services.AddressingSenderInterface")
@Addressing(enabled=true, required=true)
public class AddressingSender implements AddressingSenderInterface{
	
	@Override
	public String returnString (String parm1){
		System.out.println("AddressingSender: " + parm1);
		return parm1+"AddressingSender";
	}

}
