package org.filetransfer.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import org.filetransfer.data.FileData;

//portName="ServicePort", serviceName="Service", 
@MTOM(enabled = true)
@WebService(endpointInterface = "org.filetransfer.services.ServiceInterface")
public class Service implements ServiceInterface {

	@Override
	public FileData downloadPDF(String name) {

		
		FileInputStream fileInputStream=null;
		 
		File file = new File("/home/bruno/Documentos/Facultad/" + name);
 
        byte[] bFile = new byte[(int) file.length()];
 
        try {
            //convert file into array of bytes
        	fileInputStream = new FileInputStream(file);
        	fileInputStream.read(bFile);
        	fileInputStream.close();
 			
        	FileData data = new FileData();
			data.file = bFile;
			data.name = name;
			return data;

		}catch (Exception e) {
			e.printStackTrace();
		}
        
		return null;
	}

	@Override
	public String uploadPDF(FileData data) {

		if (data != null) {
			return "Upload Successful";
		}

		return null;

	}

}
