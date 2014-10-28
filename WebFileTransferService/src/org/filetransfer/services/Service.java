package org.filetransfer.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

import org.filetransfer.data.FileData;

@MTOM(enabled = true)
@WebService(endpointInterface = "org.filetransfer.services.ServiceInterface")
public class Service implements ServiceInterface {

	@Override
	public FileData downloadPDF(String name) {

		FileInputStream fileInputStream = null;

		File file = new File("/home/bruno/Documentos/" + name);

		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

			FileData data = new FileData();
			data.file = bFile;
			data.name = name;
			return data;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String uploadPDF(FileData data) {

		if (data != null) {
			try {
				File f = new File("/home/bruno/Descargas/" + data.name);
				FileOutputStream out = new FileOutputStream(f);
				out.write(data.file);
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			return "Upload Successful";
		}

		return null;

	}

}
