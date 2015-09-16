package com.muca.cinephile.film;

public abstract class Film {

	private String actors;
	private String description;
	private String director;
	private String genre;
	private String image;
	private String title;

	public Film(String title, String description, String image, String actors,
			String genre, String director) {
		this.title = title;
		this.description = description;
		this.image = image;
		this.actors = actors;
		this.genre = genre;
		this.director = director;
	}

	public String getActors() {
		return actors;
	}

	public String getDescription() {
		return description;
	}

	public String getDirector() {
		return director;
	}

	public String getGenre() {
		return genre;
	}

	public String getImage() {
		return image;
	}

	public String getTitle() {
		return title;
	}

	public abstract void register();

	public void setActors(String actors) {
		this.actors = actors;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Film [title=" + title + ", description=" + description
				+ ", image=" + image + ", actors=" + actors + ", genre="
				+ genre + ", director=" + director + "]";
	}

}
