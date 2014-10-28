package org.fing.mid2014;

import javax.jws.WebService;
import javax.xml.ws.soap.Addressing;

@WebService(portName="ServicioPort", serviceName="ServicioService", targetNamespace="http://ws.tutorial.gama.org", endpointInterface="org.fing.mid2014.Servicio")
@Addressing(enabled=true, required=true)
public class ImplServicio implements Servicio {

	@Override
	public String returnAnything(String parm1) {
		System.out.println("Holaaa");
		return parm1;
	}

}
