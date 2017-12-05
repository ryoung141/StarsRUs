
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.ArrayList;

public class MoviePanel extends JPanel{
	//400x600

	//Define components
	private JLabel title;
	private JList movieList;
	private DefaultListModel listModel;
	private JScrollPane scrollContainer;
	public static MovieDetailPanel movieDetailPanel;
	
	public static ArrayList<String> movies = new ArrayList<String>();
	public static HashMap<String, Movie> moviesMap = new HashMap<String,Movie>();

	public MoviePanel() {

		HashMap<String, String> ranking1 = new HashMap<String, String>();
		ranking1.put("John Creane", "Awesome");
		ranking1.put("Johnny Pane", "HATE IT");
		ranking1.put("Corina Fonzy", "bleh");
		ranking1.put("Doanald Row", "ehh");
		ranking1.put("Filli Tam", "worse ever");

		HashMap<String, String> ranking2 = new HashMap<String, String>();
		ranking2.put("John Creane the 2nd", "Awesome");
		ranking2.put("Johnny Pane the 2nd", "HATE IT");
		ranking2.put("Corina Fonzy the 2nd", "bleh");
		ranking2.put("Doanald Row the 2nd", "ehh");
		ranking2.put("Filli Tam the 2nd", "worse ever");

		//Sample
		Movie movie1 = new Movie("Batman", 1992, ranking2, new HashMap<String, Double>());
		Movie movie2 = new Movie("George of the Jungle", 1995, ranking1, new HashMap<String, Double>());
		Movie movie3 = new Movie("Jumanji", 2000, ranking1, new HashMap<String, Double>());
		Movie movie4 = new Movie("Avengers", 2003, ranking2, new HashMap<String, Double>());
		Movie movie5 = new Movie("Kingsman", 2010, ranking1, new HashMap<String, Double>());
		Movie movie6 = new Movie("Ludacris", 2019, ranking2, new HashMap<String, Double>());
		Movie movie7 = new Movie("Gone Bad", 2012, ranking1, new HashMap<String, Double>());

		addMovie(movie1);
		addMovie(movie2);
		addMovie(movie3);
		addMovie(movie4);
		addMovie(movie5);
		addMovie(movie6);
		addMovie(movie7);
		


		//JPanel characteristics
		this.setLayout(null);

		//Styling
		int base = 25;
		title = new JLabel("Movies");
		title.setBounds(100, base, 200, 50);
		title.setFont(title.getFont().deriveFont(24.0f));
		title.setHorizontalAlignment(JLabel.CENTER);

		listModel = new DefaultListModel();
		this.updateList();
		movieList = new JList(movies.toArray());
		scrollContainer = new JScrollPane(movieList);
		scrollContainer.setBounds(50, base + 75, 300, 150);
		scrollContainer.setVerticalScrollBar(new JScrollBar());

		movieDetailPanel = new MovieDetailPanel();
		movieDetailPanel.setBounds(0, base + 250, 400, 600-(base+250));
		movieDetailPanel.setVisible(false);

		//Event listeners
		movieList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) movieList.getSelectedValue();
				if(selectedItem != null){
					Movie m = moviesMap.get(selectedItem);
					movieDetailPanel.changeDetail(m);
					movieDetailPanel.setVisible(true);
				}
			}
		});

		movieList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String selectedItem = (String) movieList.getSelectedValue();
					if(selectedItem != null){
						Movie m = moviesMap.get(selectedItem);
						movieDetailPanel.changeDetail(m);
						movieDetailPanel.setVisible(true);
					}
				}
			}
		});

		//Add components
		this.add(title);
		this.add(scrollContainer);
		this.add(movieDetailPanel);
	}	

	public void updateList(){
		listModel.removeAllElements();
		for(String m: movies) {
			listModel.addElement(m);
		}
	}

	public void addMovie(Movie m){
		movies.add(m.getMovieTitle());
		moviesMap.put(m.getMovieTitle(), m);
		return;
	}

	public void clearMovies(){
		movies = new ArrayList<String>();
		moviesMap = new HashMap<String,Movie>();
	}
	
	public void getMovies(){
		//TODO: Create movie objects of all movies and use addMovie function
		
		//Remember to clear list first
		clearMovies();

		//Get movies

		//Update movie after adding
		updateList();
		
		return;
	}
}