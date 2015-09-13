package com.muca.cinephile;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

public class RssFetcher {
	
    

	void fetch() throws IllegalArgumentException, FeedException,
			IOException {
		URL url = new URL("http://www.fandango.com/rss/newmovies.rss");
		HttpURLConnection httpcon = (HttpURLConnection) url.openConnection();
		// Reading the feed
		SyndFeedInput input = new SyndFeedInput();
		SyndFeed feed = input.build(new XmlReader(httpcon));
		List entries = feed.getEntries();
		Iterator itEntries = entries.iterator();

		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			String value = entry.getDescription().getValue();
			String image=Jsoup.parse(value).select("p>a>img").first()
					.attr("src");
			FilmNews filmNews = new FilmNews(entry.getTitle(), entry.getLink(), entry.getPublishedDate().toString(), image);
			FilmNewsList.add(filmNews);
		}
	}

	public static void main(String[] args) {

		try {
			new RssFetcher().fetch();
		} catch (IllegalArgumentException | FeedException | IOException e) {
			e.printStackTrace();
		}
	}
}
