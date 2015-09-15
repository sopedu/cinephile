package com.muca.cinephile;

import java.io.IOException;
import java.util.List;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;

public interface ComingSoonExtractor extends FilmExtractor {
	

	String extractShowDate() throws IOException;

	static Logger logger = Logger
			.getLogger(ComingSoonExtractor.class.getName());

	default void registerComingSoon() throws IOException, CantReadEntries {

		String extractTitle;
		try {
			extractTitle = extractTitle();
		} catch (Exception e1) {
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

		String extractImage;
		try {
			extractImage = extractImage();
		} catch (Exception e) {
			extractImage = "";
			logger.error("No Image found for film" + extractTitle);
		}
		String extractDescription;
		try {
			extractDescription = extractDescription();
		} catch (Exception e) {
			extractDescription = "";
			logger.error("No Description found for film" + extractTitle);
		}

		ComingSoonFilm comingSoonFilm = new ComingSoonFilm(extractTitle,
				extractDescription, extractImage, extractActors,
				extractGenre(), extractDirector(), extractShowDate());
		System.out.println(comingSoonFilm);
		comingSoonFilm.register();
	};

	default void fillComingSoon(String rssUri) throws IOException,
			IllegalArgumentException, FeedException {
		List entries = getEntries(rssUri);
		Iterator itEntries = entries.iterator();

		while (itEntries.hasNext()) {
			SyndEntry entry = (SyndEntry) itEntries.next();
			fillFrequentFields(entry);
			try {
				registerComingSoon();
			} catch (CantReadEntries e) {
				logger.error("Entry cant be converted to film :" + entry.toString(), e);
				logger.error("rssUri is :" +rssUri);
			}
		}
	}

}
