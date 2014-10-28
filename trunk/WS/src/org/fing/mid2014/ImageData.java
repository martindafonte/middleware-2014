package org.fing.mid2014;

import java.awt.Image;

import javax.xml.bind.annotation.XmlMimeType;

public class ImageData {
	@XmlMimeType("image/jpeg")
	public Image imagen;
	public String name;
}
