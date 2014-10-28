package org.filetransfer.data;

import java.io.File;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlSchemaType;

public class FileData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlMimeType("application/pdf")
	@XmlSchemaType(name = "base64Binary")
	public byte[] file;
	public String name;

}
