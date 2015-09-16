package com.muca.cinephile.film;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ComingSoon {

	private ComingSoon() {
		comingSoon= new JsonArray();
	}

	private static JsonArray comingSoon;

	static void add(Film film) {

		getInstance().add(
				new Gson().fromJson(new Gson().toJson(film),
						JsonObject.class));
	}

	public static JsonArray getInstance() {
		if (comingSoon == null) {
			new ComingSoon();
		}
		return comingSoon;
	}

}