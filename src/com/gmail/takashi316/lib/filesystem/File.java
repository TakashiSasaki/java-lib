package com.gmail.takashi316.lib.filesystem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class File extends java.io.File {
	static final private int BUFFER_SIZE = 4096;

	public File(String pathname) {
		super(pathname);
	}

	public File(java.io.File parent, String child) {
		super(parent, child);
	}

	public int copyFrom(BufferedInputStream bis) throws IOException {
		int count = 0;
		BufferedOutputStream bos = new BufferedOutputStream(
				new FileOutputStream(this));
		byte buffer[] = new byte[this.BUFFER_SIZE];
		int read_size;
		while ((read_size = bis.read(buffer)) != -1) {
			bos.write(buffer, 0, read_size);
			count += read_size;
		}
		bos.flush();
		bos.close();
		bis.close();
		return count;
	}// copyFrom

	public BufferedInputStream getBufferedInputStream()
			throws FileNotFoundException {
		return new BufferedInputStream(new FileInputStream(this));
	}
}// com.gmail.takashi316.lib.filesystem.File
