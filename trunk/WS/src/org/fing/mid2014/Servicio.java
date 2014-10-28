package org.gama.tutorial.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(targetNamespace="http://ws.tutorial.gama.org", name="Servicio")
public interface Servicio {
	@WebMethod
	public String returnAnything(String parm1);

}
