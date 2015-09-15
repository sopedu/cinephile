package com.muca.cinephile;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;

public interface OnCinemasExtractor extends FilmExtractor {
	String extractScore() throws IOException;
	
	static Logger logger = Logger
			.getLogger(ComingSoonExtractor.class.getName());
	

	default void registerOnCinemas() throws IOException, CantReadEntries {
		String extractTitle;
		try {
			extractTitle = extractTitle();
		} catch (Exception e) {
			logger.error("Can't read title there must be problem.");
			throw new CantReadEntries();
		}
		String extractActors;
		try {
			extractActors = extractActors();
		} catch (Exception e) {
			extractActors = "";
			logger.error("No actor found for film called :" + extractTitle);
		}
		String extractScore;
		try {
			extractScore = extractScore();
		} catch (Exception e) {
			extractScore = "0";
			logger.error("No score found for film called :" + extractTitle);
		}
		String extractImage;
		try {
			extractImage = extractImage();
		} catch (Exception e) {
			extractImage = "";
			logger.error("No image found for film called :" + extractTitle);
		}
		String extractDescription;
		try {
			extractDescription = extractDescription();
		} catch (Exception e) {
			extractDescription="";
			logger.error("No description found for film called :" + extractTitle);
		}
		OnCinemasFilm onCinemasFilm = new OnCinemasFilm(extractTitle,
				extractDescription, extractImage, extractActors,
				extractGenre(), extractDirector(), extractScore);
		System.out.println(onCinemasFilm.toString());
		onCinemasFilm.register();
	}

	default void fillOnCinemas(String rssUri) throws IOException,
			IllegalArgumentException, FeedException {
		List entries = getEntries(rssUri);
		Iterator itEntries = entries.iterator();

		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			fillFrequentFields(entry);
			try {
				registerOnCinemas();
			} catch (CantReadEntries e) {
				logger.error("Entry cant be converted to film" + entry, e);
				logger.error("rssUri is : "+rssUri);
			}
		}

	}
}