package data;

import javax.jws.WebService;

import services.AddressingReceiverInterface;

@WebService(targetNamespace="http://ws-addressing/", portName="AddressingReceiverPort", serviceName="AddressingReceiver", endpointInterface="services.AddressingReceiverInterface")
public class AddressingReceiver implements AddressingReceiverInterface {

	@Override
	public void recieveString(String parm1) {

		System.out.println("AddressingReceiver: " + parm1);

	}

}
