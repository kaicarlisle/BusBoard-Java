package training.busboard;

import java.util.Scanner;

public class UserInput {
	private String inputFromUser;
	private Scanner scan;
	
	public UserInput() {
		this.scan = new Scanner(System.in); 
	}
	
	public String getInput() {
		System.out.println("Enter Postcode");
		inputFromUser = scan.nextLine();
		
		return inputFromUser;
	}
	
	public void closeScanner() {
		this.scan.close();
	}
}
