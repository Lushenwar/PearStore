//Name: Ryan Qi
//Date: May 14, 2024
//Description: Displays the computers that best fits the user’s survey results
//Major Skills: Display images, buttons, sorting by user’s preferences

//create package
package Code;

//import from java library
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import javax.swing.*;

//Supress Warning
@SuppressWarnings("serial")
//Create Class
public class SurveyResultsFrame extends JFrame implements ActionListener {
	// Declare image icons for logos
	private ImageIcon logoBlack = new ImageIcon("images/pearlogoblack.png");
	private ImageIcon logoIcon = new ImageIcon("images/pearlogo.png");
	// https://stackoverflow.com/questions/18396302/how-to-scale-image-using-getscaledinstance
	// Calculate the scaled size while preserving aspect ratio
	private Image scaledImage = logoIcon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
	// Create a new ImageIcon with the scaled image
	private ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
	// Declare JLabel for storing image icons
	private JLabel logoImage = new JLabel(scaledLogoIcon);

	// Declare image icons for laptops
	private ImageIcon firstLaptopIcon;
	private ImageIcon secondLaptopIcon;
	private ImageIcon thirdLaptopIcon;

	// Declare labels for laptop images
	private JLabel firstImage;
	private JLabel secondImage;
	private JLabel thirdImage;

	// Declare labels for laptop numbers
	private JLabel firstLabel = new JLabel("1");
	private JLabel secondLabel = new JLabel("2");
	private JLabel thirdLabel = new JLabel("3");

	// Declare labels for laptop descriptions
	private JLabel firstDescription;
	private JLabel secondDescription;
	private JLabel thirdDescription;

	// Declare labels for laptop costs
	private JLabel firstCost;
	private JLabel secondCost;
	private JLabel thirdCost;

	// Declare logo label
	private JLabel logoLabel = new JLabel("Pear");

	// Declare title label
	private JLabel titleLabel = new JLabel("Survey Results");

	// Declare panels
	private JPanel titlePanel = new JPanel();
	private JPanel descriptionPanel = new JPanel();
	private JPanel imagePanel = new JPanel();

	// https://stackoverflow.com/questions/1842223/java-linebreaks-in-jlabels
	// Declare description labels with line breaks
	private JLabel firstDescriptionLabel = new JLabel("<html>Based on Your<br>Preferences</html>");
	private JLabel secondDescriptionLabel = new JLabel("<html>These Laptops<br>Would Be Perfect<br>for You:</html>");

	// Declare buttons for exit button
	private static JButton backButton = new JButton("Exit");

	// Declare buttons for visiting websites
	private static JButton visitWebsiteButton1 = new JButton("Visit Website");
	private static JButton visitWebsiteButton2 = new JButton("Visit Website");
	private static JButton visitWebsiteButton3 = new JButton("Visit Website");

	// index of the largest, middle, smallest values and recurring values
	private static int indexLargest = 0;
	private static int indexSmallest = 0;
	private static int indexMiddle = 0;

