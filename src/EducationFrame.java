//Name: John Zeng
//Date: May 14, 2024
//Description: Education screen to teach the people what certain computer parts are
//Major Skills: Buttons, GUI labels, text

package Code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
	
@SuppressWarnings("serial")
public class EducationFrame extends JFrame implements ActionListener{

	private ImageIcon logoBlack = new ImageIcon("images/pearlogoblack.png");
	// Load the image
	private ImageIcon logoIcon = new ImageIcon("images/pearlogo.png");
	// Calculate the scaled size while preserving aspect ratio
	private Image scaledImage = logoIcon.getImage().getScaledInstance(100, -1, Image.SCALE_SMOOTH);
	// Create a new ImageIcon with the scaled image
	private ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
	private JLabel logoImage = new JLabel(scaledLogoIcon);
	private JLabel logoLabel = new JLabel("Pear");
	private JLabel titleLabel = new JLabel("Education");
	private JPanel titlePanel = new JPanel();
	JButton backButton = new JButton("Back");


	public EducationFrame() {
		
		//Set up the frame
		setSize(1920, 1080);
		setIconImage(logoBlack.getImage());
		setTitle("Pear Store - Education Page");
		setLayout(null);
		
		titlePanel.setBounds(0, 0, 1920, 150);
		Color titleColor = Color.decode("#511AB6");
		titlePanel.setBackground(titleColor);
		titlePanel.setLayout(null);
		add(titlePanel);
		
		logoLabel.setFont(new Font("Roboto", Font.BOLD, 60));
		logoLabel.setForeground(Color.WHITE);
		logoLabel.setBounds(50, 35, 500, 60);
		titlePanel.add(logoLabel);

		logoImage.setBounds(150, 15, 100, 100);
		titlePanel.add(logoImage);

		titleLabel.setFont(new Font("Roboto", Font.BOLD, 70));
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBounds(450, 35, 600, 80);
		titlePanel.add(titleLabel);
		
		//Add JLabels for eductaion information
		JLabel CPULabel = new JLabel("CPU");
		JLabel CPUinfoLabel = new JLabel("<html>AKA Central Proccessing Unit,<br>You can think of it as the brain of your computer<br>doing all the thinking and calculations needed for your computer to work.<br>solving math problems and running programs.</html>");
		
		CPULabel.setBounds(300,150,50,50);
		CPUinfoLabel.setBounds(300,250,200,125);
		
		add(CPULabel);
		add(CPUinfoLabel);
		
		JLabel MemoryLabel = new JLabel("Memory(SSD, RAM)");
		JLabel MemoryinfoLabel = new JLabel("<html>Think of RAM (Random Access Memory) "
				+ "<br>as the short-term memory and SSD (Solid State Drive) as the long-term memory of a computer. "
				+ "<br>RAM: super fast but temporary. "
				+ "<br>Stores data that the computer needs to access quickly whilte it's running programs."
				+ "<br>SSD is slower than RAM but stores data even when the computer is turned off. "
				+ "<br>It holds the operating system, programs, and files like documents, photos, and videos.</html>");
		
		MemoryLabel.setBounds(700,150,200,100);
		MemoryinfoLabel.setBounds(700,200,400,200);
		
		add(MemoryLabel);
		add(MemoryinfoLabel);
		
		JLabel GPULabel = new JLabel("GPU");
		JLabel GPUinfoLabel = new JLabel("<html>The GPU is the part of your computer that makes images and videos look good on your screen"
				+ "<br> especially when you're doing things like playing games, watching videos, or editing photos."
				+ "<br>.It's basically the powerhouse for graphics.</html>");
		
		GPULabel.setBounds(475,500,100,100);
		GPUinfoLabel.setBounds(475,575,200,125);
		
		add(GPULabel);
		add(GPUinfoLabel);
		
		//add back button, return to home page
		JButton backButton = new JButton("Back");
        backButton.setBounds(1328, 12, 190, 126);
        backButton.setBackground(Color.RED);
        backButton.setOpaque(true);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	//opens the intro window
            	new LaptopStoreTitleFrame();
            	
                // Close the current window
                dispose();
            }
        });
        titlePanel.add(backButton);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == backButton) {
			setVisible(false);
			new LaptopStoreTitleFrame();
		}

	}

}