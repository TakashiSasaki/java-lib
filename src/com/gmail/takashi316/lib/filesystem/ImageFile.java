package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.io.IOException;

/**
 * @param <T>
 *            A generic class represents an image. An utility class to handle an
 *            image such as java.awt.Image and android.graphics.Bitmap .
 * 
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 */
@SuppressWarnings("serial")
public abstract class ImageFile<T> extends File {
	protected int width = -1;
	protected int height = -1;

	abstract protected void getSize() throws IOException;

	/**
	 * @return loaded image from a file
	 * @throws IOException
	 */
	abstract public T getImage() throws IOException;

	/**
	 * @param target_width
	 * @param target_height
	 * @return resized image from a file
	 * @throws IOException
	 */
	abstract public T getResizedImage(int target_width, int target_height)
			throws IOException;

	@SuppressWarnings("javadoc")
	public ImageFile(String pathname) throws IOException {
		super(pathname);
		getSize();
	}// a constructor

	@SuppressWarnings("javadoc")
	public ImageFile(File parent, String child) throws IOException {
		super(parent, child);
		getSize();
	}// a constructor

	@SuppressWarnings("javadoc")
	public int getWidth() {
		return this.width;
	}// getWidth

	@SuppressWarnings("javadoc")
	public int getHeight() {
		return this.height;
	}// getHeight

}// ImageFile
