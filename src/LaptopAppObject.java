package Code;

import javax.swing.JLabel;

@SuppressWarnings("serial")
public class LaptopAppObject extends JLabel {

	// Basic Info
	private String brand;
	private String model;
	private String type;
	private double price;
	private double qualityRating;

	// CPU
	private String brandCPU;
	private String typeCPU;
	private String modelCPU;
	private int coresCPU;
	private double speedCPU;
	private double qualityRatingCPU;

	// Memory/Storage
	private int ssd;
	private int ram;
	private double qualityRatingMemory;

	// GPU
	private String brandGPU;
	private String modelGPU;

	// Connectivity
	private int ports;
	private String otherConnectivity;

	// Operating System
	private String operatingSystem;

	// Display size
	private double displaySize;
	private String resolution;
	private String touchscreen;
	private double qualityRatingDisplay;

	// weight
	private double weight;

	// Link
	private String hyperLink;

	public LaptopAppObject(String brand, String model, String type, double price, double qualityRating, String brandCPU,
			String typeCPU, String modelCPU, int coresCPU, double speedCPU, double qualityRatingCPU, int ssd, int ram,
			double qualityRatingMemory2, String brandGPU, String modelGPU, int ports, String otherConnectivity,
			String operatingSystem, double displaySize, String resolution, String touchscreen,
			double qualityRatingDisplay, double weight, String hyperLink) {
		super();
		this.brand = brand;
		this.model = model;
		this.type = type;
		this.price = price;
		this.qualityRating = qualityRating;
		this.brandCPU = brandCPU;
		this.typeCPU = typeCPU;
		this.modelCPU = modelCPU;
		this.coresCPU = coresCPU;
		this.speedCPU = speedCPU;
		this.qualityRatingCPU = qualityRatingCPU;
		this.ssd = ssd;
		this.ram = ram;
		this.qualityRatingMemory = qualityRatingMemory2;
		this.brandGPU = brandGPU;
		this.modelGPU = modelGPU;
		this.ports = ports;
		this.otherConnectivity = otherConnectivity;
		this.operatingSystem = operatingSystem;
		this.displaySize = displaySize;
		this.resolution = resolution;
		this.touchscreen = touchscreen;
		this.qualityRatingDisplay = qualityRatingDisplay;
		this.weight = weight;
		this.hyperLink = hyperLink;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQualityRating() {
		return qualityRating;
	}

	public void setQualityRating(double qualityRating) {
		this.qualityRating = qualityRating;
	}

	public String getBrandCPU() {
		return brandCPU;
	}

	public void setBrandCPU(String brandCPU) {
		this.brandCPU = brandCPU;
	}

	public String getTypeCPU() {
		return typeCPU;
	}

	public void setTypeCPU(String typeCPU) {
		this.typeCPU = typeCPU;
	}

	public String getModelCPU() {
		return modelCPU;
	}

	public void setModelCPU(String modelCPU) {
		this.modelCPU = modelCPU;
	}

	public int getCoresCPU() {
		return coresCPU;
	}

	public void setCoresCPU(int coresCPU) {
		this.coresCPU = coresCPU;
	}

	public double getSpeedCPU() {
		return speedCPU;
	}

	public void setSpeedCPU(double speedCPU) {
		this.speedCPU = speedCPU;
	}

	public double getQualityRatingCPU() {
		return qualityRatingCPU;
	}

	public void setQualityRatingCPU(double qualityRatingCPU) {
		this.qualityRatingCPU = qualityRatingCPU;
	}

	public int getSsd() {
		return ssd;
	}

	public void setSsd(int ssd) {
		this.ssd = ssd;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public double getQualityRatingMemory() {
		return qualityRatingMemory;
	}

	public void setQualityRatingMemory(int qualityRatingMemory) {
		this.qualityRatingMemory = qualityRatingMemory;
	}

	public String getBrandGPU() {
		return brandGPU;
	}

	public void setBrandGPU(String brandGPU) {
		this.brandGPU = brandGPU;
	}

	public String getModelGPU() {
		return modelGPU;
	}

	public void setModelGPU(String modelGPU) {
		this.modelGPU = modelGPU;
	}

	public int getPorts() {
		return ports;
	}

	public void setPorts(int ports) {
		this.ports = ports;
	}

	public String getOtherConnectivity() {
		return otherConnectivity;
	}

	public void setOtherConnectivity(String otherConnectivity) {
		this.otherConnectivity = otherConnectivity;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String isTouchscreen() {
		return touchscreen;
	}

	public void setTouchscreen(String touchscreen) {
		this.touchscreen = touchscreen;
	}

	public double getQualityRatingDisplay() {
		return qualityRatingDisplay;
	}

	public void setQualityRatingDisplay(double qualityRatingDisplay) {
		this.qualityRatingDisplay = qualityRatingDisplay;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getHyperLink() {
		return hyperLink;
	}

	public void setHyperLink(String hyperLink) {
		this.hyperLink = hyperLink;
	}

	@Override
	public String toString() {
		return "LaptopAppObject [brand=" + brand + ", model=" + model + ", type=" + type + ", price=" + price
				+ ", qualityRating=" + qualityRating + ", brandCPU=" + brandCPU + ", typeCPU=" + typeCPU + ", modelCPU="
				+ modelCPU + ", coresCPU=" + coresCPU + ", speedCPU=" + speedCPU + ", qualityRatingCPU="
				+ qualityRatingCPU + ", ssd=" + ssd + ", ram=" + ram + ", qualityRatingMemory=" + qualityRatingMemory
				+ ", brandGPU=" + brandGPU + ", modelGPU=" + modelGPU + ", ports=" + ports + ", otherConnectivity="
				+ otherConnectivity + ", operatingSystem=" + operatingSystem + ", displaySize=" + displaySize
				+ ", resolution=" + resolution + ", touchscreen=" + touchscreen + ", qualityRatingDisplay="
				+ qualityRatingDisplay + ", weight=" + weight + ", hyperLink=" + hyperLink + "]";
	}
}
