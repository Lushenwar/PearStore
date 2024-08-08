//Name: Ryan Qi, Melic Li, John Zeng, Johnny Li
//Date: May 14, 2024
//Description: The Laptop Store is a software application that will simulate an online store that sells 
//a variety of laptops to suit the needs of various end users. When a user enters the online store 
//they are given the choice to either browse the inventory or else complete a survey. If they choose to 
//browse the inventory then the user should be taken to a separate screen that allows them to filter and sort
//the laptops based on a number of criteria. And if they choose to complete the survey then they should be taken
//to another screen where they are asked a variety of questions. After completing the survey a results screen will
//determine the top three laptops that meet their needs. Beyond this the program should also include an educational
//screen that teaches the user about the key components of a laptop (including how to select between various options for different parts). 
//Major Skills: Display images, buttons, sorting by user’s preferences, 
//radio button groups, buttons, text fields, scroll bar/pane, buttons, GUI labels, text,
//sorting arrays, buttons, radio buttons

package Code;

public class PearApplication {

	public static LaptopAppObject[] laptopArray = new LaptopAppObject[40];

	public static void main(String[] args) {

		new FileInput();
		new LaptopInventoryFrame();

	}
	
}
