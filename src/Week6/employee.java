package Week6;

import java.util.ArrayList;
import java.util.Scanner;

/*
THIS IS PROBABLY THE MOST ADVANCED PROGRAM I'VE TURNED IN YET

Neev Mangal
3/8/21 
Tika Kude
B3 AP Computer Science A

This program has an employee class with a number of functions
*/

public class employee {
	
	// Declare variables
	int ID, experience;
	double salary;
	static Scanner reader = new Scanner(System.in);
	
	// Create a new employee
	public void register() {
		System.out.println("Enter an ID");
		ID = reader.nextInt();
		System.out.println("Enter years of experience");
		experience = reader.nextInt();
		System.out.println("Enter a salary");
		salary = reader.nextInt();
		System.out.println("New employee created with ID " + ID + ", salary " + salary + ", and " + experience + " years of service.");

	}
	
	// Add a year of experience
	public void anniversary() {
		experience++;
		System.out.println(ID + " now has " + experience + " years of service.");
	}
	
	
	// Give an employee a raise
	public void raise(double percent) {
		salary = salary * (1 + percent*.01);
		System.out.println("Employee " + ID + "'s new salary is " + salary);
	}
	
	// Give an employee a bonus
	public void bonus() {
		if(experience <= 10) {
			salary = salary * (1.05);
		} else {
			salary = salary * (1.1);
		}
		System.out.println("Employee " + ID +" got a bonus! They now earn " + salary);
	}
	
	public int getID() {
		return ID;
	}
	
	
	// Main method
	
	public static void main(String args[]) {
		
		// Declare variables
		ArrayList<employee> employeeArr = new ArrayList<employee>();;
		boolean done = false;
		String optionChosen;
		
		while(!done) {
			//Get user input
			System.out.println("Welcome to the employee manager, what would you like to do? \n n - new employee \n a - anniversary, everyone gets one more year of experience \n r - give a raise \n b - give a bonus (to everyone) \n e - exit");
			optionChosen = reader.next();
			
			//See what the user wants and execute it
			switch(optionChosen) {
				case "n":
					System.out.println("Registering Employee #" + (employeeArr.size() + 1));
					employee tempemployee = new employee();
					tempemployee.register();
					employeeArr.add(tempemployee);
					break;
				case "b":
					for(int i = 0; i < employeeArr.size(); i++) { 
						employeeArr.get(i).bonus();
					}
					break;
				case "a":
					for(int j = 0; j < employeeArr.size(); j++) { 
						employeeArr.get(j).anniversary();
					}
					break;
				case "r":
					System.out.println("Which employee? Enter an ID");
					int tempID = reader.nextInt();
					for(int j = 0; j < employeeArr.size(); j++) { 
						if(employeeArr.get(j).getID() == tempID) {
							System.out.println("How much (%)?");
							employeeArr.get(j).raise(reader.nextInt());
						}
					}
					break;
				case "e":
					done = true;
				default:
					System.out.println("Try again");
			}
					
				
			}
		reader.close();
	
		}
		
		
}

