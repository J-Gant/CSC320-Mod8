import java.util.ArrayList;

public class InventoryManager {
	private ArrayList<Automobile> inventory;
	private int nextId = 1;

	// default constructor
	public InventoryManager() {
		this.inventory = new ArrayList<>();
	}

	// adds vehicle objects to ArrayList inventory
	public String addNewVehicle(Automobile vehicle) {
		try {
			vehicle.setId(nextId++); // will auto-increment id
			inventory.add(vehicle);
			return "\n---Vehicle added to inventory.---";
		} catch (Exception e) {
			return "Failed to add vehicle: " + e.getMessage();
		}
	}

	// List all vehicles in ArrayList inventory
	public void listAllVehicles() {
		if (inventory.isEmpty()) {
			System.out.println("Inventory is empty.\n");
			System.out.println();
		} else {
			for (int i = 0; i < inventory.size(); i++) {
				String[] vehicleInfo = inventory.get(i).listVehicleInfo();// calls method in Automobile.java
				for (int j = 0; j < vehicleInfo.length; j++) {
					System.out.print(vehicleInfo[j] + "      ");
				}
				System.out.println("\n");
			}
			System.out.println();
		}
	}

	public boolean removeVehicleById(int id) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getId() == id) {
				inventory.remove(i);
				return true;
			}
		}
		return false;
	}

	public boolean updateVehicleById(int id, String make, String model, String color, int year, int mileage) {
		for (Automobile auto : inventory) {
			if (auto.getId() == id) {
				auto.setMake(make);
				auto.setModel(model);
				auto.setColor(color);
				auto.setYear(year);
				auto.setMileage(mileage);
				return true;
			}
		}
		return false;
	}

	public ArrayList<Automobile> getInventory() {
		return inventory;
	}

}
