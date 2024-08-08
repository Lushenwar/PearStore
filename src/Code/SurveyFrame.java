//Name: Johnny Li
//Date: May 14, 2024
//Description: Survey screen to ask the user for a specific computer they are looking for
//Major Skills: Radio button groups, buttons, text fields, scroll bar/pane

package Code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class SurveyFrame extends JFrame implements ActionListener {

	public static String[] userResponses = new String[10];

	// arrays for the things
	String[][] questions = { { "Type of Computer", "Student", "Professional", "Gaming" },
			{ "Processing Cores", "2", "4", "6", "8", "10", "12", "14", "16", "24" }, { "RAM", "4", "8", "16", "32" },
			{ "Storage", "32", "64", "128", "256", "512", "1000", "2000" },
			{ "Operating System", "Windows 11", "ChromeOS", "macOS" },
			{ "Number of USB Ports", "1", "2", "3", "4", "5", "6" } };

//	private double[] displaySizeList = {11.6, 12.5, 13.3, 13.5, 14, 15, 15.6, 16.2, 16.3, 17.3, 18};

	// GUI elements
	private ImageIcon logo = new ImageIcon("Images/pearlogoblack.png");
	private ImageIcon logoIcon = new ImageIcon("Images/pearlogo.png");
	private Image scaledImage = logoIcon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
	private JLabel titleLabel = new JLabel("Pear Survey");
	private ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
	private JLabel logoImage = new JLabel(scaledLogoIcon);
	private JLabel logoLabel = new JLabel("Pear");
	private JPanel titlePanel = new JPanel();

	// constructor method
	public SurveyFrame() {

		// setting up the frame
		setSize(1920, 1080);
		setIconImage(logo.getImage());
		setTitle("Pear Store - Survey Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		// title panel
		titlePanel.setBounds(0, 0, 1920, 150);
		Color titleColor = Color.decode("#511AB6");
		titlePanel.setBackground(titleColor);
		titlePanel.setLayout(null);
		add(titlePanel);

		// the top left name and logo of store
		logoLabel.setFont(new Font("Roboto", Font.BOLD, 60));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setBounds(50, 35, 500, 60);
		titlePanel.add(logoLabel);

		// adding the logo onto the screen
		logoImage.setBounds(150, 15, 100, 100);
		titlePanel.add(logoImage);

		// name of the screen
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 70));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(450, 35, 600, 80);
		titlePanel.add(titleLabel);

		// the question panel
		JPanel questionPanel = new JPanel();
		questionPanel.setLayout(new BoxLayout(questionPanel, BoxLayout.Y_AXIS));

		// the scroll pane with the radio buttons
		JScrollPane scrollPane = new JScrollPane(questionPanel);
		scrollPane.setBounds(100, 200, 730, 580);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(scrollPane);

		// panel which the user enters a specific value
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
		inputPanel.setBounds(790, 540, 400, 580);

		// creating the text field for the maximum screen display size
		JTextField maximumDisplay = createLabeledTextField("Enter maximum screen size (in inches):", 940, 390, 250, 30);
		maximumDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userResponses[0] = maximumDisplay.getText();
			}
		});

		// creating the text field for the minimum screen display size
		JTextField minimumDisplay = createLabeledTextField("Enter minimum screen size (in inches):", 940, 440, 250, 30);
		minimumDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userResponses[1] = minimumDisplay.getText();
			}
		});

		// creating the text field for the maximum value the laptop can cost
		JTextField maximumCost = createLabeledTextField("Enter maximum value ($)", 940, 490, 250, 30);
		maximumCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userResponses[2] = maximumCost.getText();
			}
		});

		// creating the text field for the minimum valoe the laptop can cost
		JTextField minimumCost = createLabeledTextField("Enter minimum value ($)", 940, 540, 250, 30);
		minimumCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userResponses[3] = minimumCost.getText();
			}
		});

		// adding the questions and the options onto the scrollpane
		for (String[] group : questions) {
			questionPanel.add(new JLabel(group[0]));
			ButtonGroup buttonGroup = new ButtonGroup();
			for (int i = 1; i < group.length; i++) {
				JRadioButton radioButton = new JRadioButton(group[i]);
				buttonGroup.add(radioButton);
				radioButton.setFont(new Font("Serif", Font.PLAIN, 24));
				radioButton.setActionCommand(group[i]); // Set the action command to the option value
				radioButton.addActionListener(this); // Register the current instance as the listener
				questionPanel.add(radioButton);
			}
		}

		// creating the button to go back
		JButton backButton = new JButton("Back");
		backButton.setBounds(1066, 12, 190, 126);
		backButton.setBackground(Color.RED);
		backButton.setOpaque(true);
		backButton.setBorderPainted(false);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new LaptopStoreTitleFrame();
				setVisible(false);
			}
		});

		// creating the submit button
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(1268, 12, 250, 126);
		submitButton.setBackground(Color.GREEN);
		submitButton.setOpaque(true);
		submitButton.setBorderPainted(false);
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < 10; i++) {
					System.out.println(userResponses[i]);
				}
				new SurveyResultsFrame();
				setVisible(false);
			}
		});

		// adding the buttons onto the screen
		titlePanel.add(backButton);
		titlePanel.add(submitButton);

		// sets the whole thing to be visible
		setVisible(true);

	}

	// the class that is used to be able to create the text fields for user inputs
	private JTextField createLabeledTextField(String labelText, int x, int y, int width, int height) {
		JLabel label = new JLabel(labelText);
		label.setBounds(x, y, width, height);
		add(label);

		JTextField textField = new JTextField();
		textField.setBounds(x + width + 10, y, width, height);
		add(textField);

		return textField;
	}

	// action listener that gets user's choices
	@Override
	public void actionPerformed(ActionEvent e) {
		// Check the action command of the event to determine which radio button was
		// clicked
		String command = e.getActionCommand();

		// Update the corresponding variable based on which radio button was clicked
		if (Arrays.asList(questions[0]).contains(command)) {
			userResponses[4] = command;
		} else if (Arrays.asList(questions[1]).contains(command)) {
			userResponses[5] = command;
		} else if (Arrays.asList(questions[2]).contains(command)) {
			userResponses[6] = command;
		} else if (Arrays.asList(questions[3]).contains(command)) {
			userResponses[7] = command;
		} else if (Arrays.asList(questions[4]).contains(command)) {
			userResponses[8] = command;
		} else if (Arrays.asList(questions[5]).contains(command)) {
			userResponses[9] = command;
		}

	}

}
