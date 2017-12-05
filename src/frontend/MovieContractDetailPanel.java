import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class MovieContractDetailPanel extends JPanel{
	private MovieContract MovieContract;
	private JLabel titleLabel;
	private JLabel movieTitleLabel;
	private JLabel roleLabel;
	private JLabel yearLabel;
	private JLabel totalValueLabel;

	public MovieContractDetailPanel(){
		this.setLayout(null);
		this.setBorder(BorderFactory.createLineBorder(Color.black));

		//Styling
		int base = 0;
		titleLabel = new JLabel("Movie Contract Detail");
		titleLabel.setBounds(100, base, 200, 25);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(14.0f));

		movieTitleLabel = new JLabel("Movie: Batman");
		movieTitleLabel.setBounds(100, base + 25, 200, 25);
		movieTitleLabel.setHorizontalAlignment(JLabel.CENTER);
		movieTitleLabel.setFont(movieTitleLabel.getFont().deriveFont(12.0f));

		roleLabel = new JLabel("Role: Actor");
		roleLabel.setBounds(100, base + 50, 200, 25);
		roleLabel.setHorizontalAlignment(JLabel.CENTER);
		roleLabel.setFont(roleLabel.getFont().deriveFont(12.0f));

		yearLabel = new JLabel("Year: 1998");
		yearLabel.setBounds(100, base + 75, 200, 25);
		yearLabel.setHorizontalAlignment(JLabel.CENTER);
		yearLabel.setFont(yearLabel.getFont().deriveFont(12.0f));

		totalValueLabel = new JLabel("Value: $23002.20");
		totalValueLabel.setBounds(100, base + 100, 200, 25);
		totalValueLabel.setHorizontalAlignment(JLabel.CENTER);
		totalValueLabel.setFont(totalValueLabel.getFont().deriveFont(12.0f));

		//Event listeners

		//Add components
		this.add(titleLabel);
		this.add(movieTitleLabel);
		this.add(roleLabel);
		this.add(yearLabel);
		this.add(totalValueLabel);
	}

	public void changeDetail(MovieContract m){
		this.MovieContract = m;
		setMovieTitle(m.getMovieTitle());
		setRole(m.getRole());
		setYear(m.getYear());
		setTotalValue(m.getTotalValue());
	}

	public void setMovieTitle(String movieTitle){
		movieTitleLabel.setText("Movie: " + movieTitle);
	}

	public void setRole(String role){
		roleLabel.setText("Role: " + role);
	}

	public void setYear(int year){
		yearLabel.setText("Year: " + Integer.toString(year));
	}

	public void setTotalValue(double totalValue){
		totalValueLabel.setText("Value: $" + Double.toString(totalValue));
	}

}