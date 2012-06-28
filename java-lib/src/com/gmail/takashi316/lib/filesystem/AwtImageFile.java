package com.gmail.takashi316.lib.filesystem;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.awt.Graphics2D;
import java.awt.Image;
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
public class AwtImageFile extends ImageFile<Image> {

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

	@Override
	public Image getImage() throws IOException {
		BufferedImage buffered_image = ImageIO.read(this);
		return buffered_image;
	}// getImage

	/*
	 * this code fragment is based on the code at
	 * http://d.hatena.ne.jp/mono-hate/20080215/1203082663 (ori’s diary).
	 * 
	 * @see com.gmail.takashi316.lib.filesystem.ImageFile#getResizedImage(int,
	 * int)
	 */
	@Override
	public Image getResizedImage(int target_width, int target_height)
			throws IOException {
		BufferedImage buffered_image = ImageIO.read(this);
		BufferedImage resized_buffer_image = null;
		if (buffered_image.getColorModel() instanceof IndexColorModel) {
			resized_buffer_image = new BufferedImage(target_width,
					target_height, buffered_image.getType(),
					(IndexColorModel) buffered_image.getColorModel());
		} else {
			if (buffered_image.getType() == 0) {
				resized_buffer_image = new BufferedImage(target_width,
						target_height, BufferedImage.TYPE_4BYTE_ABGR_PRE);
			} else {
				resized_buffer_image = new BufferedImage(target_width,
						target_height, buffered_image.getType());
			}
		}// if

		double sx = (double) this.width / resized_buffer_image.getWidth();
		double sy = (double) this.height / resized_buffer_image.getHeight();
		AffineTransform trans = AffineTransform.getScaleInstance(sx, sy);

		if (resized_buffer_image.getColorModel().hasAlpha()
				&& resized_buffer_image.getColorModel() instanceof IndexColorModel) {
			int transparentPixel = ((IndexColorModel) resized_buffer_image
					.getColorModel()).getTransparentPixel();
			for (int i = 0; i < resized_buffer_image.getWidth(); ++i) {
				for (int j = 0; j < resized_buffer_image.getHeight(); ++j) {
					resized_buffer_image.setRGB(i, j, transparentPixel);
				}// for
			}// for
		}// if

		Graphics2D g2 = (Graphics2D) resized_buffer_image.createGraphics();
		g2.drawImage(buffered_image, trans, null);
		g2.dispose();

		return resized_buffer_image;
	}// getResizedImage

}// AwtImageFile
