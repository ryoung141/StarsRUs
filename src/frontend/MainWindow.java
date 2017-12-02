
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow {

	private JFrame frame;

	public MainWindow() {

		//Instantiate Frame
		frame = new JFrame();

		frame.add(new LoginScreen());

		//Set window propertiers
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("StarsRus Login");
		frame.setSize(800, 600);
		frame.setVisible(true);
	}	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}

}