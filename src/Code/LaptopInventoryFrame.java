//Name: Melic Li
//Date: May 14, 2024
//Description: Shows the user all the computers, with options that can sort the computers by certain categories, like price and rating.
//Major Skills: Displaying images, sorting arrays, buttons, radio buttons

package Code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Comparator;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI; //This is URI (Uniform Resource Identifier) not URL (Uniform Resource Locator)
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class LaptopInventoryFrame extends JFrame implements ActionListener {

	// Interface Labels
	// JLabel backgroundTopLabel = new JLabel(new ImageIcon());
	private JLabel logoTitle = new JLabel("Pear");
	private JLabel logo = new JLabel(new ImageIcon("images/pearlogo.png"));
	private JLabel frametitleLabel = new JLabel("Inventory");

	// Array of JLabels for laptops
	private JLabel[] laptopLabelArray;

	// Array of JLabels for laptop names
	private JLabel[] laptopNameArray;

	// Button
	private JButton backButton = new JButton("Back");

	// Top Banner
	private ImageIcon logoBlack = new ImageIcon("images/pearlogoblack.png");
	// Load the image
	private ImageIcon logoIcon = new ImageIcon("images/pearlogo.png");
	// Calculate the scaled size while preserving aspect ratio
	private Image scaledImage = logoIcon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
	// Create a new ImageIcon with the scaled image
	private ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
	private JLabel logoImage = new JLabel(scaledLogoIcon);
	private JLabel logoLabel = new JLabel("Pear");
	private JLabel titleLabel = new JLabel("Inventory");
	private JPanel titlePanel = new JPanel();

	// Sorting Categroies Panel
	private JPanel sidePanel = new JPanel();
	// Sort and Categories
	private JLabel categoriesLabel = new JLabel("Categories:");
	private JRadioButton gamingRadioButton = new JRadioButton("Gaming");
	private JRadioButton studentRadioButton = new JRadioButton("Student");
	private JRadioButton professionalRadioButton = new JRadioButton("Professional");
	private JRadioButton allRadioButton = new JRadioButton("All");

	private JLabel sortLabel = new JLabel("Sort:");
	private JRadioButton ratingRadioButton = new JRadioButton("By Rating");

	private JLabel sortbypriceLabel = new JLabel("By price:");
	private JRadioButton lowtohighRadioButton = new JRadioButton("Low to High");
	private JRadioButton hightolowRadioButton = new JRadioButton("High to Low");

	private JButton filterButton = new JButton("Filter");

	private JPanel laptopPanel = new JPanel();

	// Scroll Bar
	private JScrollPane laptopScrollPane;

	public LaptopInventoryFrame() {

		setLocation(0, 0);

		// Set Application size
		setSize(1545, 820);
		setIconImage(logoBlack.getImage());
		setTitle("Pear Store Application - Laptop Inventory");
		setLayout(null);

		// Pear Top Panel
		titlePanel.setBounds(0, 0, 1920, 150);
		Color titleColor = Color.decode("#511AB6");
		titlePanel.setBackground(titleColor);
		titlePanel.setLayout(null);
		add(titlePanel);

		// Logo Title
		logoLabel.setFont(new Font("Roboto", Font.BOLD, 60));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setBounds(50, 35, 500, 60);
		titlePanel.add(logoLabel);

		// Logo Bounds
		logoImage.setBounds(150, 15, 100, 100);
		titlePanel.add(logoImage);

		// Frame Title
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 70));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(575, 35, 600, 80);
		titlePanel.add(titleLabel);

		// Pear Side Panel
		sidePanel.setBounds(0, 150, 320, 930);
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setLayout(null);
		add(sidePanel);

		// Add all Sorting Buttons/Lables onto Frame
		// Add categoriesLabel
		categoriesLabel.setBounds(20, 20, 200, 30);
		categoriesLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		categoriesLabel.setBackground(Color.WHITE);
		sidePanel.add(categoriesLabel);

		// Add gamingRadioButton
		gamingRadioButton.setBounds(20, 60, 200, 30);
		gamingRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		gamingRadioButton.setBackground(Color.WHITE);
		sidePanel.add(gamingRadioButton);

		// Add studentRadioButton
		studentRadioButton.setBounds(20, 100, 200, 30);
		studentRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		studentRadioButton.setBackground(Color.WHITE);
		sidePanel.add(studentRadioButton);

		// Add professionalRadioButton
		professionalRadioButton.setBounds(20, 140, 200, 30);
		professionalRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		professionalRadioButton.setBackground(Color.WHITE);
		sidePanel.add(professionalRadioButton);

		// Add professionalRadioButton
		allRadioButton.setBounds(20, 180, 200, 30);
		allRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		allRadioButton.setBackground(Color.WHITE);
		sidePanel.add(allRadioButton);

		// Add sortLabel
		sortLabel.setBounds(20, 220, 200, 30);
		sortLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		sortLabel.setBackground(Color.WHITE);
		sidePanel.add(sortLabel);

		// Add ratingRadioButton
		ratingRadioButton.setBounds(20, 260, 200, 30);
		ratingRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		ratingRadioButton.setBackground(Color.WHITE);
		sidePanel.add(ratingRadioButton);

		// Add sortbypriceLabel
		sortbypriceLabel.setBounds(20, 300, 200, 30);
		sortbypriceLabel.setFont(new Font("Roboto", Font.BOLD, 20));
		sortbypriceLabel.setBackground(Color.WHITE);
		sidePanel.add(sortbypriceLabel);

		// Add lowtohighRadioButton
		lowtohighRadioButton.setBounds(20, 340, 200, 30);
		lowtohighRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		lowtohighRadioButton.setBackground(Color.WHITE);
		sidePanel.add(lowtohighRadioButton);

		// Add hightolowRadioButton
		hightolowRadioButton.setBounds(20, 380, 200, 30);
		hightolowRadioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		hightolowRadioButton.setBackground(Color.WHITE);
		sidePanel.add(hightolowRadioButton);

		// Add filterButton
		filterButton.setBounds(20, 420, 200, 60);
		filterButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		sidePanel.add(filterButton);
		// Tells the filter button to function
		filterButton.addActionListener(this);

		// Add backButton
		backButton.setBounds(20, 520, 200, 80);
		backButton.setFont(new Font("Roboto", Font.PLAIN, 20));
		backButton.setBackground(Color.RED);
		sidePanel.add(backButton);
		// Tells the filter button to function
		backButton.addActionListener(this);

		// create button groups
		ButtonGroup categoryButtonGroup = new ButtonGroup();
		ButtonGroup sortButtonGroup = new ButtonGroup();

		// Add to Categories Button Group
		categoryButtonGroup.add(gamingRadioButton);
		categoryButtonGroup.add(studentRadioButton);
		categoryButtonGroup.add(professionalRadioButton);
		categoryButtonGroup.add(allRadioButton);

		// Have All button selected by default
		allRadioButton.setSelected(true);

		// Add to Sort Button Group
		sortButtonGroup.add(ratingRadioButton);
		sortButtonGroup.add(lowtohighRadioButton);
		sortButtonGroup.add(hightolowRadioButton);

		// Have Raring button selected by default
		ratingRadioButton.setSelected(true);

		// Creates Array to display laptop Images
		laptopLabelArray = new JLabel[40];
		// Creates Array to Display Laptop Names and Price
		laptopNameArray = new JLabel[40];

		// Laptop Panel
		laptopPanel = new JPanel();

		// Laptop Panel
		// Gridlayout to set 1st num to set rows and 2nd num to set rows
		// 3rd num to set x axis pixels between images and 4th value to set y axis
		// pixels between images
		laptopPanel.setLayout(new GridLayout(0, 3, 0, 10));
		laptopPanel.setBackground(Color.WHITE);
		laptopPanel.setBorder(new LineBorder(Color.BLACK, 5));
		laptopPanel.setBounds(350, 150, 1600, 880); // Adjusted bounds
		add(laptopPanel);

		// Scroll Pane
		laptopScrollPane = new JScrollPane(laptopPanel);
		laptopScrollPane.setBounds(320, 150, 1600, 630);
		// Change scroll speed for Scroll Pane
		// https://stackoverflow.com/questions/5583495/how-do-i-speed-up-the-scroll-speed-in-a-jscrollpane-when-using-the-mouse-wheel
		laptopScrollPane.getVerticalScrollBar().setUnitIncrement(16);
		add(laptopScrollPane);

		// Call fillLaptopLabels() method to initialize laptopLabelArray
		laptopLabelArray = fillLaptopLabels();

		setResizable(false);
		setVisible(true);

	}

	// Method for opening Web Browser
	// Taken from group leader
	private void openWebBrowser(int index) {

		if (Desktop.isDesktopSupported()) {
			try {
				String urlString = PearApplication.laptopArray[index].getHyperLink();
				urlString = urlString.replaceAll("\\r", ""); // Remove carriage return characters
				URI uri = new URI(urlString);
				Desktop.getDesktop().browse(uri);
			} catch (IOException | URISyntaxException error) {
				error.printStackTrace();
			}
		}

	}

	// Method for adding laptop panels
	private void addLaptopPanel(int index) {

		// Creates a new panel for each image to allow for grouping of info
		JPanel singleLaptopImagePanel = new JPanel();
		// Using the BorderLayout class from stack overflow, the JLabels placed within
		// each panel can be rearranged using NORTH, SOUTH, EAST, WEST, CENTER
		// https://stackoverflow.com/questions/49393806/how-to-arrange-components-using-borderlayout
		singleLaptopImagePanel.setLayout(new BorderLayout());

		// changes the image name
		String laptopName = "images/laptop" + index + ".jpg";

		// Save the Image Icon
		ImageIcon laptopImage = new ImageIcon(laptopName);

		// Resizes the Image Icon
		Image image = laptopImage.getImage();
		Image rescaledLaptopImage = image.getScaledInstance(225, 200, Image.SCALE_SMOOTH);
		// Assigns new scaled image
		ImageIcon scaledLaptopImage = new ImageIcon(rescaledLaptopImage);

		// Displays each scaled Laptop Image as JLabels
		laptopLabelArray[index] = new JLabel(scaledLaptopImage);
		// Adds them to LaptopPanel, using North to put images on the highest point
		singleLaptopImagePanel.add(laptopLabelArray[index], BorderLayout.NORTH);

		// Gets the average rating
		double averageRating = (calculateAverageRating(PearApplication.laptopArray[index]));

		// Create and add name JLabels
		laptopNameArray[index] = new JLabel("<html>" + PearApplication.laptopArray[index].getBrand() + ": "
				+ PearApplication.laptopArray[index].getModel() + "<br>$"
				+ PearApplication.laptopArray[index].getPrice() + "<br>" + "Rating: "
				+ String.format("%.1f", averageRating) + "/10" + "<html>");
		// Change font
		laptopNameArray[index].setFont(new Font("Roboto", Font.PLAIN, 20));
		// Through the use of BorderLayout.CENTER, the name JLabel will be placed under
		// the image at the middlepoint
		singleLaptopImagePanel.add(laptopNameArray[index], BorderLayout.CENTER);

		// Create Buy Button and allows it to work
		JButton buyButton = new JButton("Buy");
		buyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Open web browser for buying the laptop
				openWebBrowser(index);
			}
		});
		// Add Buy Button to the panel using SOUTH to place button at the lowest point
		singleLaptopImagePanel.add(buyButton, BorderLayout.SOUTH);

		// Customizations
		// using set.PrefferredSize, only change the size of the Panel without having to
		// manually set the coordinates
		singleLaptopImagePanel.setPreferredSize(new Dimension(200, 325));
		singleLaptopImagePanel.setBorder(new LineBorder(Color.BLACK, 3));
		singleLaptopImagePanel.setBackground(Color.WHITE);

		// Adds all panels to Main Panel
		laptopPanel.add(singleLaptopImagePanel);

	}

	private JLabel[] fillLaptopLabels() {

		// Set the Coordinates of the laptopScrollPane and add it to the frame
		laptopScrollPane.setBounds(320, 150, 1210, 630);
		add(laptopScrollPane);

		// fills array using for loop
		for (int index = 0; index < laptopLabelArray.length; index++) {

			// Runs method to add new Panels
			addLaptopPanel(index);

		}

		return laptopLabelArray;

	}

	// Method to calculate average rating for all the laptops within the array
	private double calculateAverageRating(LaptopAppObject laptop) {
		// Gets doubles for all rating values
		double qualityRating = laptop.getQualityRating();
		double cpuRating = laptop.getQualityRatingCPU();
		double memoryRating = laptop.getQualityRatingMemory();
		double displayRating = laptop.getQualityRatingDisplay();

		// Returns average of all values
		return (qualityRating + cpuRating + memoryRating + displayRating) / 4;
	}

	// Method to filter laptops based on type and sort based on provided comparator
	private void filter(String type, Comparator<LaptopAppObject> comparator) {
		laptopPanel.removeAll();

		// Sort the laptops based on the provided comparator
		Arrays.sort(PearApplication.laptopArray, comparator);

		// Reset the label arrays
		laptopLabelArray = new JLabel[40];
		laptopNameArray = new JLabel[40];

		for (int index = 0; index < laptopLabelArray.length; index++) {
			// Checks if laptop type matches to selected radio button, then only displays
			// that type
			// If All is selected display all laptops
			if (type.equals("All") || PearApplication.laptopArray[index].getType().equals(type)) {
				// Runs method for filling laptop Panel
				addLaptopPanel(index);
			}
		}

		// Updates frame
		// https://stackoverflow.com/questions/34619381/revalidate-and-repaint-not-updating-my-jpanel
		laptopPanel.revalidate();
		laptopPanel.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// Checks if backButton is clicked
		// https://stackoverflow.com/questions/8214958/the-getsource-and-getactioncommand
		if (event.getSource() == backButton) {
			new LaptopStoreTitleFrame();
			setVisible(false);

			// Otherwise check for sorting
		} else {

			// Set null to ensure no sorting is active on start up, to check if a sorting
			// option is selected later
			Comparator<LaptopAppObject> comparator = null;
			// Check which sorting category of radio button is selected
			// Depending on selected Radio Button, a comparator will be created for the type
			// of sorting
			if (lowtohighRadioButton.isSelected()) {
				comparator = Comparator.comparingDouble(LaptopAppObject::getPrice);
			} else if (hightolowRadioButton.isSelected()) {
				comparator = Comparator.comparingDouble(LaptopAppObject::getPrice).reversed();
			} else if (ratingRadioButton.isSelected()) {
				comparator = Comparator.comparingDouble(this::calculateAverageRating).reversed();
			}
			// Check which category radio button is selected and filter accordingly
			// Filters the type, then uses the assigned comparator to sort by an order
			if (gamingRadioButton.isSelected()) {
				filter("Gaming", comparator);
			} else if (studentRadioButton.isSelected()) {
				filter("Student", comparator);
			} else if (professionalRadioButton.isSelected()) {
				filter("Professional", comparator);
			} else if (allRadioButton.isSelected()) {
				filter("All", comparator);
			}

		}
	}
}
