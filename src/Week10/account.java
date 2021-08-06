package Week10;

import java.util.Scanner;

public class account {

	// Declare a protected int called balance
	protected int balance;
	
	// Constructor that initializes the class to have a balance of 0
	public account() {
		balance = 0;
	}
	
	// Withdraw a specific amount
	public void withdraw(int amount) {
		balance = balance - amount;
		printBal();
	}
	
	// Deposit a specific amount of money into the bank
	public void deposit(int amount) {
		balance = balance + amount;
		printBal();
	}
	
	// Print out the balance of the user 
	public void printBal() {
		System.out.println("You have " + balance + " dollars");
	}
	
	// test is everything is working
	public static void main(String args[]) {
	
		// Declare variables
		Scanner reader = new Scanner(System.in);
		System.out.println("What kind of account would you like to make? Normal (1), Savings (2), Checking (3)");
		boolean done = false;
		switch(reader.nextInt()) {
			case 1:
				account myAcc = new account();
				
				while(!done) {
					System.out.println("What would you like to do? Deposit (1), Withdraw (2), Check Balance (3), End (4)");
					switch(reader.nextInt()) {
						case 1:
							System.out.println("How much?");
							myAcc.deposit(reader.nextInt());
							break;
						case 2:
							System.out.println("How much?");
							myAcc.withdraw(reader.nextInt());
							break;
						case 3:
							myAcc.printBal();
							break;
						case 4:
							done = true;
					}
				}
				break;
			case 2:
				savings mySavings = new savings();
				

				while(!done) {
					System.out.println("What would you like to do? Deposit (1), Withdraw (2), Check Balance (3), End (4)");
					switch(reader.nextInt()) {
						case 1:
							System.out.println("How much?");
							mySavings.deposit(reader.nextInt());
							break;
						case 2:
							System.out.println("How much?");
							mySavings.withdraw(reader.nextInt());
							break;
						case 3:
							mySavings.printBal();
							break;
						case 4:
							done = true;
					}
				}
				
				break;
			case 3:
				checking myChecking = new checking();

				while(!done) {
					System.out.println("What would you like to do? Deposit (1), Withdraw (2), Check Balance (3), End (4)");
					switch(reader.nextInt()) {
						case 1:
							System.out.println("How much?");
							myChecking.deposit(reader.nextInt());
							break;
						case 2:
							System.out.println("How much?");
							myChecking.withdraw(reader.nextInt());
							break;
						case 3:
							myChecking.printBal();
							break;
						case 4:
							done = true;
					}
				}
				
				break;
		}
		
		reader.close();
		
		
	}
}


