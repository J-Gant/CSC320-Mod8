
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class AutomobileInventory {

	public static void main(String[] args) {
			InventoryManager manager = new InventoryManager();
			Scanner scnr = new Scanner(System.in);
			
			System.out.println("Please add vehicle info in the following format or ");
			System.out.println("Type \"q\" to quit.");
			System.out.println();
			System.out.println("make, model, color, year, mileage");

			String input = scnr.nextLine();

			while (!input.equalsIgnoreCase("q")) {
				//try-block assures that the input is formatted correctly
				try {
					String[] inputParts = input.trim().split("\\s*,\\s*");

					if (inputParts.length != 5) {
						throw new IllegalArgumentException(
								"Invalid format. Please enter exactly 5 comma-separated values.");
					}

					//create newVehicle object using parameterized constructor
					Automobile newVehicle = new Automobile(
							inputParts[0], //make
							inputParts[1], //model
							inputParts[2], //color
							Integer.parseInt(inputParts[3].trim()),  //year
							Integer.parseInt(inputParts[4].trim())); //mileage
					
					//Address object creation echoed for user
					System.out.println();
					String[] info = newVehicle.listVehicleInfo();
					for (int i = 1; i < info.length; ++i) {
						System.out.println(info[i]);
					}
					
		            // Add to inventory and print confirmation
		            System.out.println(manager.addNewVehicle(newVehicle));

		            // Show the entire inventory
		            System.out.println("\nCurrent Inventory:");
		            manager.listAllVehicles();

		            // Prompt for next input
		            System.out.println("Add another vehicle or type \"q\" to quit:");
		            input = scnr.nextLine();
					
				}

				//catch prints exception message and accepts new input attempts
				catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
					System.out.println();
					input = scnr.nextLine();
				}
			}
				//program ends when user types "q" and prints "Goodbye"
				if (input.equalsIgnoreCase("q")) {
					System.out.println("\nGoodbye");
					scnr.close();
					System.exit(0);
				}
			
		}
	}
