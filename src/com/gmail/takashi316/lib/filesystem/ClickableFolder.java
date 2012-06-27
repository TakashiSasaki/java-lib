package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ClickableFolder extends File {
	public static final int UNDEFINED_NUMBER = -1;
	public static final int UNDEFINED_COORDINATE_VALUE = -1;
	private int[] idSequence;
	private String rawName;
	private String name;
	private int number = UNDEFINED_NUMBER;
	private int x = UNDEFINED_COORDINATE_VALUE;
	private int y = UNDEFINED_COORDINATE_VALUE;

	public ClickableFolder(File directory_path, int[] parent_sequence) {
		super(directory_path.toString());
		this.rawName = directory_path.getName();
		parseRawName();
		this.idSequence = new int[parent_sequence.length + 1];
		for (int i = 0; i < parent_sequence.length; ++i) {
			this.idSequence[i] = parent_sequence[i];
		}// for
		this.idSequence[parent_sequence.length] = number;

	}// the constructor

	private void parseRawName() {
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
	}// parseDirectoryName

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
