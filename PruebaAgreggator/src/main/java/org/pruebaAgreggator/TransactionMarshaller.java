package org.pruebaAgreggator;

import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class TransactionMarshaller implements Marshaller, Unmarshaller{

	public TransactionMarshaller() {}

	public void marshal(Object arg0, Result arg1) throws IOException,
			XmlMappingException {
		
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Object unmarshal(Source arg0) throws IOException,
			XmlMappingException {
		// TODO Auto-generated method stub
		return null;
	}

}
