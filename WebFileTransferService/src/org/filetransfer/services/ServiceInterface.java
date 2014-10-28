package org.filetransfer.services;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.soap.MTOM;

import org.filetransfer.data.FileData;


@MTOM
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL)
public interface ServiceInterface {


	@WebMethod
	public FileData downloadPDF(String name);
 
	@WebMethod 
	public String uploadPDF(FileData data);
	
}
