package com.gmail.takashi316.lib.string;

import java.util.HashMap;

import junit.framework.TestCase;

public class StringArrayTest extends TestCase {
	private StringArray stringArray0;
	private StringArray stringArray1;
	private StringArray stringArray2;
	private StringArray stringArray3;
	private StringArray stringArray4;

	@Override
	protected void setUp() throws Exception {
		this.stringArray0 = new StringArray(new String[] {});
		this.stringArray1 = new StringArray(new String[] { "abc" });
		this.stringArray2 = new StringArray(new String[] { "de", "fg" });
		this.stringArray3 = new StringArray(new String[] { "h", "i", "j" });

		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("takashi", "sasaki");
		hm.put("alpha", "beta");
		this.stringArray4 = new StringArray(hm, "+");
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
		String concat4 = this.stringArray4.concat("-");
		assertTrue("takashi+sasaki-alpha+beta".compareTo(concat4) == 0
				|| "alpha+beta-takashi+sasaki".compareTo(concat4) == 0);
	}// testConcat

}
