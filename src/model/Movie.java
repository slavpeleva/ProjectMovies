package model;

public class Movie {

	public String movie_Title;
	private String director_Name;
	private String actor;
	private String movie_Genre;
	private String rating;

	public Movie() {

	}

	public Movie(String movieTitle, String directorName, String actor,
			String movieGenre, String rating) {	
		setMovie_Title(movieTitle);
		setDirector_Name(directorName);
		setActor(actor);
		setMovie_Genre(movieGenre);
		setRating(rating);
		
	}

	public String getMovie_Title() {
		return movie_Title;
	}

	public void setMovie_Title(String movieTitle) {
		this.movie_Title = movieTitle;
	}

	public String getDirector_Name() {
		return director_Name;
	}

	public void setDirector_Name(String directorName) {
		this.director_Name = directorName;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getMovie_Genre() {
		return movie_Genre;
	}

	public void setMovie_Genre(String movieGenre) {
		this.movie_Genre = movieGenre;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	

}
