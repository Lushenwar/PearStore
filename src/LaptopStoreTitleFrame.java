//Name: Johny Zeng
//Date: May 14, 2024
//Description: Introduction screen to show user the options
//Major Skills: Buttons, GUI

package Code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LaptopStoreTitleFrame extends JFrame implements ActionListener {

	// GUI elements
	private ImageIcon logo = new ImageIcon("images/pearlogoblack.png");
	private ImageIcon logoIcon = new ImageIcon("images/pearlogo.png");
	private Image scaledImage = logoIcon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
	private ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
	private JLabel logoImage = new JLabel(scaledLogoIcon);
	private JLabel logoLabel = new JLabel("Pear");
	private JLabel titleLabel = new JLabel("HOME PAGE");
	private JPanel titlePanel = new JPanel();

	// GUI elements
	private JButton inventoryButton = new JButton("Inventory Frame");
	private JButton surveyButton = new JButton("Survey Frame");
	private JButton educationButton = new JButton("Education Frame");

	public LaptopStoreTitleFrame() {

		titlePanel.setBounds(0, 0, 1920, 150);
		Color titleColor = Color.decode("#511AB6");
		titlePanel.setBackground(titleColor);
		titlePanel.setLayout(null);
		add(titlePanel);

		// 1.Setup the frame
		setSize(1920, 1080);
		setIconImage(logo.getImage());
		setTitle("Pear Store - Home Page");
		setLayout(null);

		logoLabel.setFont(new Font("Roboto", Font.BOLD, 60));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setBounds(50, 35, 500, 60);
		titlePanel.add(logoLabel);

		logoImage.setBounds(150, 15, 100, 100);
		titlePanel.add(logoImage);

		titleLabel.setFont(new Font("Roboto", Font.BOLD, 70));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(425, 35, 600, 80);
		titlePanel.add(titleLabel);

		// Add the button(s) to the frame
		inventoryButton.setBounds(300, 200, 200, 100);
		inventoryButton.addActionListener(this);
		add(inventoryButton);

		surveyButton.setBounds(300, 350, 200, 100);
		surveyButton.addActionListener(this);
		add(surveyButton);

		educationButton.setBounds(300, 500, 200, 100);
		educationButton.addActionListener(this);
		add(educationButton);

		setVisible(true);

	}

	// This method controls the actions
	public void actionPerformed(ActionEvent event) {

		// 1. If the inventory button gets clicked then show Inventory Frame
		if (event.getSource() == inventoryButton) {
			setVisible(false);
			new LaptopInventoryFrame();
		}

		if (event.getSource() == surveyButton) {
			setVisible(false);
			new SurveyFrame();
		}

		if (event.getSource() == educationButton) {
			setVisible(false);
			new EducationFrame();
		}

	}

}
