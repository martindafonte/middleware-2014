package data;

import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

import services.AddressingSenderInterface;

@WebService(targetNamespace="http://test/", portName="AddressingSenderPort", serviceName="AddressingSender", endpointInterface="services.AddressingSenderInterface")
@Addressing(enabled=true, required=true)
public class AddressingSender implements AddressingSenderInterface{
	
	@Override
	@Action(
	         input="http://localhost:8080/WS-Addressing/AddressingSender/returnString",
	         output="http://localhost:8080/WS-Addressing/AddressingReceiver/recieveString")
	public String returnString (String parm1){
		System.out.println("AddressingSender: " + parm1);
		return parm1+"AddressingSender";
	}

}
