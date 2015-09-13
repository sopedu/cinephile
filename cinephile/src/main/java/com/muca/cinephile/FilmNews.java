package com.muca.cinephile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class FilmNews {

	private String title;
	private String link;
	private String publishedDate;
	private String image;

	public FilmNews(String title, String link, String publishedDate,
			String image) {
		this.title = title;
		this.link = link;
		this.publishedDate = publishedDate;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}


}