	// Create Frame
	public SurveyResultsFrame() {
		// Set the size of the frame to 1920x1080 pixels
		setSize(1545, 820);
		// Set the icon of the frame to the black logo
		setIconImage(logoBlack.getImage());
		// Set the title of the frame
		setTitle("Pear Store Application - Survey Results");
		// Disable layout manager
		setLayout(null);

		// Set Bounds of title panel
		titlePanel.setBounds(0, 0, 1920, 150);
		// https://www.tabnine.com/code/java/methods/java.awt.Color/decode
		// Create custom color
		Color titleColor = Color.decode("#191C1D");
		// Set the background color of the title panel
		titlePanel.setBackground(titleColor);
		// Disable layout manager for the title panel
		titlePanel.setLayout(null);
		// Add the title panel to the frame
		add(titlePanel);

		// Initialize the exit button
		backButton = new JButton("Back");
		// Set font of exit button
		backButton.setFont(new Font("Roboto", Font.PLAIN, 60));
		backButton.setForeground(Color.WHITE);
		// Set background color of button
		backButton.setBackground(Color.RED);
		// Set the bounds of the exit button
		backButton.setBounds(1250, 20, 200, 120);
		// Add action listener to the exit button
		backButton.addActionListener(this);
		// Add the exit button to the frame
		titlePanel.add(backButton);

		// Set font, style, size, and color for the logoLabel
		logoLabel.setFont(new Font("Roboto", Font.BOLD, 60));
		logoLabel.setForeground(Color.WHITE);
		// Set the position and size of the logoLabel within the title panel
		logoLabel.setBounds(50, 35, 500, 60);
		// Add the logoLabel to the title panel
		titlePanel.add(logoLabel);

		// Set the position and size of the logoImage within the title panel
		logoImage.setBounds(160, 15, 100, 100);
		// Add the logoImage to the title panel
		titlePanel.add(logoImage);

		// Set font, style, size, and color for the titleLabel
		titleLabel.setFont(new Font("Roboto", Font.BOLD, 75));
		// Set the position and size of the titleLabel within the title panel
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(460, 0, 800, 150);
		// Add the titleLabel to the title panel
		titlePanel.add(titleLabel);

		// Set the bounds of the description panel
		descriptionPanel.setBounds(0, 150, 400, 930);
		// Define Custom color
		Color purpleColor = Color.decode("#1F073D");
		// Set the background color of the description panel
		descriptionPanel.setBackground(purpleColor);
		// Disable layout manager for the description panel
		descriptionPanel.setLayout(null);
		// Add the description panel to the frame
		add(descriptionPanel);

		// Set font, style, size, and color for the firstDescriptionLabel
		firstDescriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 45));
		firstDescriptionLabel.setForeground(Color.WHITE);
		// Set Bounds for first description label
		firstDescriptionLabel.setBounds(40, 40, 400, 200);
		// Add to description panel
		descriptionPanel.add(firstDescriptionLabel);

		// Set font, style, size, and color for the secondDescriptionLabel
		secondDescriptionLabel.setFont(new Font("Roboto", Font.PLAIN, 40));
		secondDescriptionLabel.setForeground(Color.WHITE);
		// Set Bounds for first description label
		secondDescriptionLabel.setBounds(40, 250, 400, 200);
		// Add to description panel
		descriptionPanel.add(secondDescriptionLabel);

		// Find laptop recommendations
		findRecommendations();

		// Load laptop images
		firstLaptopIcon = new ImageIcon("images/laptop" + indexMiddle + ".jpg");
		secondLaptopIcon = new ImageIcon("images/laptop" + indexLargest + ".jpg");
		thirdLaptopIcon = new ImageIcon("images/laptop" + indexSmallest + ".jpg");

		// https://stackoverflow.com/questions/18396302/how-to-scale-image-using-getscaledinstance
		// Scale the images while preserving aspect ratio
		Image scaledFirstLaptop = firstLaptopIcon.getImage().getScaledInstance(250, -1, Image.SCALE_SMOOTH);
		Image scaledSecondLaptop = secondLaptopIcon.getImage().getScaledInstance(250, -1, Image.SCALE_SMOOTH);
		Image scaledThirdLaptop = thirdLaptopIcon.getImage().getScaledInstance(250, -1, Image.SCALE_SMOOTH);

		// Initialize labels with scaled laptop images
		firstImage = new JLabel(new ImageIcon(scaledFirstLaptop));
		secondImage = new JLabel(new ImageIcon(scaledSecondLaptop));
		thirdImage = new JLabel(new ImageIcon(scaledThirdLaptop));

		// Set bounds for image panel
		imagePanel.setBounds(400, 150, 1360, 930);
		imagePanel.setBackground(Color.WHITE);
		imagePanel.setLayout(null);
		add(imagePanel);

		// Set font, style, and size for second label
		secondLabel.setFont(new Font("Roboto", Font.BOLD, 80));
		// Set text color for second label
		secondLabel.setForeground(purpleColor);
		// Set the position and size of second label within imagePanel
		secondLabel.setBounds(125, 15, 60, 70);
		// Add second label to imagePanel
		imagePanel.add(secondLabel);

		// Set font, style, and size for first label
		firstLabel.setFont(new Font("Roboto", Font.BOLD, 80));
		// Set text color for first label
		firstLabel.setForeground(purpleColor);
		// Set the position and size of first label within imagePanel
		firstLabel.setBounds(525, 15, 60, 70);
		// Add firstLabel to imagePanel
		imagePanel.add(firstLabel);

		// Set font, style, and size for third label
		thirdLabel.setFont(new Font("Roboto", Font.BOLD, 80));
		// Set text color for thirdLabel
		thirdLabel.setForeground(purpleColor);
		// Set the position and size of third label within imagePanel
		thirdLabel.setBounds(925, 15, 60, 70);
		// Add thirdLabel to imagePanel
		imagePanel.add(thirdLabel);

		// Set the position and size of first image within imagePanel
		firstImage.setBounds(25, 85, 250, 250);
		// Add firstImage to imagePanel
		imagePanel.add(firstImage);

		// Set the position and size of second image within imagePanel
		secondImage.setBounds(425, 85, 250, 250);
		// Add secondImage to imagePanel
		imagePanel.add(secondImage);

		// Set the position and size of third image within imagePanel
		thirdImage.setBounds(825, 85, 250, 250);
		// Add third image to imagePanel
		imagePanel.add(thirdImage);

		// Set laptop descriptions
		firstDescription = new JLabel("<html>" + PearApplication.laptopArray[indexLargest].getBrand() + "<br>"
				+ PearApplication.laptopArray[indexLargest].getModel() + "<html>");
		secondDescription = new JLabel("<html>" + PearApplication.laptopArray[indexMiddle].getBrand() + "<br>"
				+ PearApplication.laptopArray[indexMiddle].getModel() + "<html>");
		thirdDescription = new JLabel("<html>" + PearApplication.laptopArray[indexSmallest].getBrand() + "<br>"
				+ PearApplication.laptopArray[indexSmallest].getModel() + "<html>");

		// https://www.tabnine.com/code/java/methods/javax.swing.JLabel/setHorizontalAlignment
		// Center the text of the JLabel
		firstDescription.setHorizontalAlignment(SwingConstants.CENTER);
		secondDescription.setHorizontalAlignment(SwingConstants.CENTER);
		thirdDescription.setHorizontalAlignment(SwingConstants.CENTER);

		// Set font and color for laptop descriptions
		secondDescription.setFont(new Font("Roboto", Font.PLAIN, 27));
		secondDescription.setForeground(purpleColor);
		// Set bounds for Description
		secondDescription.setBounds(-10, 325, 350, 80);
		// Add to image panel
		imagePanel.add(secondDescription);

		// Set font and color for laptop descriptions
		firstDescription.setFont(new Font("Roboto", Font.PLAIN, 27));
		firstDescription.setForeground(purpleColor);
		// Set bounds for Description
		firstDescription.setBounds(360, 325, 350, 80);
		// Add to image panel
		imagePanel.add(firstDescription);

		// Set font and color for laptop descriptions
		thirdDescription.setFont(new Font("Roboto", Font.PLAIN, 27));
		thirdDescription.setForeground(purpleColor);
		// Set bounds for Description
		thirdDescription.setBounds(775, 325, 350, 80);
		// Add to image panel
		imagePanel.add(thirdDescription);

		// Finds the average rating of each computer
		double averageRatingLargest = (calculateAverageRating(PearApplication.laptopArray[indexLargest]));
		double averageRatingMiddle = (calculateAverageRating(PearApplication.laptopArray[indexMiddle]));
		double averageRatingSmallest = (calculateAverageRating(PearApplication.laptopArray[indexSmallest]));

		// Set laptop Costs
		firstCost = new JLabel("<html>" + "$" + PearApplication.laptopArray[indexLargest].getPrice() + "<br>"
				+ "Rating: " + String.format("%.1f", averageRatingLargest) + "/10" + "<html>");
		secondCost = new JLabel("<html>" + "$" + PearApplication.laptopArray[indexMiddle].getPrice() + "<br>"
				+ "Rating: " + String.format("%.1f", averageRatingMiddle) + "/10" + "<html>");
		thirdCost = new JLabel("<html>" + "$" + PearApplication.laptopArray[indexSmallest].getPrice() + "<br>"
				+ "Rating: " + String.format("%.1f", averageRatingSmallest) + "/10" + "<html>");

		// https://www.tabnine.com/code/java/methods/javax.swing.JLabel/setHorizontalAlignment
		// Center the text of the JLabel
		firstCost.setHorizontalAlignment(SwingConstants.CENTER);
		secondCost.setHorizontalAlignment(SwingConstants.CENTER);
		thirdCost.setHorizontalAlignment(SwingConstants.CENTER);

		// Setting font, size, and style for the label
		secondCost.setFont(new Font("Roboto", Font.PLAIN, 27));
		// Set the foreground color
		secondCost.setForeground(purpleColor);
		// Setting the position and size within imagePanel
		secondCost.setBounds(0, 420, 300, 80);
		// Add cost to imagePanel
		imagePanel.add(secondCost);

		// Setting font, size, and style for the label
		firstCost.setFont(new Font("Roboto", Font.PLAIN, 27));
		// Set the foreground color
		firstCost.setForeground(purpleColor);
		// Setting the position and size within imagePanel
		firstCost.setBounds(400, 420, 300, 80);
		// Add cost to imagePanel
		imagePanel.add(firstCost);

		// Setting font, size, and style for the label
		thirdCost.setFont(new Font("Roboto", Font.PLAIN, 27));
		// Set the foreground color
		thirdCost.setForeground(purpleColor);
		// Setting the position and size within imagePanel
		thirdCost.setBounds(800, 420, 300, 80);
		// Add cost to imagePanel
		imagePanel.add(thirdCost);

		// Add visitWebsiteButton1
		// Setting font, size, and style for the button
		visitWebsiteButton1.setFont(new Font("Roboto", Font.PLAIN, 26));
		visitWebsiteButton1.setBackground(Color.WHITE);
		// Adjust the position and size of button
		visitWebsiteButton1.setBounds(50, 520, 210, 55);
		imagePanel.add(visitWebsiteButton1);
		// Create response for when button is pressed
		visitWebsiteButton1.addActionListener(this);

		// Add visitWebsiteButton2
		// Setting font, size, and style for the button
		visitWebsiteButton2.setFont(new Font("Roboto", Font.PLAIN, 26));
		visitWebsiteButton2.setBackground(Color.WHITE);
		// Adjust the position and size of button
		visitWebsiteButton2.setBounds(450, 520, 210, 55);
		imagePanel.add(visitWebsiteButton2);
		// Create response for when button is pressed
		visitWebsiteButton2.addActionListener(this);

		// Add visitWebsiteButton3
		// Setting font, size, and style for the button
		visitWebsiteButton3.setFont(new Font("Roboto", Font.PLAIN, 26));
		visitWebsiteButton3.setBackground(Color.WHITE);
		// Adjust the position and size of button
		visitWebsiteButton3.setBounds(850, 520, 210, 55);
		imagePanel.add(visitWebsiteButton3);
		// Create response for when button is pressed
		visitWebsiteButton3.addActionListener(this);

		// Make components visible on screen
		setVisible(true);
		setResizable(false);
	}

	// Handles actions performed by the user on buttons.
	@Override
	public void actionPerformed(ActionEvent e) {
		// check if triggered by first button
		if (e.getSource() == visitWebsiteButton1) {
			// Open web browser
			openWebBrowser(indexMiddle);
		}
		// check if triggered by second button
		else if (e.getSource() == visitWebsiteButton2) {
			// Open web browser
			openWebBrowser(indexLargest);
		}
		// check if triggered by third button
		else if (e.getSource() == visitWebsiteButton3) {
			// Open web browser
			openWebBrowser(indexSmallest);
		}
		// Check if triggered by exit button
		else if (e.getSource() == backButton) {
			// Close the frame and return to survey frame
			new SurveyFrame();
			setVisible(false);
		}
	}

	// Method to open a web browser based on the index of the laptop
	private void openWebBrowser(int index) {
		// Check if Desktop is supported
		if (Desktop.isDesktopSupported()) {
			try {
				// Get URL string from LaptopArray
				String urlString = PearApplication.laptopArray[index].getHyperLink();
				// https://stackoverflow.com/questions/10499005/how-to-remove-a-carriage-return-from-a-string
				// Remove carriage return characters
				urlString = urlString.replaceAll("\\r", "");
				// Open the web browser with URL
				Desktop.getDesktop().browse(new URI(urlString));
			} catch (IOException error) {
				// Print stack trace if an IOException occurs
				error.printStackTrace();
			} catch (URISyntaxException error) {
				// Print stack trace if a URISyntaxException occurs
				error.printStackTrace();
			}
		}
	}

	// calculates the average rating
	private double calculateAverageRating(LaptopAppObject laptop) {
		// gets the quality rating
		double qualityRating = laptop.getQualityRating();
		// get the cpu rating
		double cpuRating = laptop.getQualityRatingCPU();
		// get the memory rating
		double memoryRating = laptop.getQualityRatingMemory();
		// get the display rating
		double displayRating = laptop.getQualityRatingDisplay();

		// return the average of the four
		return (qualityRating + cpuRating + memoryRating + displayRating) / 4;

	}

	// finds the recommendations based off of the values from the survey
	private static void findRecommendations() {

		// place holder answers for when the survey result is null
		double displaySizeMax = 8.8;
		double displaySizeMin = 8.0;
		double maximumBudget = 600.50;
		double minimumBudget = 199.99;
		String type = "Student";
		int cores = 4;
		int ram = 8;
		int storagePreference = 64;
		String operatingSystem = "Windows 11";
		int usbPorts = 1;

		// Determine when the survey frame provides null value in order to use place
		// holder answers
		if (SurveyFrame.userResponses[0] != null) {
			displaySizeMax = Double.valueOf(SurveyFrame.userResponses[0]);
		}
		if (SurveyFrame.userResponses[1] != null) {
			displaySizeMin = Double.valueOf(SurveyFrame.userResponses[1]);
		}
		if (SurveyFrame.userResponses[2] != null) {
			maximumBudget = Double.valueOf(SurveyFrame.userResponses[2]);
		}
		if (SurveyFrame.userResponses[3] != null) {
			minimumBudget = Double.valueOf(SurveyFrame.userResponses[3]);
		}
		if (SurveyFrame.userResponses[4] != null) {
			type = SurveyFrame.userResponses[4];
		}
		if (SurveyFrame.userResponses[5] != null) {
			cores = Integer.valueOf(SurveyFrame.userResponses[5]);
		}
		if (SurveyFrame.userResponses[6] != null) {
			ram = Integer.valueOf(SurveyFrame.userResponses[6]);
		}
		if (SurveyFrame.userResponses[7] != null) {
			storagePreference = Integer.valueOf(SurveyFrame.userResponses[7]);
		}
		if (SurveyFrame.userResponses[8] != null) {
			operatingSystem = SurveyFrame.userResponses[8];
		}
		if (SurveyFrame.userResponses[9] != null) {
			usbPorts = Integer.valueOf(SurveyFrame.userResponses[9]);
		}

		// accumulator
		int[] laptopPoints = new int[PearApplication.laptopArray.length];

		// use for loop to go through every laptop
		for (int index = 0; index < laptopPoints.length; index++) {
			// if PearApplication.laptopArray fits the min/max, add one to the index where
			// the laptop info is located
			if (PearApplication.laptopArray[index].getPrice() >= minimumBudget
					&& PearApplication.laptopArray[index].getPrice() <= maximumBudget) {
				laptopPoints[index]++;
			}
			// if it is equal to the storage user asked for
			if (PearApplication.laptopArray[index].getSsd() == storagePreference) {
				laptopPoints[index]++;
			}
			// if it is between the sizes of the display add one
			if (PearApplication.laptopArray[index].getDisplaySize() >= displaySizeMin
					&& PearApplication.laptopArray[index].getDisplaySize() <= displaySizeMax) {
				laptopPoints[index]++;

			}
			// if it is equal to the ram size, add one
			if (PearApplication.laptopArray[index].getRam() == ram) {
				laptopPoints[index]++;
			}
			// if it is equal to the number of cores, add one
			if (PearApplication.laptopArray[index].getCoresCPU() == cores) {
				laptopPoints[index]++;
			}
			// if it is equal to the type of laptop, add one
			if (PearApplication.laptopArray[index].getType() == type) {
				laptopPoints[index]++;
			}
			// if it is equal to the operating system, add one
			if (PearApplication.laptopArray[index].getOperatingSystem() == operatingSystem) {
				laptopPoints[index]++;
			}
			// if it is equal to the usb ports, add one
			if (PearApplication.laptopArray[index].getPorts() == usbPorts) {
				laptopPoints[index]++;
			}

		}

		// find which 3 laptops have the most points

		// set them to the lowest value, so the first value can always be larger
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		int c = Integer.MIN_VALUE;

		// use for loop to go through all iterations
		for (int index = 0; index < laptopPoints.length; index++) {
			// if the value is larger than the current value, make it to the current value
			// and the iteration
			if (laptopPoints[index] > a) {
				c = b;
				b = a;
				a = laptopPoints[index];
				indexLargest = index;
			}
			// if the value is larger than the 2nd largest value, make it the 2nd largest
			// value
			// and make it the iteration
			else if (laptopPoints[index] > b) {
				c = b;
				b = laptopPoints[index];
				indexMiddle = index;
			}
			// if the value is larger than the 3rd largest value, make it the 3rd largest
			// value,
			// and make the specific iteration the placeholder
			else if (laptopPoints[index] > c) {
				c = laptopPoints[index];
				indexSmallest = index;
			}
		}

	}

}
