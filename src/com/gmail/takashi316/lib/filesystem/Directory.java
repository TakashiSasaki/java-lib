package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Directory extends File {

	final private Pattern movieFilePattern = Pattern.compile("^.+\\.m4v$");
	final private Pattern htmlFilePattern = Pattern
			.compile("^(.+\\.html)|(.+\\.htm)$");
	final private Pattern textFilePattern = Pattern.compile("^.+\\.txt$");
	final private Pattern imageFilePattern = Pattern
			.compile("^(.+\\.jpg)|(.+\\.jpeg)|(.+\\.png)$");

	public Directory() {
		super((new File(".")).getAbsoluteFile().getParent());
	}// default constructor

	public ArrayList<File> listMatchedFiles(Pattern pattern) {
		ArrayList<File> files = new ArrayList<File>();
		for (File f : this.listFiles()) {
			Matcher m = pattern.matcher(f.getName());
			if (m.find()) {
				files.add(f);
			}// if
		}// for
		return files;
	}

	public ArrayList<File> listImages() {
		return listMatchedFiles(this.imageFilePattern);
	}
}// Directory

