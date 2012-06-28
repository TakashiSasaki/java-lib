package com.gmail.takashi316.lib.string;

import junit.framework.TestCase;

public class StringArrayTest extends TestCase {
	StringArray stringArray0;
	StringArray stringArray1;
	StringArray stringArray2;
	StringArray stringArray3;

	@Override
	protected void setUp() throws Exception {
		this.stringArray0 = new StringArray(new String[] {});
		this.stringArray1 = new StringArray(new String[] { "abc" });
		this.stringArray2 = new StringArray(new String[] { "de", "fg" });
		this.stringArray3 = new StringArray(new String[] { "h", "i", "j" });
		super.setUp();
	}

	public void testConcat() throws Exception {
		assertEquals("", this.stringArray0.concat(""));
		assertEquals("", this.stringArray0.concat(";"));
		assertEquals("abc", this.stringArray1.concat(""));
		assertEquals("abc", this.stringArray1.concat("x"));
		assertEquals("de+fg", this.stringArray2.concat("+"));
		assertEquals("defg", this.stringArray2.concat(""));
		assertEquals("hij", this.stringArray3.concat(""));
		assertEquals("h^i^j", this.stringArray3.concat("^"));
	}
}
