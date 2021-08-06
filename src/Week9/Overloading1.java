package Week9;

import java.util.Scanner;

/*

Neev Mangal
4/12/21 
Tika Kude
B3 AP Computer Science A

This program is an overloading class demo with multiple math functions
*/

public class Overloading1 {

	public static void main(String args[]) {
		
		
		// Create instance and variables
		Overloading1 worker = new Overloading1();
		Scanner reader = new Scanner(System.in);
		int[] pref = new int[2];
		
		// Get user input
		
		System.out.println("Would you like to add (1), subtract (2), multiply (3), or divide (4)?");
		pref[0] = reader.nextInt();
		System.out.println("Would you like to enter a float (1), double (2), or int (3)?");
		pref[1] = reader.nextInt();
		
		
		// Nested switch to call the appropriate function
		switch(pref[1]) {
			case 1:
				float float1, float2;
				System.out.println("Enter your first float");
				float1 = reader.nextFloat();
				System.out.println("Enter your second float");
				float2 = reader.nextFloat();
				switch(pref[0]) {
					case 1:
						System.out.println(worker.add(float1, float2));
						break;
					case 2:
						System.out.println(worker.subtract(float1, float2));
						break;
					case 3:
						System.out.println(worker.multiply(float1, float2));
						break;
					case 4:
						System.out.println(worker.divide(float1, float2));
						break;
				}
				break;
			case 2:
				double double1, double2;
				System.out.println("Enter your first double");
				double1 = reader.nextDouble();
				System.out.println("Enter your second double");
				double2 = reader.nextDouble();
				switch(pref[0]) {
				case 1:
					System.out.println(worker.add(double1, double2));
					break;
				case 2:
					System.out.println(worker.subtract(double1, double2));
					break;
				case 3:
					System.out.println(worker.multiply(double1, double2));
					break;
				case 4:
					System.out.println(worker.divide(double1, double2));
					break;
			}
				break;
			case 3:
				int int1, int2;
				System.out.println("Enter your first integer");
				int1 = reader.nextInt();
				System.out.println("Enter your second integer");
				int2 = reader.nextInt();
				switch(pref[0]) {
				case 1:
					System.out.println(worker.add(int1, int2));
					break;
				case 2:
					System.out.println(worker.subtract(int1, int2));
					break;
				case 3:
					System.out.println(worker.multiply(int1, int2));
					break;
				case 4:
					System.out.println(worker.divide(int1, int2));
					break;
			}
				break;
			default:
				System.out.println("Invalid entry");
		}
		
		reader.close();
		
	}
	
	
	// ALL OF THE FUNCTIONS
	
	// overloading addition functions
	public int add(int num1, int num2) {
		return num1 + num2;
	}
	
	public double add(double num1, double num2) {
		return num1 + num2;
	}
	
	public float add(float num1, float num2) {
		return num1 + num2;
	}
	
	// overloading subtractions functions
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
	
	public double subtract(double num1, double num2) {
		return num1 - num2;
	}
	
	public float subtract(float num1, float num2) {
		return num1 - num2;
	}
	
	// overloading multiplication functions
	public int multiply(int num1, int num2) {
		return num1 * num2;
	}
	
	public double multiply(double num1, double num2) {
		return num1 * num2;
	}
	
	public float multiply(float num1, float num2) {
		return num1 * num2;
	}
	
	// overloading division functions
	public int divide(int num1, int num2) {
		return num1 / num2;
	}
	
	public double divide(double num1, double num2) {
		return num1 / num2;
	}
	
	public float divide(float num1, float num2) {
		return num1 / num2;
	}
	
	
	
}
