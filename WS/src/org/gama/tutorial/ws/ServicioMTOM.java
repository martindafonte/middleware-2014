package org.gama.tutorial.ws;

import java.awt.Image;
import javax.xml.ws.soap.MTOM;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.jboss.resteasy.spi.touri.URITemplate;

//Service Endpoint Interface
@WebService
@MTOM
@SOAPBinding(style = Style.RPC)
public interface ServicioMTOM {

	// download a image from server
	@WebMethod
	ImageData downloadImage(String name);

	// update image to server
	@WebMethod
	String uploadImage(ImageData data);
}
