package Code;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class FileInput {
	public FileInput() {
	    try {
	    	// Create a Scanner to read the file
	    	Scanner input = new Scanner(new File("data/data2.csv"));

	    	// Use \n as line break delimiter
	        input.useDelimiter(",|\r\n"); 

	        // Skip the first line (header)
	        input.nextLine();

	        for(int index = 0; index < PearApplication.laptopArray.length; index++) {
	        	
	            // Basic Info
	            String brand = input.next();
	            String model = input.next();
	            String type = input.next();
	            double price = input.nextDouble();
	            
	            double qualityRating = input.nextDouble();

	            // CPU
	            String brandCPU = input.next();
	            String typeCPU = input.next();
	            String modelCPU = input.next();
	            int coresCPU = input.nextInt();
	            double speedCPU = input.nextDouble();
	            double qualityRatingCPU = input.nextDouble();

	            // Memory/Storage
	            int ssd = input.nextInt();
	            int ram = input.nextInt();
	            double qualityRatingMemory = input.nextDouble();

	            // GPU
	            String brandGPU = input.next();
	            String modelGPU = input.next();

	            // Connectivity
	            int ports = input.nextInt();
	            String otherConnectivity = input.next();

	            // Operating System
	            String operatingSystem = input.next();

	            // Display size
	            double displaySize = input.nextDouble();
	            String resolution = input.next();
	            String touchscreen = input.next();
	            double qualityRatingDisplay = input.nextDouble();

	            // weight
	            double weight = input.nextDouble();

	            // Link
	            String hyperLink = input.next();

	            PearApplication.laptopArray[index] = new LaptopAppObject(brand, model, type, price, qualityRating, brandCPU, typeCPU, modelCPU,
	                    coresCPU, speedCPU, qualityRatingCPU, ssd, ram, qualityRatingMemory, brandGPU, modelGPU, ports, otherConnectivity,
	                    operatingSystem, displaySize, resolution, touchscreen, qualityRatingDisplay, weight, hyperLink);

	        }

	        input.close();

	    } catch (FileNotFoundException e) {

	        System.out.println("File Error: " + e.getMessage());

	    }
	}

}
