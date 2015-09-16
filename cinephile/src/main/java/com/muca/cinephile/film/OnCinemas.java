package com.muca.cinephile.film;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class OnCinemas {

	private OnCinemas() {
		onCinemas = new JsonArray();
	}

	private static JsonArray onCinemas;

	static void add(Film film) {

		String json = new Gson().toJson(film);
		getInstance().add(
				new Gson().fromJson(json,
						JsonObject.class));
	}

	public static JsonArray getInstance() {
		if (onCinemas == null) {
			new OnCinemas();
		}
		return onCinemas;
	}

}
