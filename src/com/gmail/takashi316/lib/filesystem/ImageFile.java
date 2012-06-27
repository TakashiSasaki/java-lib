package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.io.IOException;

public abstract class ImageFile extends File {
	protected int width = -1;
	protected int height = -1;

	abstract protected void getSize() throws IOException;

	public ImageFile(String pathname) throws IOException {
		super(pathname);
		getSize();
	}// a constructor

	@SuppressWarnings("javadoc")
	public int getWidth() {
		return this.width;
	}

	@SuppressWarnings("javadoc")
	public int getHeight() {
		return this.height;
	}
}// ImageFile
