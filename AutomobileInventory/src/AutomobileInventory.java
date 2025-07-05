
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

public class AutomobileInventory {

	public static void main(String[] args) {
		InventoryManager manager = new InventoryManager();
		Scanner scnr = new Scanner(System.in);
		String input;

		do {
			System.out.println("============    MAIN MENU    ===========\n");
			System.out.println("Please choose one of the following options.\n");
			System.out.println("Please enter:\n");
			System.out.println("  \"a\" to add a new vehicle to inventory.");
			System.out.println("  \"b\" to list all current inventory.");
			System.out.println("  \"c\" to remove a vehicle from inventory.");
			System.out.println("  \"d\" to modify/update a vehicle in inventory.");
			System.out.println("  \"q\" to quit the program");
			System.out.println();

			input = scnr.nextLine().trim().toLowerCase();

			try {

				switch (input) {
				case "a": // add a new vehicle
					System.out.println("Please add vehicle info in the following format or ");
					System.out.println("Type \"q\" to quit.");
					System.out.println();
					System.out.println("make, model, color, year, mileage");

					input = scnr.nextLine();
					String[] inputParts = input.trim().split("\\s*,\\s*");

					if (inputParts.length != 5) {
						throw new IllegalArgumentException(
								"Invalid format. Please enter exactly 5 comma-separated values.");
					}

					// create newVehicle object using parameterized constructor
					Automobile newVehicle = new Automobile(inputParts[0], // make
							inputParts[1], // model
							inputParts[2], // color
							Integer.parseInt(inputParts[3].trim()), // year
							Integer.parseInt(inputParts[4].trim())); // mileage

					// Address object creation echoed for user
					System.out.println();
					System.out.println("You entered the following vehicle information:\n");
					String[] info = newVehicle.listVehicleInfo();
					for (int i = 1; i < info.length; ++i) {
						System.out.println(info[i]);
					}

					System.out.println("\nWould you like to add this vehicle to inventory? (Y or N)");
					String YorN = scnr.next();
					scnr.nextLine(); // consumes extra newline character
					if (YorN.equalsIgnoreCase("Y")) {
						// Add to inventory and print confirmation
						System.out.println(manager.addNewVehicle(newVehicle));
						System.out.println("\n");
					}

					break;

				case "b": // list inventory
					System.out.println("\nCurrent Inventory:");
					manager.listAllVehicles();

					System.out.print("\nWould you like to save the inventory to a file? (Y or N): ");
					String fileChoice = scnr.nextLine().trim();

					if (fileChoice.equalsIgnoreCase("Y")) {
						try {
							String filePath = "C:\\Users\\gant_\\OneDrive\\Documents(Primary) - OneDrive\\Autos_PrintList.txt";
							FileWriter writer = new FileWriter(filePath);

							for (Automobile auto : manager.getInventory()) {
								for (String line : auto.listVehicleInfo()) {
									writer.write(line + System.lineSeparator());
								}
								writer.write(System.lineSeparator());
							}

							writer.close();
							System.out.println("Inventory has been saved to " + filePath + "\n");

						} catch (IOException e) {
							System.out.println("Error writing to file: " + e.getMessage());
						}
					} else {
						System.out.println("File will not be saved.\n");
					}

					break;

				case "c": // remove a vehicle
					System.out.println("Enter the ID of the vehicle to remove: ");
					int removeId = Integer.parseInt(scnr.nextLine().trim());

					if (manager.removeVehicleById(removeId)) {
						System.out.println("Vehicle removed successfully.\n");
					} else {
						System.out.println("Vehicle with ID " + removeId + " not found.\n");
					}
					break;

				case "d": // update a vehicle
					System.out.println("Enter the ID of the vehicle to update: ");
					int updateId = Integer.parseInt(scnr.nextLine().trim());

					System.out.println("Enter new details in the following format:");
					System.out.println("make, model, color, year, mileage");
					String updateInput = scnr.nextLine();
					String[] parts = updateInput.trim().split("\\s*,\\s*");

					if (parts.length != 5) {
						throw new IllegalArgumentException("Please enter exactly 5 comma-separated values.");
					}

					boolean updated = manager.updateVehicleById(updateId, parts[0], parts[1], parts[2],
							Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));

					if (updated) {
						System.out.println("Vehicle updated successfully.\n");
					} else {
						System.out.println("Vehicle with ID " + updateId + " not found.\n");
					}

					break;

				case "q": // quit program
					break;

				default:
					break;

				}
			}
			// catch prints exception message and accepts new input attempts
			catch (IllegalArgumentException e) {
				if (e instanceof NumberFormatException) {
					System.out.println("!!");
					System.out.println("Error: Year and Mileage must be valid integers.");
				} else {
					System.out.println("!!");
					System.out.println(e.getMessage());
				}
				System.out.println("Returning to the main menu.");
				System.out.println();
				continue;
			}

		} while (!input.equalsIgnoreCase("q"));

		// program ends when user types "q" and prints "Goodbye"
		if (input.equalsIgnoreCase("q")) {
			System.out.println("\nGoodbye");
			scnr.close();
			System.exit(0);
		}

	}
}
