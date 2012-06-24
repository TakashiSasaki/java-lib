package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ClickableFolder {
	public static final int ID_UNDEFINED = 0;
	public static final int ID_NULL = -1;
	private int[] idSequence;
	private String rawName;
	private String name;
	private int number = ID_UNDEFINED;
	private int x = -1;
	private int y = -1;

	public ClickableFolder(File directory_path, int[] parent_sequence) {
		this.rawName = directory_path.getName();
		String[] parts = this.rawName.split("[ ]+");
		if (parts.length == 1) {
			this.name = parts[0];
		}// if
		if (parts.length == 2) {
			this.number = Integer.parseInt(parts[0]);
			this.name = parts[1];
		}// if
		if (parts.length == 4) {
			this.number = Integer.parseInt(parts[0]);
			this.name = parts[1];
			this.x = Integer.parseInt(parts[2]);
			this.y = Integer.parseInt(parts[3]);
		}// if
		this.idSequence = new int[parent_sequence.length + 1];
		for (int i = 0; i < parent_sequence.length; ++i) {
			this.idSequence[i] = parent_sequence[i];
		}
		this.idSequence[parent_sequence.length] = number;
	}// the constructor

	public HashMap<String, Object> get() throws IOException {
		HashMap<String, Object> hash_map = new HashMap<String, Object>();
		hash_map.put("name", this.name);
		hash_map.put("number", this.number);
		hash_map.put("rawName", this.rawName);
		hash_map.put("x", this.x);
		hash_map.put("y", this.y);
		for (int i = 0; i < this.idSequence.length; ++i) {
			hash_map.put("level" + (i + 1), this.idSequence[i]);
		}// for
		return hash_map;
	}// get

	@SuppressWarnings("javadoc")
	public String getName() {
		return this.name;
	}// getName

	@SuppressWarnings("javadoc")
	public int getNumber() {
		return this.number;
	}// getNumber

	@SuppressWarnings("javadoc")
	public int getX() {
		return this.x;
	}// getX

	@SuppressWarnings("javadoc")
	public int getY() {
		return this.y;
	}// getY
}// ClickableFolder
