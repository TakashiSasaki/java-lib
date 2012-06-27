/**
 * 
 */
package com.gmail.takashi316.lib.filesystem;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 * 
 */
public class AwtImageFileTest {
	final Directory currentDirectory = new Directory();
	ImageFile imageFile;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		this.imageFile = new AwtImageFile(new File(this.currentDirectory,
				"readonly/1 ghi 100 200/lena.bmp").toString());
	}// setUp

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.AwtImageFile#AwtImageFile(java.lang.String)}
	 * .
	 */
	@Test
	public final void testAwtImageFile() {
		assertEquals(this.imageFile.height, 512);
		assertEquals(this.imageFile.width, 512);
	}// testAwtImageFile

}// AwtImageFileTest
