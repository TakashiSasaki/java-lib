package com.gmail.takashi316.lib.math;

public class Random {

	static java.util.Random random;

	static private long seed() {
		Object object = new Object();
		int hash_code = object.hashCode();
		long current_time_mills = System.currentTimeMillis();
		long free_memory = Runtime.getRuntime().freeMemory();
		long seed = hash_code + current_time_mills + free_memory;
		return seed;
	}// seed

	static double getDouble(double lower_limit, double upper_limit) {
		double range = upper_limit - lower_limit;
		double r = Math.random();
		return r * range + lower_limit;
	}// getDouble

	static double getInt(int lower_limit, int upper_limit) {
		if (random == null) {
			random = new java.util.Random(seed());
		}

		int r = random.nextInt(upper_limit - lower_limit);
		return r + lower_limit;
	}// getInt

	static double getInt() {
		if (random == null) {
			random = new java.util.Random(seed());
		}
		return random.nextInt();
	}// getInt
}// Random
