package com.gmail.takashi316.lib.filesystem;

import java.io.File;

public class Directory {

	public static final File getCurrentDirectory() {
		final File current_directory = new File(".");
		return new File(current_directory.getAbsoluteFile().getParent());
	}// getCurrentDirectory

}// Directory

