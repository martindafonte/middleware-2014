package data;

import javax.jws.WebService;
import javax.xml.ws.Action;
import javax.xml.ws.soap.Addressing;

import services.AddressingReceiverInterface;

@WebService(targetNamespace="http://ws-addressing", portName="AddressingReceiverPort", serviceName="AddressingReceiver", endpointInterface="services.AddressingReceiverInterface")
@Addressing(enabled=true, required=true)
public class AddressingReceiver implements AddressingReceiverInterface {

	@Override
	@Action(
	         input="http://ws-addressing/AddressingSenderInterface/returnString")
	public void recieveString(String parm1) {

		System.out.println("AddressingReceiver: " + parm1);

	}

}
