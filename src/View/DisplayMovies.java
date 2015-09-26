package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import sun.awt.image.ImagingLib;
import controller.MovieQuery;
import model.Movie;

import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class DisplayMovies extends JFrame {
	private Movie currentEntry;
	private MovieQuery movieQueries;
	private List<Movie> results;
	private int numberOfEntries = 0;
	private int currentEntryIndex;
	private JButton browseButton;
	private JLabel movie_TitleLabel;
	private JTextField movie_TitleTextField;
	private JLabel director_NameLabel;
	private JTextField director_NameTextField;
	private JTextField indexTextField;
	private JLabel actorLabel;
	private JTextField actorTextField;
	private JTextField maxTextField;
	private JButton nextButton;
	private JLabel ofLabel;
	private JLabel movie_GenreLabel;
	private JTextField movie_GenreTextField;
	private JLabel ratingLabel;
	private JTextField ratingTextField;
	private JButton previousButton;
	private JButton findButton;
	private JLabel findLabel;
	private JPanel findPanel;
	private JPanel navigatePanel;
	private JPanel displayPanel;
	private JTextField queryTextField;
	private JButton insertButton;
	private JButton deleteButton;
	private JButton updateButton;
	private JButton help;
	private JLabel displayIcon;

	// no-argument constructor

	public DisplayMovies() throws ClassNotFoundException {
		super("Movie");
		initComponnents();
	} // end no-argument constructor

	private void initComponnents() throws ClassNotFoundException {
		getContentPane().setBackground(Color.WHITE);

		// establish database connection and set up PreparedStatements
		movieQueries = new MovieQuery();

		// create GUI
		navigatePanel = new JPanel();
		previousButton = new JButton();
		previousButton.setForeground(new Color(102, 0, 204));
		indexTextField = new JTextField(2);
		indexTextField.setEditable(false);
		displayPanel = new JPanel();
		displayPanel.setBackground(Color.WHITE);
		movie_TitleTextField = new JTextField(10);
		director_NameLabel = new JLabel();
		director_NameTextField = new JTextField(10);
		actorLabel = new JLabel();
		actorTextField = new JTextField(10);
		movie_GenreLabel = new JLabel();
		movie_GenreTextField = new JTextField(10);
		ratingLabel = new JLabel();
		ratingLabel
				.setToolTipText("<html>A -Aimed at young audiences<br>"
						+ "B - All ages may watch<br>"
						+ "C -Restricted to an older audience unless accompanied by an adult<br>"
						+ "D - Restricted exclusively to an older audience.</html>");
		ratingTextField = new JTextField(10);
		findPanel = new JPanel();
		findPanel.setForeground(Color.WHITE);
		findPanel.setBackground(Color.WHITE);
		findLabel = new JLabel();
		queryTextField = new JTextField(10);
		findButton = new JButton();
		findButton
				.setToolTipText("You should write the title of the movie correctly");
		findButton.setForeground(new Color(102, 0, 204));
		browseButton = new JButton();
		browseButton.setForeground(new Color(102, 0, 204));
		insertButton = new JButton();
		insertButton
				.setToolTipText("After insert correct movie please tab the update button!");
		insertButton.setForeground(new Color(102, 0, 204));
		deleteButton = new JButton();
		deleteButton.setForeground(new Color(102, 0, 204));
		updateButton = new JButton();
		updateButton.setToolTipText("You can change one field at a time !");
		updateButton.setForeground(new Color(102, 0, 204));
		help = new JButton();
	//	help.setToolTipText("If you are stupid try this button");
		help.setFont(new Font("Tahoma", Font.BOLD, 13));
		help.setForeground(new Color(255, 0, 0));
		displayIcon = new JLabel();
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Imdb By Slavka :)");
		setSize(600, 520);

		// create an icon
		ImageIcon icon = new ImageIcon("/image/movie.png");
		displayIcon.setIcon(icon);
		setIconImage(new ImageIcon(getClass().getResource("/image/movie.png"))
				.getImage());
		getContentPane().add(displayIcon);

		// create an image in the panel
		ImageIcon image = new ImageIcon(getClass().getResource(
				"/image/downloads.jpg"));
		JLabel label = new JLabel(image);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(label, BorderLayout.CENTER);
		setVisible(true);

		navigatePanel.setLayout(new BoxLayout(navigatePanel, BoxLayout.X_AXIS));

		previousButton.setText("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				previousButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		navigatePanel.add(previousButton);

		indexTextField.setHorizontalAlignment(JTextField.CENTER);
		indexTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				indexTextFieldActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		navigatePanel.add(indexTextField);
		getContentPane().add(navigatePanel);
		ofLabel = new JLabel();
		getContentPane().add(ofLabel);

		ofLabel.setText("of");
		maxTextField = new JTextField(2);
		getContentPane().add(maxTextField);

		maxTextField.setHorizontalAlignment(JTextField.CENTER);
		maxTextField.setEditable(false);
		nextButton = new JButton();
		nextButton.setForeground(new Color(102, 0, 204));
		getContentPane().add(nextButton);

		nextButton.setText("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				nextButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				);

		displayPanel.setLayout(new GridLayout(5, 2, 8, 8));
		movie_TitleLabel = new JLabel();

		movie_TitleLabel.setText("Movie title");
		displayPanel.add(movie_TitleLabel);
		displayPanel.add(movie_TitleTextField);

		director_NameLabel.setText("Director First Name:");
		displayPanel.add(director_NameLabel);
		displayPanel.add(director_NameTextField);

		actorLabel.setText("Actor Name:");
		displayPanel.add(actorLabel);
		displayPanel.add(actorTextField);

		movie_GenreLabel.setText("Genre:");
		displayPanel.add(movie_GenreLabel);
		displayPanel.add(movie_GenreTextField);

		ratingLabel.setText("Rating:");
		displayPanel.add(ratingLabel);
		displayPanel.add(ratingTextField);
		getContentPane().add(displayPanel);

		findPanel.setLayout(new BoxLayout(findPanel, BoxLayout.X_AXIS));

		findPanel.setBorder(BorderFactory
				.createTitledBorder("Find a movie by movie title"));
		findLabel.setText("Movie Title:");
		findPanel.add(Box.createHorizontalStrut(5));
		findPanel.add(findLabel);
		findPanel.add(Box.createHorizontalStrut(10));
		findPanel.add(queryTextField);
		findPanel.add(Box.createHorizontalStrut(10));

		findButton.setText("Find");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				findButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		findPanel.add(findButton);
		findPanel.add(Box.createHorizontalStrut(5));
		getContentPane().add(findPanel);

		browseButton.setText("Load/Update All Movies");
		browseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				browseButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		getContentPane().add(browseButton);

		deleteButton.setText("Delete movie");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				deleteButtonActionPerformed(evt);
			} // end method actionPerformed

		} // end anonymous inner class
				); // end call to addActionListener

		getContentPane().add(deleteButton);

		updateButton.setText("Update movie");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				updateButtonActionPerformed(evt);
			} // end method actionPerformed

		} // end anonymous inner class
				); // end call to addActionListener

		getContentPane().add(updateButton);

		insertButton.setText("Insert New Movie");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				insertButtonActionPerformed(evt);
			} // end method actionPerformed
		} // end anonymous inner class
				); // end call to addActionListener

		getContentPane().add(insertButton);
		help.setText("HELP");
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evt) {
				helpActionPerformed(evt);

			}

		});
		getContentPane().add(help);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				movieQueries.close(); // close database connection
				System.exit(0);
			} // end method windowClosing
		} // end anonymous inner class
		); // end call to addWindowListener

		setVisible(true);
	}

	// handles call when previousButton is clicked
	private void previousButtonActionPerformed(ActionEvent evt) {

		--currentEntryIndex;

		if (currentEntryIndex < 0)
			currentEntryIndex = numberOfEntries - 1;

		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	} // end method previousButtonActionPerformed

	// handles call when nextButton is clicked
	private void nextButtonActionPerformed(ActionEvent evt) {

		++currentEntryIndex;

		if (currentEntryIndex >= numberOfEntries)
			currentEntryIndex = 0;

		indexTextField.setText("" + (currentEntryIndex + 1));
		indexTextFieldActionPerformed(evt);
	} // end method nextButtonActionPerformed

	// handles call when findButton is clicked
	private void findButtonActionPerformed(ActionEvent evt) {
		try {
			results = movieQueries.getmovieByTitle(queryTextField.getText());
			numberOfEntries = results.size();

			if (numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				movie_TitleTextField
						.setText("" + currentEntry.getMovie_Title());
				director_NameTextField.setText(currentEntry.getDirector_Name());
				actorTextField.setText(currentEntry.getActor());
				movie_GenreTextField.setText(currentEntry.getMovie_Genre());
				ratingTextField.setText(currentEntry.getRating());
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			} // end if
			else {
				JOptionPane.showMessageDialog(this, "Didn't find the movie!",
						"Movie not found!", JOptionPane.PLAIN_MESSAGE);
				browseButtonActionPerformed(evt);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Problem with entry data!",
					"Error!", JOptionPane.PLAIN_MESSAGE);
		}
		// browseButtonActionPerformed(evt);
	} // end method queryButtonActionPerformed

	// handles call when a new value is entered in indexTextField
	private void indexTextFieldActionPerformed(ActionEvent evt) {
		currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);

		if (numberOfEntries != 0 && currentEntryIndex < numberOfEntries) {
			currentEntry = results.get(currentEntryIndex);
			movie_TitleTextField.setText("" + currentEntry.getMovie_Title());
			director_NameTextField.setText(currentEntry.getDirector_Name());
			actorTextField.setText(currentEntry.getActor());
			movie_GenreTextField.setText(currentEntry.getMovie_Genre());
			ratingTextField.setText(currentEntry.getRating());
			maxTextField.setText("" + numberOfEntries);
			indexTextField.setText("" + (currentEntryIndex + 1));
		} // end if
	} // end method indexTextFieldActionPerformed

	// handles call when browseButton is clicked
	private void browseButtonActionPerformed(ActionEvent evt) {
		try {
			results = movieQueries.getAllMovies();
			numberOfEntries = results.size();

			if (numberOfEntries != 0) {
				currentEntryIndex = 0;
				currentEntry = results.get(currentEntryIndex);
				movie_TitleTextField
						.setText("" + currentEntry.getMovie_Title());
				director_NameTextField.setText(currentEntry.getDirector_Name());
				actorTextField.setText(currentEntry.getActor());
				movie_GenreTextField.setText(currentEntry.getMovie_Genre());
				ratingTextField.setText(currentEntry.getRating());
				maxTextField.setText("" + numberOfEntries);
				indexTextField.setText("" + (currentEntryIndex + 1));
				nextButton.setEnabled(true);
				previousButton.setEnabled(true);
			} // end if
		} // end try
		catch (Exception e) {
			e.printStackTrace();
		} // end catch
	} // end method browseButtonActionPerformed

	// handles call when insert button is clicked
	private void insertButtonActionPerformed(ActionEvent evt) {
		try {
			boolean flag = false;
			results = movieQueries.getAllMovies();
			for (Movie movie : results) {
				if (movie.getMovie_Title().equalsIgnoreCase(movie_TitleTextField.getText())
						|| movie_TitleTextField.getText().isEmpty()
						|| movie_TitleTextField.getText() == null) {
					flag = true;
					break;
				} else {
					if (director_NameTextField.getText().isEmpty()
							|| actorTextField.getText().isEmpty()
							|| movie_GenreTextField.getText().isEmpty()
							|| ratingTextField.getText().isEmpty()
							&& flag == false) {
						JOptionPane.showMessageDialog(this,
								"The field cannot be empty", "Error",
								JOptionPane.PLAIN_MESSAGE);
						flag = true;
						break;

					}
				}
			}

			if (!flag) {
				int result = movieQueries.addMovie(
						movie_TitleTextField.getText(),
						director_NameTextField.getText(),
						actorTextField.getText(),
						movie_GenreTextField.getText(),
						ratingTextField.getText());
				if (result == 1) {
					JOptionPane.showMessageDialog(this, "Movie added!",
							"Movie added", JOptionPane.PLAIN_MESSAGE);
				}
			}

			else {
				JOptionPane
						.showMessageDialog(
								this,
								"Problem with add the movie or the movie already exist in database",
								"Didn't add the movie",
								JOptionPane.PLAIN_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Movie not added!", "Error",
					JOptionPane.PLAIN_MESSAGE);
		}
		browseButtonActionPerformed(evt);

	} // end method insertButtonActionPerformed

	// handles call when delete button is clicked
	private void deleteButtonActionPerformed(ActionEvent evt) {
		try {
			int result = movieQueries.deleteMovie(movie_TitleTextField
					.getText());

			if (result == 1)
				JOptionPane.showMessageDialog(this, "Movie deleted!",
						"Movie deleted", JOptionPane.PLAIN_MESSAGE);
			else
				JOptionPane.showMessageDialog(this, "Movie not deleted!",
						"Error", JOptionPane.PLAIN_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error with entry data!",
					"Error", JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);

	}

	// handles call when update button is clicked
	private void updateButtonActionPerformed(ActionEvent evt) {
		boolean update = false;
		int result1 = 0;
		int result2 = 0;
		int result3 = 0;
		int result4 = 0;
		try {
			results = movieQueries.getAllMovies();
			for (Movie movie : results) {				
				if (movie.movie_Title.equalsIgnoreCase(movie_TitleTextField
						.getText())) {
					if (!movie.getDirector_Name().equalsIgnoreCase(
							director_NameTextField.getText())
							&& !director_NameTextField.getText().isEmpty()) {
						result1 = movieQueries.updateDirector_Name(
								director_NameTextField.getText(),
								movie_TitleTextField.getText());
						update = true;
						break;
					} else if (!movie.getActor().equalsIgnoreCase(
							actorTextField.getText())
							&& !actorTextField.getText().isEmpty()) {
						result2 = movieQueries.updateActor(
								actorTextField.getText(),
								movie_TitleTextField.getText());
						update = true;
						break;
					} else if (!movie.getMovie_Genre().equalsIgnoreCase(
							movie_GenreTextField.getText())
							&& !movie_GenreTextField.getText().isEmpty()) {
						result3 = movieQueries.updateMovie_Genre(
								movie_GenreTextField.getText(),
								movie_TitleTextField.getText());
						update = true;
						break;
					} else if (!movie.getRating().equalsIgnoreCase(
							ratingTextField.getText())
							&& !ratingTextField.getText().isEmpty()) {
						switch (ratingTextField.getText()) {
						case "A":
							result4 = movieQueries.updateRating(
									ratingTextField.getText(),
									movie_TitleTextField.getText());
							update = true;
							break;
						case "B":
							result4 = movieQueries.updateRating(
									ratingTextField.getText(),
									movie_TitleTextField.getText());
							update = true;
							break;
						case "C":
							result4 = movieQueries.updateRating(
									ratingTextField.getText(),
									movie_TitleTextField.getText());
							update = true;
							break;
						case "D":
							result4 = movieQueries.updateRating(
									ratingTextField.getText(),
									movie_TitleTextField.getText());
							update = true;
							break;

						default:
							break;
						}
						break;
					}
				}

			}
			if (update
					&& ((result1 == 1) || (result2 == 1) || (result3 == 1) || result4 == 1)) {
				JOptionPane.showMessageDialog(this, "Movie updated!",
						"Movie updated", JOptionPane.PLAIN_MESSAGE);

			} else {
				JOptionPane.showMessageDialog(this, "Movie not updated!",
						"Movie not updated", JOptionPane.PLAIN_MESSAGE);

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Invalid entry!", "Error",
					JOptionPane.PLAIN_MESSAGE);
		}

		browseButtonActionPerformed(evt);
	}

	// just a joke
	private void helpActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Under construction!", "Help",
				JOptionPane.PLAIN_MESSAGE);

	}

}
