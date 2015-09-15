package com.muca.cinephile;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public abstract class Film {

	private String title;
	
	private String description;
	private String image;
	private String actors;
	private String genre;																																																																																																																																																													
	private String director;																																																																																																																																																													

	public Film(String title, String description, String image,
			String actors, String genre, String director) {
		this.title = title;
		this.description = description;
		this.image = image;
		this.actors = actors;
		this.genre = genre;
		this.director = director;
	}
	
	public abstract void register();

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

	





	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description
				+ ", image=" + image + ", actors=" + actors + ", genre="
				+ genre + ", director=" + director + "]";
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}


}
