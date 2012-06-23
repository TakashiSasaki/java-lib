package com.gmail.takashi316.lib.serialize;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

public class GsonDeserializer<T> {
	private T deserializedObject;

	@SuppressWarnings("unchecked")
	public GsonDeserializer(String json_string) {
		GsonBuilder gson_builder = new GsonBuilder();
		Gson gson = gson_builder.create();
		Class<?> t = this.getClassT();
		this.deserializedObject = (T) gson.fromJson(json_string, t);
	}// the constructor

	private void register(GsonBuilder gson_builder) {
		IntegerSerializer integer_serializer = new IntegerSerializer();
		gson_builder.registerTypeAdapter(Integer.class, integer_serializer);
		IntegerDeserializer integer_deserializer = new IntegerDeserializer();
		gson_builder.registerTypeAdapter(Integer.class, integer_deserializer);
	}

	public Class<?> getClassT(T... dummy) {
		return dummy.getClass().getComponentType();
	}

	public T get() {
		return this.deserializedObject;
	}// get

	public class IntegerDeserializer implements
			com.google.gson.JsonDeserializer<Integer> {
		@Override
		public Integer deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			String s = json.getAsJsonPrimitive().getAsString();
			return new Integer(s);
		}// deserialize
	}// IntegerDeserializer

	public class IntegerSerializer implements
			com.google.gson.JsonSerializer<Integer> {
		public JsonElement serialize(Integer src, Type typeOfSrc,
				JsonSerializationContext context) {
			return new JsonPrimitive(src.toString());
		}
	}

}// JsonSerializer

