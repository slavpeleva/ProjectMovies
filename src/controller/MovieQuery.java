package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import model.Movie;

public class MovieQuery {

	private Connection connection = null; // manages connection
	private PreparedStatement selectAllMovies = null;
	private PreparedStatement selectMovieByTitle = null;
	private PreparedStatement insertNewMovie = null;
	private PreparedStatement deleteMovie = null;
	private PreparedStatement updateMovie_Genre = null;
	private PreparedStatement updateActor = null;
	private PreparedStatement updateDirector_Name = null;
	private PreparedStatement updateRating= null;

	// constructor
	public MovieQuery() throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/movies", "root", "");
			// create query that select all info about movies
			selectAllMovies = connection
					.prepareStatement("SELECT * FROM Movies");

			// create query that selects entries with a specific movie title
			selectMovieByTitle = connection
					.prepareStatement("SELECT * FROM Movies WHERE Movie_Title =?");

			// create insert that adds a new entry into the database
			insertNewMovie = connection
					.prepareStatement("INSERT INTO Movies "
							+ "( Movie_Title,Director_Name, actor, Movie_Genre, Rating ) "
							+ "VALUES ( ?, ?, ?, ? ,?)");
			// delete movie from database
			deleteMovie = connection
					.prepareStatement("Delete from Movies Where Movie_Title=?");
			// edit information for director's name
			updateDirector_Name = connection
					.prepareStatement("UPDATE Movies SET director_name = ? WHERE movie_title = ?");
			//edit information for movie genre
			updateMovie_Genre = connection
					.prepareStatement("UPDATE Movies SET movie_genre = ? WHERE movie_title = ?");
			//edit information about actor
			updateActor = connection
					.prepareStatement("UPDATE Movies SET actor = ? WHERE movie_title = ?");
			//edit information about rating
			updateRating = connection
					.prepareStatement("UPDATE Movies SET rating = ? WHERE movie_title = ?");

		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			System.exit(1);
		} // end catch
	} // end PersonQueries constructor

	// select all of the movies in the database
	public List<Movie> getAllMovies() {
		List<Movie> results = null;
		ResultSet resultSet = null;

		try {
			// executeQuery returns ResultSet containing matching entries
			resultSet = selectAllMovies.executeQuery();
			results = new ArrayList<Movie>();

			while (resultSet.next()) {
				results.add(new Movie(resultSet.getString("MOVIE_TITLE"),
						resultSet.getString("director_Name"), resultSet
								.getString("actor"), resultSet
								.getString("MOVIE_GENRE"), resultSet
								.getString("rating")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getAllPeople

	// select movie by title
	public List<Movie> getmovieByTitle(String movie_Title) {
		List<Movie> results = null;
		ResultSet resultSet = null;

		try {
			selectMovieByTitle.setString(1, movie_Title); // specify last name

			// executeQuery returns ResultSet containing matching entries
			resultSet = selectMovieByTitle.executeQuery();

			results = new ArrayList<Movie>();

			while (resultSet.next()) {
				results.add(new Movie(resultSet.getString("movie_Title"),
						resultSet.getString("director_Name"), resultSet
								.getString("actor"), resultSet
								.getString("movie_Genre"), resultSet
								.getString("rating")));
			} // end while
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
		finally {
			try {
				resultSet.close();
			} // end try
			catch (SQLException sqlException) {
				sqlException.printStackTrace();
				close();
			} // end catch
		} // end finally

		return results;
	} // end method getPeopleByName

	// add an entry 
	public int addMovie(String title, String dName, String actor, String genre,
			String rating){
		int result = 0;

		// set parameters, then execute insertNewPerson
		try {

			insertNewMovie.setString(1, title);
			insertNewMovie.setString(2, dName);
			insertNewMovie.setString(3, actor);
			insertNewMovie.setString(4, genre);
			insertNewMovie.setString(5, rating);

			// insert the new entry; returns # of rows updated
		
			result = insertNewMovie.executeUpdate();
			
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			// close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}// end catch

		return result;
	} // end method addPerson

	//delete an entry
	public int deleteMovie(String title) {
		int result = 0;

		// set parameters, then execute insertNewPerson
		try {
			deleteMovie.setString(1, title);

			// insert the new entry; returns # of rows updated
			result = deleteMovie.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	}

	//update director name
	public int updateDirector_Name(String director_Name, String movie_title) {
		int result = 0;
		try {
			updateDirector_Name.setString(1, director_Name);
			updateDirector_Name.setString(2, movie_title);

			result = updateDirector_Name.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	}

	//update actor
	public int updateActor(String actor, String movie_title) {
		int result = 0;
		try {
			updateActor.setString(1, actor);
			updateActor.setString(2, movie_title);

			result = updateActor.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	}

	//update movie genre
	public int updateMovie_Genre(String movie_Genre, String movie_title) {
		int result = 0;
		// set parameters, then execute insertNewPerson
		try {
			updateMovie_Genre.setString(1, movie_Genre);
			updateMovie_Genre.setString(2, movie_title);

			// insert the new entry; returns # of rows updated
			result = updateMovie_Genre.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	}
	
	//update rating
	public int updateRating(String rating, String movie_title) {
		int result = 0;
		// set parameters, then execute insertNewPerson
		try {
			updateRating.setString(1,rating);
			updateRating.setString(2, movie_title);

			// insert the new entry; returns # of rows updated
			result = updateRating.executeUpdate();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			close();
		} // end catch

		return result;
	}

	// close the database connection
	public void close() {
		try {
			connection.close();
		} // end try
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
		} // end catch
	} // end method close
} // end class PersonQueries