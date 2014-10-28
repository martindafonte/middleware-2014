import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.filetransfer.services.FileData;
import org.filetransfer.services.ServiceInterface;
import org.filetransfer.services.ServiceService;

public class Main {

	public static void main(String[] args) {

		System.out.println(args != null ? "NO ES NULL ARGS" : "ES NULL");
		System.out.println("LENGTH: " + args.length);

		int i = 0;
		for (String a : args) {
			System.out.println("(" + (i++) + "): " + a);
		}

		if (args.length < 1) {
			System.out.println("Syntax UPLOAD: main.jar up file_url");
			System.out
					.println("Syntax DOWNLOAD: main.jar down file_name file_download_url");
			return;
		}

		String cmd = args[0];
		String name = args[1];
		String down;

		// validate
		if (!cmd.equals("up") && !cmd.equals("down")) {
			System.out.println("Invalid command: " + cmd);
			return;
		}

		if (cmd.equals("up")) {

			if (args.length != 2) {
				System.out.println("Syntax UPLOAD: main.jar up file_url");
				System.out
						.println("Syntax DOWNLOAD: main.jar down file_name file_download_url");
				return;
			}

			upload(name);

		} else {

			if (args.length != 3) {
				System.out.println("Syntax UPLOAD: main.jar up file_url");
				System.out
						.println("Syntax DOWNLOAD: main.jar down file_name file_download_url");
				return;
			}
			down = args[2];

			download(name, down);

		}

		return;
	}

	public static void upload(String name) {

		Service serv;
		try {
			serv = ServiceService
					.create(new URL("http://localhost:8080/WebFileTransferService/Service?wsdl"),
							new QName("http://services.filetransfer.org/", "ServiceService"));

			ServiceInterface port = serv.getPort(ServiceInterface.class);

			// enable MTOM in client
			BindingProvider bp = (BindingProvider) port;
			SOAPBinding binding = (SOAPBinding) bp.getBinding();
			binding.setMTOMEnabled(true);

			FileInputStream fileInputStream = null;

			File file = new File(name);
			FileDataSource fileDS = new FileDataSource(file);

			byte[] bFile = new byte[(int) file.length()];

			try {

				fileInputStream = new FileInputStream(file);
				fileInputStream.read(bFile);
				fileInputStream.close();

				FileData data = new FileData();
				DataHandler dataHandler = new DataHandler(fileDS);
				data.setFile(dataHandler);
				data.setName(name);

				port.uploadPDF(data);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void download(String name, String down) {

		Service serv;
		try {
			serv = ServiceService
					.create(new URL("http://localhost:8080/WebFileTransferService/Service?wsdl"),
							new QName("http://services.filetransfer.org/", "ServiceService"));

			ServiceInterface port = serv.getPort(ServiceInterface.class);

			// enable MTOM in client
			BindingProvider bp = (BindingProvider) port;
			SOAPBinding binding = (SOAPBinding) bp.getBinding();
			binding.setMTOMEnabled(true);

			try {

				FileData data = port.downloadPDF(name);
				InputStream in = data.getFile().getInputStream();
				File downloadFile = new File(down);
				FileOutputStream out = new FileOutputStream(downloadFile);

				byte[] buff = new byte[256];
				int off = 0;
				int length = 0;
				while ((length = in.read(buff, 0, 256)) > 0) {
					out.write(buff, 0, length);
					off += length;
				}

				in.close();
				out.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see java.lang.Object#Object()
	 */
	public Main() {
		super();
	}

}