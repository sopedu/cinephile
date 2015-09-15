package com.muca.cinephile;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.rometools.rome.feed.synd.SyndEntry;

public class MynetExtractor implements ComingSoonExtractor, OnCinemasExtractor {
	



	private SyndEntry entry;
	private String value;
	private String uri;
	private Document document;

	@Override
	public String extractDescription() {
		String text = Jsoup.parse(value).select("p").first().text();
		return text;
	}

	@Override
	public String extractActors() throws IOException {
		return extractAttribute("actors","a");
	}

	@Override
	public String extractTitle() {
		return entry.getTitle();
	}

	@Override
	public String extractImage() {
		return Jsoup.parse(value).select("img").first().attr("src");
	}

	@Override
	public String extractGenre() throws IOException {
		return extractAttribute("name","a");
	}

	@Override
	public String extractDirector() throws IOException {
		return extractAttribute("director","a");
	}

	@Override
	public String extractScore() throws IOException {
		
		return extractAttribute("ratingValue","span")+""+"10";
	}

	@Override
	public String extractShowDate() throws IOException {
		return extractAttribute("datepublished", "span");
	}

	public String extractAttribute( String attribute,String htmlTag)
			throws IOException {
		String value = "";
		String jsoupQuery = htmlTag+"[itemprop=" + attribute + "]";
		Elements select = document.select(jsoupQuery);
		for (Element element : select) {
			if (!value.equals(""))
				value = value + ",";
			value = value + element.text();
		}
		return value;
	}

	

	public void fillFrequentFields(SyndEntry entry) throws IOException  {
		this.entry = entry;
		this.value = entry.getDescription().getValue();
		this.uri = entry.getUri();
		this.document = Jsoup.connect(uri).timeout(0).get();
	}

}
