package com.gmail.takashi316.lib.string;

import java.util.ArrayList;

public class StringArray extends ArrayList<String> {
	String[] strings;

	public StringArray(ArrayList<String> array_list_string) {
		this.strings = (String[]) array_list_string.toArray();
	}

	public StringArray(String[] strings_) {
		this.strings = strings_;
	}

	public String concat(String separater) {
		StringBuilder sb = new StringBuilder();
		String to_be_appended = null;
		for (String s : this.strings) {
			if (to_be_appended != null) {
				sb.append(to_be_appended).append(separater);
				to_be_appended = s;
			} else {
				to_be_appended = s;
			}
		}// for
		if (to_be_appended != null) {
			sb.append(to_be_appended);
		}// if
		return sb.toString();
	}// concat

}// StringArray
