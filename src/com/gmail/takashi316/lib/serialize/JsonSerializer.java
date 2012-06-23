package com.gmail.takashi316.lib.serialize;

import com.google.gson.Gson;

public class JsonSerializer<T> {
	String jsonString;

	public JsonSerializer(T t) {
		Gson gson = new Gson();
		this.jsonString = gson.toJson(t);
	}// the constructor

	public String get() {
		return this.jsonString;
	}// get

}// JsonSerializer
