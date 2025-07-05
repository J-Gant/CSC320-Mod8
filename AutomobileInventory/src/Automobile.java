
public class Automobile {
	private int id;
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	public Automobile() {
		this.id = 1;
		this.make = "none specified";
		this.model = "none specified";
		this.color = "none specified";
		this.year = 0;
		this.mileage = 0;
	}
	
	public Automobile(String makeParam, String modelParam, String colorParam, 
			int yearParam, int mileageParam) {
		this.make = makeParam.trim();
		this.model = modelParam.trim();
		this.color = colorParam.trim();
		this.year = yearParam;
		this.mileage = mileageParam;
	}
	
	//works with addNewVehicle() in InventoryManagement class creating an auto-incremented id field
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	//echo user input before adding vehicle object to inventory
	public String[] listVehicleInfo() {
		String[] listInfo = new String[] {"ID number: " + this.id, "Make: " + this.make,
				"Model: " + this.model, "Color: " + this.color, "Year: " + this.year,
				"Mileage: " + this.mileage};
		return listInfo;
	}
	
	public String removeVehicle() {
		return "test";
	}
	
	public void updateVehicle() {
		
	}
}