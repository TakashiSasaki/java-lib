package com.gmail.takashi316.lib.filesystem;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 * 
 */
public class ClickableFolderTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}// setUpBeforeClass

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}// tearDownAfterClass

	private File currentDirectory;
	private ClickableFolder clickableFolder_023_jkl;
	private ClickableFolder clickableFolder_1_def;
	private ClickableFolder clickableFolder_1_ghi_100_200;
	private ClickableFolder clickableFolder_abc;
	private File readOnlyDirectory;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.currentDirectory = Directory.getCurrentDirectory();
		this.readOnlyDirectory = new File(this.currentDirectory, "readonly");
		this.clickableFolder_023_jkl = new ClickableFolder(new File(
				this.readOnlyDirectory, "023 jkl"), new int[] {});
		this.clickableFolder_1_def = new ClickableFolder(new File(
				this.readOnlyDirectory, "1 def"), new int[] {});
		this.clickableFolder_1_ghi_100_200 = new ClickableFolder(new File(
				this.readOnlyDirectory, "1 ghi 100 200"), new int[] {});
		this.clickableFolder_abc = new ClickableFolder(new File(
				this.readOnlyDirectory, "abc"), new int[] {});
	}// setUp

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}// tearDown

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#ClickableFolder(java.io.File, int[])}
	 * .
	 */
	@Test
	public final void testClickableFolder() {
		assertTrue(this.clickableFolder_023_jkl.isDirectory());
		assertTrue(this.clickableFolder_1_def.isDirectory());
		assertTrue(this.clickableFolder_1_ghi_100_200.isDirectory());
		assertTrue(this.clickableFolder_abc.isDirectory());
	}// testClickableFolder

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#get()}.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testGet() throws IOException {
		assertEquals(this.clickableFolder_023_jkl.get().size(), 6);
		assertEquals(this.clickableFolder_1_def.get().size(), 6);
		assertEquals(this.clickableFolder_1_ghi_100_200.get().size(), 6);
		assertEquals(this.clickableFolder_abc.get().size(), 6);
	}// testGet

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertEquals(this.clickableFolder_023_jkl.getName(), "jkl");
		assertEquals(this.clickableFolder_1_def.getName(), "def");
		assertEquals(this.clickableFolder_1_ghi_100_200.getName(), "ghi");
		assertEquals(this.clickableFolder_abc.getName(), "abc");
	}// testGetName

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#getNumber()}.
	 */
	@Test
	public final void testGetNumber() {
		assertEquals(this.clickableFolder_023_jkl.getNumber(), 23);
		assertEquals(this.clickableFolder_1_def.getNumber(), 1);
		assertEquals(this.clickableFolder_1_ghi_100_200.getNumber(), 1);
		assertEquals(this.clickableFolder_abc.getNumber(),
				ClickableFolder.UNDEFINED_NUMBER);
	}// testGetNumber

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#getX()}.
	 */
	@Test
	public final void testGetX() {
		assertEquals(this.clickableFolder_023_jkl.getX(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
		assertEquals(this.clickableFolder_1_def.getX(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
		assertEquals(this.clickableFolder_1_ghi_100_200.getX(), 100);
		assertEquals(this.clickableFolder_abc.getX(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
	}// testGetX

	/**
	 * Test method for
	 * {@link com.gmail.takashi316.lib.filesystem.ClickableFolder#getY()}.
	 */
	@Test
	public final void testGetY() {
		assertEquals(this.clickableFolder_023_jkl.getY(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
		assertEquals(this.clickableFolder_1_def.getY(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
		assertEquals(this.clickableFolder_1_ghi_100_200.getY(), 200);
		assertEquals(this.clickableFolder_abc.getY(),
				ClickableFolder.UNDEFINED_COORDINATE_VALUE);
	}// testGetY

}// ClickableFolderTest
