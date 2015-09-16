package com.muca.cinephile.film;


public class ComingSoonFilm extends Film {

	private String showDate;

	public ComingSoonFilm(String title, String description,
			String image, String actors, String genre, String director,
			String showDate) {
		super(title, description, image, actors, genre, director);
		this.showDate = showDate;
	}

	public String getShowDate() {
		return showDate;
	}

	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	@Override
	public void register() {
		ComingSoon.add(this);		
	}

	@Override
	public String toString() {
		return "ComingSoonFilm [showDate=" + showDate + ", getTitle()="
				+ getTitle() + ", getImage()=" + getImage()
				+ ", getDescription()=" + getDescription() + ", toString()="
				+ super.toString() + ", getActors()=" + getActors()
				+ ", getGenre()=" + getGenre() + ", getDirector()="
				+ getDirector() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
	
	


	
	

}
