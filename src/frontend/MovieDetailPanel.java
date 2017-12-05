import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class MovieDetailPanel extends JPanel{
	private Movie movie;
	private JLabel titleLabel;
	private JLabel movieTitleLabel;
	private JLabel prodcutionYearLabel;

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

		//Event listeners

		//Add components
		this.add(titleLabel);
		this.add(movieTitleLabel);
		this.add(prodcutionYearLabel);
	}

	public void changeDetail(Movie m){
		this.movie = m;
		setMovieTitle(m.getMovieTitle());
		setProductionYear(m.getProductionYear());
	}

	public void setMovieTitle(String movieTitle){
		movieTitleLabel.setText("Movie: " + movieTitle);
	}

	public void setProductionYear(int year){
		prodcutionYearLabel.setText("Role: " + year);
	}

}