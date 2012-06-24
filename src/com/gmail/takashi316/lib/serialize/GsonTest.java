package com.gmail.takashi316.lib.serialize;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GsonTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int[] data = { 314, 159, 265 };
		GsonSerializer<int[]> json_serializer = new GsonSerializer<int[]>(data);
		String json_string = json_serializer.get();
		assertEquals("[314,159,265]", json_string);
		System.out.println(json_string);
		GsonDeserializer<int[]> json_deserializer = new GsonDeserializer<int[]>(
				json_string);
		assertEquals(json_deserializer.getClassT1().getCanonicalName(), "int[]");
		assertEquals(json_deserializer.getClassT1(), int[].class);
		assertEquals(json_deserializer.getClassT2().getCanonicalName(), "int[]");
		assertEquals(json_deserializer.getClassT2(), int[].class);
		assertEquals(json_deserializer.getClassT1(), json_deserializer.getClassT2());
		int[] deserialized_data = json_deserializer.get();

		for (int i = 0; i < data.length; ++i) {
			assertEquals(data[i], deserialized_data[i]);
		}// for
	}// test
}// JsonTest
