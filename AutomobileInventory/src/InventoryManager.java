import java.util.ArrayList;

public class InventoryManager {
	private ArrayList<Automobile> inventory;
	private int nextId = 1;
	
	//default constructor
	public InventoryManager() {
		this.inventory = new ArrayList<>();
	}
	
	//adds vehicle objects to ArrayList inventory
	public String addNewVehicle(Automobile vehicle) {
		try {
			vehicle.setId(nextId++); //will auto-increment id
			inventory.add(vehicle);
			return "Vehicle added to inventory.";
		}
		catch (Exception e) {
			return "Failed to add vehicle: " + e.getMessage();
		}
	}
		
	// List all vehicles in ArrayList inventory
	public void listAllVehicles() {
	    if (inventory.isEmpty()) {
	        System.out.println("Inventory is empty.");
	    }
	    else {
	        for (int i = 0; i < inventory.size(); i++) {
	            for (String index : inventory.get(i).listVehicleInfo()) {
	                System.out.println(index);
	            }
	            System.out.println();
	        }
	    }
	}  
}
