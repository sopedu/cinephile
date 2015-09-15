package com.muca.cinephile;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public interface FilmExtractor {

	public abstract String extractDescription();

	public abstract String extractActors() throws IOException;

	public abstract String extractTitle();

	public abstract String extractImage();

	public abstract String extractGenre() throws IOException;

	public abstract String extractDirector() throws IOException;

	void fillFrequentFields(SyndEntry entry) throws IOException;

	default List getEntries(String rssUri) throws MalformedURLException,
			IOException, IllegalArgumentException, FeedException {
		URL url = new URL(rssUri);
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List entries = feed.getEntries();
		return entries;	
	}
}
