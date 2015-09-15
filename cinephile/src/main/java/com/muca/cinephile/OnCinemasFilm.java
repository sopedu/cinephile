package com.muca.cinephile;

public class OnCinemasFilm extends Film{
	
	private String score;

	public OnCinemasFilm(String title, String description,
			String image, String actors, String genre, String director,String string) {
		super(title,  description, image, actors, genre, director);
		this.score=string;
		
	}

	@Override
	public void register() {
		OnCinemas.add(this);		
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "OnCinemasFilm [score=" + score + ", getTitle()=" + getTitle()
				+ ", getImage()=" + getImage() + ", getDescription()="
				+ getDescription() + ", toString()=" + super.toString()
				+ ", getActors()=" + getActors() + ", getGenre()=" + getGenre()
				+ ", getDirector()=" + getDirector() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}
	
	

}
