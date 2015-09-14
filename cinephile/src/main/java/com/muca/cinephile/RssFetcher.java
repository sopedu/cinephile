package com.muca.cinephile;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;

import com.google.gson.JsonArray;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RssFetcher {

	void fetchOnCinemas() throws IllegalArgumentException, FeedException,
			IOException {
		URL url = new URL("http://rss.beyazperde.com/filmler/bunlar");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List entries = feed.getEntries();
		Iterator itEntries = entries.iterator();

		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			String description = Jsoup.parse(entry.getDescription().getValue())
					.select("p").first().text();
			String image = entry.getEnclosures().get(0).getUrl();
			Film film = new Film(entry.getTitle(), entry.getLink(),
					description, image);
			OnCinemas.add(film);
			System.out.println(film.toString());
		}
	}

	void fetchComingSoon() throws IllegalArgumentException, FeedException,
			IOException {
		URL url = new URL("http://rss.beyazperde.com/filmler/pekyakinda");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List entries = feed.getEntries();
		Iterator itEntries = entries.iterator();

		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			String description = Jsoup.parse(entry.getDescription().getValue())
					.select("p").first().text();
			String image = entry.getEnclosures().get(0).getUrl();
			Film film = new Film(entry.getTitle(), entry.getLink(),
					description, image);
			ComingSoon.add(film);
			System.out.println(film.toString());
		}
	}

	public static void main(String[] args) {

		try {
			new RssFetcher().fetchOnCinemas();
			System.out.println("-----------------------------------------------");
			new RssFetcher().fetchComingSoon();
		} catch (IllegalArgumentException | FeedException | IOException e) {
			e.printStackTrace();
		}
	}
}
