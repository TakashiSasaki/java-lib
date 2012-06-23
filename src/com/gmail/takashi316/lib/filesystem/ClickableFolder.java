package com.gmail.takashi316.lib.filesystem;

import java.io.File;

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

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return this.y;
	}
}// ClickableFolder
