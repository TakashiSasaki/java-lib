package com.gmail.takashi316.lib.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StringArray extends ArrayList<String> {
	String[] strings;

	public StringArray(ArrayList<String> array_list_string) {
		this.strings = array_list_string.toArray(new String[] {});
	}

	public StringArray(String[] strings_) {
		this.strings = strings_;
	}

	public StringArray(Map<String, String> string_pairs, String separator) {
		ArrayList<String> als = new ArrayList<String>();
		for (String key : string_pairs.keySet()) {
			als.add(key + separator + string_pairs.get(key));
		}// for
		this.strings = als.toArray(new String[] {});
	}// a constructor

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
