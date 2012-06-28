package com.gmail.takashi316.lib.filesystem;

import java.io.BufferedInputStream;
import java.io.IOException;

import junit.framework.TestCase;

public class FileTest extends TestCase {
	final static private String WRITEABLE_DIRECTORY_NAME = "writeable";
	final static private String READONLY_DIRECTORY_NAME = "readonly";
	Directory currentDirectory;
	Directory writeableDirectory;
	Directory readOnlyDirectory;
	File file;

	@Override
	protected void setUp() throws Exception {
		this.currentDirectory = new Directory();
		this.writeableDirectory = new Directory(this.currentDirectory,
				FileTest.WRITEABLE_DIRECTORY_NAME);
		if (!writeableDirectory.exists()) {
			this.writeableDirectory.mkdir();
		}
		this.readOnlyDirectory = new Directory(this.currentDirectory,
				FileTest.READONLY_DIRECTORY_NAME);
		assertTrue(this.writeableDirectory.exists());
		this.writeableDirectory.emptyFiles();
		assertEquals(0, this.writeableDirectory.countFiles());
		super.setUp();
	}// setUp

	@SuppressWarnings("javadoc")
	public final void testCopyFile() throws IOException {
		File lena = new File(this.readOnlyDirectory, "1 ghi 100 200/lena.bmp");
		assertTrue(lena.isFile());
		assertTrue(lena.length() > 0);
		BufferedInputStream bis = lena.getBufferedInputStream();
		File lena2 = new File(this.writeableDirectory, "lena2.bmp");
		assertTrue(!lena2.exists());
		lena2.copyFrom(bis);
		assertTrue(lena2.exists());
		assertEquals(lena.length(), lena2.length());
	}// testCopyFile

	@Override
	protected void tearDown() throws Exception {
		this.writeableDirectory.emptyFiles();
		assertEquals(0, this.writeableDirectory.countFiles());
		super.tearDown();
	}// tearDown
}// FileTest
