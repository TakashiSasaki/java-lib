package com.gmail.takashi316.lib.serialize;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeserializerTest {
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
		int[] data = { 191, 23, 9, 5 };
		byte[] byte_array;
		try {
			Serializer serializer = new Serializer(data);
			byte_array = serializer.get();
			System.out.println(byte_array.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			return;
		}// try

		int[] deserialized_data;
		try {
			Deserializer<int[]> deserializer = new Deserializer<int[]>(
					byte_array);
			deserialized_data = deserializer.get();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
			return;
		}

		for (int i = 0; i < data.length; ++i) {
			assertEquals(data[i], deserialized_data[i]);
		}
	}// test
}
