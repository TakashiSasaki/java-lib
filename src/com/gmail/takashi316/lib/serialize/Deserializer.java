package com.gmail.takashi316.lib.serialize;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer<T> {
	private T object;

	public Deserializer(byte[] byte_array) throws IOException,
			ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(
				byte_array);
		ObjectInputStream ois = new ObjectInputStream(bais);
		this.object = (T) (ois.readObject());
	}

	public T get() {
		return this.object;
	}
}
