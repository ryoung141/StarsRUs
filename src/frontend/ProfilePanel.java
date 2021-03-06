import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;
import java.util.regex.*;
import java.util.ArrayList;

public class ProfilePanel extends JPanel{
	private Person person;
	private JLabel titleLabel;
	private JLabel stockSymbolLabel;
	private JLabel nameLabel;
	private JLabel birthLabel;
	private JLabel contractsLabel;
	private JList contractsList;
	private JScrollPane scrollContainer;
	private DefaultListModel listModel;

	public static ArrayList<String> contracts = new ArrayList<String>();
	public static HashMap<String, MovieContract> contractsMap = new HashMap<String, MovieContract>();
	public static MovieContractDetailPanel movieContractDetailPanel;

	public ProfilePanel(Person person){
		

		this.person = person;
		this.setLayout(null);

		//Styling
		titleLabel = new JLabel("Profile");
		titleLabel.setBounds(150, 25, 100, 50);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(titleLabel.getFont().deriveFont(20.0f));

		stockSymbolLabel = new JLabel("");
		stockSymbolLabel.setBounds(100, 75, 200, 25);
		stockSymbolLabel.setHorizontalAlignment(JLabel.CENTER);
		stockSymbolLabel.setFont(stockSymbolLabel.getFont().deriveFont(12.0f));

		nameLabel = new JLabel("");
		nameLabel.setBounds(100, 100, 200, 25);
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setFont(nameLabel.getFont().deriveFont(12.0f));

		birthLabel = new JLabel("");
		birthLabel.setBounds(100, 125, 200, 25);
		birthLabel.setHorizontalAlignment(JLabel.CENTER);
		birthLabel.setFont(birthLabel.getFont().deriveFont(12.0f));

		contractsLabel = new JLabel("Movie Contracts Signed");
		contractsLabel.setBounds(100, 175, 200, 25);
		contractsLabel.setHorizontalAlignment(JLabel.CENTER);
		contractsLabel.setFont(contractsLabel.getFont().deriveFont(12.0f));

		listModel = new DefaultListModel();
		updateList();
		contractsList = new JList(listModel);
		scrollContainer = new JScrollPane(contractsList);
		scrollContainer.setBounds(50, 200, 300, 70);
		scrollContainer.setVerticalScrollBar(new JScrollBar());
		
		movieContractDetailPanel = new MovieContractDetailPanel();
		movieContractDetailPanel.setBounds(0, 300, 400, 200);
		movieContractDetailPanel.setVisible(false);

		//Event listeners
		contractsList.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				String selectedItem = (String) contractsList.getSelectedValue();
				if(selectedItem != null){
					MovieContract m = contractsMap.get(selectedItem);
					movieContractDetailPanel.changeDetail(m);
					movieContractDetailPanel.setVisible(true);
				}
			}
		});

		contractsList.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String selectedItem = (String) contractsList.getSelectedValue();
					if(selectedItem != null){
					MovieContract m = contractsMap.get(selectedItem);
					movieContractDetailPanel.changeDetail(m);
					movieContractDetailPanel.setVisible(true);
					}
				}
			}
		});

		//Initialize data
		changeDetails(person);

		//Add components
		this.add(titleLabel);
		this.add(stockSymbolLabel);
		this.add(nameLabel);
		this.add(birthLabel);
		this.add(contractsLabel);
		this.add(scrollContainer);
		this.add(movieContractDetailPanel);
	}

	public void changeDetails(Person p){
		this.person = p;
		setStockSymbol(p.getStockSymbol());
		setName(p.getName());
		setBirth(p.getDateOfBirth());
		setMovieContracts(p.getMovieContracts());
		updateList();
		System.out.println("-------------");
		for(String c: contracts) {
			System.out.println(c);
		}
	}

	public void updateList(){
		listModel.removeAllElements();
		for(String c: contracts) {
			listModel.addElement(c);
		}
	}

	public void setStockSymbol(String symbol){
		stockSymbolLabel.setText("Stock Symbol: " + symbol);
	}

	public void setName(String name){
		nameLabel.setText("Name: " + name);
	}

	public void setBirth(String dob){
		birthLabel.setText("Date of Birth: " + dob);
	}

	public void setMovieContracts(ArrayList<MovieContract> movieContracts){
		ArrayList<String> c = new ArrayList<String>();
		HashMap<String, MovieContract> cm = new HashMap<String, MovieContract>();

		for (MovieContract mc: movieContracts) {
			c.add(mc.getMovieTitle());
			cm.put(mc.getMovieTitle(), mc);
		}

		contracts = c;
		contractsMap = cm;
	}

}