package com.muca.cinephile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Film {

	private String title;
	private String link;
	private String description;
	private String image;

	public Film(String title, String link, String description, String image) {
		this.title = title;
		this.link = link;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override	
	public String toString() {
		return "Film [title=" + title + ", link=" + link + ", description="
				+ description + ", image=" + image + "]";
	}

}
