import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;
import java.util.ArrayList;

public class MovieDetailPanel extends JPanel{
	private Movie movie;
	private JLabel titleLabel;
	private JLabel movieTitleLabel;
	private JLabel prodcutionYearLabel;
	private JLabel reviewLabel;
	private JList reviewList;
	private JScrollPane scrollContainer;
	private DefaultListModel listModel;

	private ArrayList<String> reviews = new ArrayList<String>();

	public MovieDetailPanel(){
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		//Styling
		int base = 10;
		titleLabel = new JLabel("Movie Detail");
		titleLabel.setBounds(100, base, 200, 25);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(16.0f));

		movieTitleLabel = new JLabel("Movie: Batman");
		movieTitleLabel.setBounds(100, base + 50, 200, 25);
		movieTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		movieTitleLabel.setFont(movieTitleLabel.getFont().deriveFont(12.0f));

		prodcutionYearLabel = new JLabel("Production Year: 1996");
		prodcutionYearLabel.setBounds(100, base + 75, 200, 25);
		prodcutionYearLabel.setHorizontalAlignment(JLabel.CENTER);
		prodcutionYearLabel.setFont(prodcutionYearLabel.getFont().deriveFont(12.0f));

		reviewLabel = new JLabel("Reviews");
		reviewLabel.setBounds(100, base + 110, 200, 25);
		reviewLabel.setHorizontalAlignment(JLabel.CENTER);
		reviewLabel.setFont(reviewLabel.getFont().deriveFont(14.0f));

		listModel = new DefaultListModel();
		reviewList = new JList(listModel);
		scrollContainer = new JScrollPane(reviewList);
		scrollContainer.setBounds(50, base + 140, 300, 100);
		scrollContainer.setVerticalScrollBar(new JScrollBar());

		//Event listeners

		//Add components
		this.add(titleLabel);
		this.add(movieTitleLabel);
		this.add(prodcutionYearLabel);
		this.add(reviewLabel);
		this.add(scrollContainer);
	}

	public void updateList(){
		listModel.removeAllElements();
		for(String r: reviews) {
			System.out.println(r);
			listModel.addElement(r);
		}
	}

	public void changeDetail(Movie m){
		this.movie = m;
		setMovieTitle(m.getMovieTitle());
		setProductionYear(m.getProductionYear());
		setReviews(m.getReviews());
		updateList();
	}

	public void setMovieTitle(String movieTitle){
		movieTitleLabel.setText("Movie: " + movieTitle);
	}

	public void setProductionYear(int year){
		prodcutionYearLabel.setText("Role: " + year);
	}

	public void setReviews(HashMap<String, String> revs) {
		ArrayList<String> r = new ArrayList<String>();
		for(Map.Entry<String, String> entry : revs.entrySet()) {
			String review = entry.getKey() + " - " + entry.getValue();
			r.add(review);
		}
		reviews = r;
		updateList();
	}

}