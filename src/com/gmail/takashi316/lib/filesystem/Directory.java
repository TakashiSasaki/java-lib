package com.gmail.takashi316.lib.filesystem;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Takashi SASAKI <a href="http://twitter.com/TakashiSasaki"/>
 * 
 */
public class Directory extends File {

	final private Pattern movieFilePattern = Pattern.compile("^.+\\.m4v$");
	final private Pattern htmlFilePattern = Pattern
			.compile("^(.+\\.html)|(.+\\.htm)$");
	final private Pattern textFilePattern = Pattern.compile("^.+\\.txt$");
	final private Pattern imageFilePattern = Pattern
			.compile("^(.+\\.jpg)|(.+\\.jpeg)|(.+\\.png)$");

	@SuppressWarnings("javadoc")
	public Directory() {
		super((new File(".")).getAbsoluteFile().getParent());
	}// default constructor

	@SuppressWarnings("javadoc")
	public Directory(File parent) {
		super(parent.getAbsolutePath());
	}// a constructor taking File object

	@SuppressWarnings("javadoc")
	public Directory(File parent, String child) {
		super(parent, child);
	}// a constructor taking parent and child

	public ArrayList<File> listMatchedFiles(Pattern pattern) {
		ArrayList<File> files = new ArrayList<File>();
		for (File f : this.listFiles()) {
			Matcher m = pattern.matcher(f.getName());
			if (m.find()) {
				files.add(f);
			}// if
		}// for
		return files;
	}// listMatchedFiles

	public void emptyFiles() {
		for (File f : this.listFiles()) {
			if (f.exists() && f.isFile()) {
				f.delete();
			}// if
		}// for
	}// emptyFiles

	@SuppressWarnings("javadoc")
	public int countFiles() {
		int count = 0;
		for (File f : this.listFiles()) {
			if (f.exists() && f.isFile()) {
				count++;
			}// if
		}// for
		return count;
	}// countFiles

	@SuppressWarnings("javadoc")
	public Directory getChild(String child) {
		return new Directory(this, child);
	}

	@SuppressWarnings("javadoc")
	public ArrayList<File> listImages() {
		return listMatchedFiles(this.imageFilePattern);
	}// listImages

	@SuppressWarnings("javadoc")
	public ArrayList<File> listMovies() {
		return listMatchedFiles(this.movieFilePattern);
	}

	@SuppressWarnings("javadoc")
	public ArrayList<File> listHtmlFiles() {
		return listMatchedFiles(this.htmlFilePattern);
	}

	@SuppressWarnings("javadoc")
	public ArrayList<File> listTextFiles() {
		return listMatchedFiles(this.textFilePattern);
	}

}// Directory

