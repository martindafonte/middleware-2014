package data;

import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

import services.AddressingReceiverInterface;

@WebService(targetNamespace="http://test/", portName="AddressingReceiverPort", serviceName="AddressingReceiver", endpointInterface="services.AddressingReceiverInterface")
@Addressing(enabled=true, required=true)
public class AddressingReceiver implements AddressingReceiverInterface {

	@Override
	@Action(
	         input="http://localhost:8080/WS-Addressing/AddressingSender/returnString")
	public void recieveString(String parm1) {

		System.out.println("AddressingReceiver: " + parm1);

	}

}
