
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
		//JPanel characteristics
		this.setLayout(null);

		//Styling
		int base = 25;
		title = new JLabel("Movies");
		title.setBounds(100, base, 200, 50);
		title.setFont(title.getFont().deriveFont(24.0f));
		title.setHorizontalAlignment(JLabel.CENTER);

		listModel = new DefaultListModel();
		//updateList();
		movieList = new JList(movies.toArray());
		scrollContainer = new JScrollPane(movieList);
		scrollContainer.setBounds(50, base + 75, 300, 150);
		scrollContainer.setVerticalScrollBar(new JScrollBar());

		movieDetailPanel = new MovieDetailPanel();
		movieDetailPanel.setBounds(0, base + 250, 400, 600-(base+250));

		//Event listeners
/*		stockList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) stockList.getSelectedValue();
				if(selectedItem != null){
					Stock s = stocksMap.get(selectedItem);
					stockDetailPanel.changeDetail(s);
					stockDetailPanel.makeVisible();
				}
			}
		});

		stockList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String selectedItem = (String) stockList.getSelectedValue();
					if(selectedItem != null){
						Stock s = stocksMap.get(selectedItem);
						stockDetailPanel.changeDetail(s);
						stockDetailPanel.makeVisible();
					}
				}
			}
		});*/

		//Add components
		this.add(title);
		this.add(scrollContainer);
		this.add(movieDetailPanel);
	}	

	public void addMovie(Movie m){
		movies.add(m.getMovieTitle());
		moviesMap.put(m.getMovieTitle(), m);
		return;
	}
}