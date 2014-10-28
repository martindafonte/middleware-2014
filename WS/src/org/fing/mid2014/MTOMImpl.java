package org.fing.mid2014;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.jws.WebService;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.MTOM;

//Service Implementation Bean
@MTOM(enabled =true)
@WebService(endpointInterface = "org.fing.mid2014.ServicioMTOM")
public class MTOMImpl implements ServicioMTOM {

	@Override
	public ImageData downloadImage(String name) {

		try {

			File image = new File("c:\\images\\" + name);
			ImageData ret = new ImageData();
			ret.imagen =ImageIO.read(image);
			ret.name = name;
			return ret;

		} catch (IOException e) {

			e.printStackTrace();
			return null;

		}
	}

	@Override
	public String uploadImage(ImageData data) {

		if (data != null) {
			// store somewhere
			return "Upload Successful";
		}

		throw new WebServiceException("Upload Failed!");

	}

}
