package com.muca.cinephile;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.bson.Document;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.muca.cinephile.extractor.MynetExtractor;
import com.muca.cinephile.film.ComingSoon;
import com.muca.cinephile.film.OnCinemas;
import com.rometools.rome.io.FeedException;

public class Starter {
	MongoClient mongoClient = new MongoClient("52.26.3.224", 27017);

	/**
	 * Default constructor.
	 */
	public Starter() {
	}

	public void start() {
		try {
			fillFilmLists();
			MongoDatabase database = mongoClient.getDatabase("cinephile");
			MongoCollection<Document> onCinemasCollection = database
					.getCollection("OnCinemas");
			MongoCollection<Document> comingSoonCollection = database
					.getCollection("ComingSoon");
			onCinemasCollection.deleteMany(new Document());
			comingSoonCollection.deleteMany(new Document());
			insertJsonArrayIntoMongo(onCinemasCollection,
					OnCinemas.getInstance());
			insertJsonArrayIntoMongo(comingSoonCollection,
					ComingSoon.getInstance());
		} catch (IllegalArgumentException | IOException | FeedException e) {
			e.printStackTrace();
		}

	}

	public void fillFilmLists() throws IOException, IllegalArgumentException,
			FeedException {
		MynetExtractor me = new MynetExtractor();
		me.fillComingSoon("http://sinema.mynet.com/rss/RSS-gelecekprogram/rss.xml");
		me.fillOnCinemas("http://sinema.mynet.com/rss/RSS-vizyon/rss.xml");
	}

	public void insertJsonArrayIntoMongo(MongoCollection<Document> collection,
			JsonArray array) {
		Iterator<JsonElement> iterator = array.iterator();
		while (iterator.hasNext()) {
			JsonObject object = iterator.next().getAsJsonObject();
			collection.insertOne(Document.parse(object.toString()));

		}

	}

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors
				.newSingleThreadScheduledExecutor();
		executor.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				new Starter().start();
			}
		}, 0, 1, TimeUnit.DAYS);

	}

}
