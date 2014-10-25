package org.gama.tutorial.ws;

import javax.jws.WebService;

@WebService(portName="ServicioPort", serviceName="ServicioService", targetNamespace="http://ws.tutorial.gama.org", endpointInterface="org.gama.tutorial.ws.Servicio")
public class ImplServicio implements Servicio {

	@Override
	public String returnAnything(String parm1) {
		System.out.println("Holaaa");
		return parm1;
	}

}
