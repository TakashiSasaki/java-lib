package com.gmail.takashi316.lib.filesystem;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * An implementation of ImageFile using AWT. Note that AWT does not supported in
 * standard Android platform.
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 * 
 */
@SuppressWarnings("serial")
public class AwtImageFile extends ImageFile {

	@SuppressWarnings("javadoc")
	public AwtImageFile(String pathname) throws IOException {
		super(pathname);
	}// a constructor

	@Override
	protected void getSize() throws IOException {
		BufferedImage buffered_image = ImageIO.read(this);
		this.height = buffered_image.getHeight();
		this.width = buffered_image.getWidth();
	}// getSize

}// AwtImageFile
