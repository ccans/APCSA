package Week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*

Neev Mangal
4/26/21 
Tika Kude
B3 AP Computer Science A

This program is an interfaces example of a phonebook with various functions 
*/

public class interfaces1 implements PhoneBook{
	
	// Declare class variables (parallel arrays)
	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> phoneNumbers = new ArrayList<String>();

	public void ReadInfo() throws FileNotFoundException {
		// Read the file
		Scanner reader = new Scanner(new File("input.txt"));
		
		// Note, my file has a number at the top that stores that number of contacts in the file
		int num = reader.nextInt();
		
		// Loop through and add the relevant information
		for(int i = 0; i < num; i++) {
			names.add(reader.nextLine());
		}
		for(int i = 0; i < num; i++) {
			phoneNumbers.add(reader.nextLine());
		}
		reader.close();
	}

	// Use a name to find a number using the parallel arrays
	public String FindNumber(String name) {
		for(int j = 0; j < names.size(); j++) {
			if(names.get(j).equals(name)) return phoneNumbers.get(j);
		}
		return "Not found";
	}

	// Use a number to find a name using the parallel arrays
	public String FindName(String phonenumber) {
		for(int j = 0; j < phoneNumbers.size(); j++) {
			if(phoneNumbers.get(j).equals(phonenumber)) return names.get(j);
		}
		return "Not Found";
	}
	
	
	public static void main(String args[]) throws FileNotFoundException {
		
		// Create an instance of the class
		PhoneBook lookup = new interfaces1();
		Scanner input = new Scanner(System.in);
		
		// Call the readinfo method
		lookup.ReadInfo();
		
		boolean done = false;
		while(!done) {
			// Ask the user what they want to do
			System.out.println("Would you like to lookup a name (0) or a number (1)? Press (2) to exit the system");
			// The switch calls the appropriate function 
			switch(input.nextInt()) {
				case 0:
					System.out.println("Enter the name");
					System.out.println("The number  associated with that name is " + lookup.FindNumber(input.next()));
					break;
				case 1:
					System.out.println("Enter the number");
					System.out.println("The name associated with that number is " + lookup.FindName(input.next()));
					break;
				case 2:
					input.close();
					done = true;
					break;
				default:
					System.out.println("Please try again");
			
			}
		}
		
	}
	
	
}
