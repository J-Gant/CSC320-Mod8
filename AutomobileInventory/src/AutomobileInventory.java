
import java.util.Scanner;

public class AutomobileInventory {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		
		System.out.println("Would you like to enter a new vehicle to inventory? (Y or N)");
		String yesOrNo = scnr.next();
		while (yesOrNo.equalsIgnoreCase("Y")) {
			Automobile.addNewVehicle(scnr);
			System.out.println("Add another new vehicle to inventory? (Y or N)");
			yesOrNo = scnr.next();
		}
		
		
			

	}

}
