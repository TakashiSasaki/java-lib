package com.gmail.takashi316.lib.serialize;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

/**
 * @author Takashi SASAKI {@link "http://twitter.com/TakashiSasaki"}
 * 
 * @param <T>
 *            Generic class that should be deserialized.
 */
public class GsonDeserializer<T> {
	private T deserializedObject;
	private Class<?> classT;

	/**
	 * @param json_string String
	 * @param dummy
	 */
	@SuppressWarnings("unchecked")
	public GsonDeserializer(String json_string, T... dummy) {
		this.classT = dummy.getClass().getComponentType();
		GsonBuilder gson_builder = new GsonBuilder();
		Gson gson = gson_builder.create();
		// Class<?> t = this.getClassT();
		this.deserializedObject = (T) gson.fromJson(json_string, classT);
	}// the constructor

	/*
	 * It is not used for now because registerTypeAdapter does not accept a
	 * serializer and deserializer for wrapper classes.
	 */
	@SuppressWarnings("unused")
	private void register(GsonBuilder gson_builder) {
		IntegerSerializer integer_serializer = new IntegerSerializer();
		gson_builder.registerTypeAdapter(Integer.class, integer_serializer);
		IntegerDeserializer integer_deserializer = new IntegerDeserializer();
		gson_builder.registerTypeAdapter(Integer.class, integer_deserializer);
	}

	/**
	 * @param dummy
	 *            It is not intended to be given explicitly. Give it no
	 *            parameter.
	 * @return Class object of T.
	 */
	public Class<?> getClassT1(T... dummy) {
		return dummy.getClass().getComponentType();
	}// getClass

	/**
	 * getClassT1 and getClassT2 should return the same Class object, but
	 * actually not.
	 * 
	 * @return class object of T which is detected at the constructor.
	 */
	public Class<?> getClassT2() {
		return this.classT;
	}

	/**
	 * @return deserialized object
	 */
	public T get() {
		return this.deserializedObject;
	}// get

	/**
	 * An example class of Gson custom deserializer. It should not be used
	 * because wrapper class needs no custom deserializer.
	 * 
	 * @author Takashi SASAKI
	 */
	public class IntegerDeserializer implements
			com.google.gson.JsonDeserializer<Integer> {
		@Override
		public Integer deserialize(JsonElement json, Type typeOfT,
				JsonDeserializationContext context) throws JsonParseException {
			String s = json.getAsJsonPrimitive().getAsString();
			return new Integer(s);
		}// deserialize
	}// IntegerDeserializer

	/**
	 * An esample class of Gson custom serializer. It should not be used because
	 * wrapper class needs no custom serializer.
	 * 
	 * @author Takashi
	 */
	public class IntegerSerializer implements
			com.google.gson.JsonSerializer<Integer> {
		public JsonElement serialize(Integer src, Type typeOfSrc,
				JsonSerializationContext context) {
			return new JsonPrimitive(src.toString());
		}
	}

}// JsonSerializer

