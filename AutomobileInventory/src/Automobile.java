import java.util.Scanner;

public class Automobile {
	private String make;
	private String model;
	private String color;
	private int year;
	private int mileage;
	
	public Automobile() {
		this.make = "none specified";
		this.model = "none specified";
		this.color = "none specified";
		this.year = 0;
		this.mileage = 0;
	}
	
	public Automobile(String makeParam, String modelParam, String colorParam, int yearParam, int mileageParam) {
		this.make = makeParam;
		this.model = modelParam;
		this.color = colorParam;
		this.year = yearParam;
		this.mileage = mileageParam;
	}
	
	public static void addNewVehicle(Scanner scnr) {
		
	}
	
	//return string array (loop through array to print)
	public String[] listVehicleInfo() {
		return new String[] {"test", "one", "two", "three"};
	}
	
	public String removeVehicle() {
		return "test";
	}
	
	public void updateVehicle() {
		
	}
}

/*
System.out.println("--Model:");
System.out.println("--Color:");
System.out.println("--Year:");
System.out.println("--Mileage:");

String make = "";
String model = "";
String color = "";
int year = 0;
int mileage = 0;
final String[] ATTRIBUTE_LIST = {"make", "model", "color", "year", "mileage"};
String[] vehicleInput = new String[5];

System.out.println("To add a new vehicle to inventory, please provide the following:\n");
System.out.println("--Make:");
for (int i = 0; i < vehicleInput.length; i++) {
}
*/