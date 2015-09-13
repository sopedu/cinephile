package com.muca.cinephile;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class FilmNewsList {

	private FilmNewsList() {
		filmNewsList = new JsonArray();
	}

	private static JsonArray filmNewsList;

	static void add(FilmNews filmNews) {

		getInstance().add(
				new Gson().fromJson(new Gson().toJson(filmNews),
						JsonObject.class));
	}

	public static JsonArray getInstance() {
		if (filmNewsList == null) {
			new FilmNewsList();
		}
		return filmNewsList;
	}

}
