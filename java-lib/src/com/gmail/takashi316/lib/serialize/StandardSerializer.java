package com.gmail.takashi316.lib.serialize;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StandardSerializer {
	private byte[] byteArray;

	public StandardSerializer(Serializable serializable_) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(serializable_);
		this.byteArray = baos.toByteArray();
	}// the constructor

	public byte[] get() {
		return this.byteArray;
	}
}// Serializer
