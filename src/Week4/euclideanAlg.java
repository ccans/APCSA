package Week4;

import java.util.Scanner;


/*
Neev Mangal
2/24/21 
Tika Kude
B3 AP Computer Science A

 This program takes in 2 numbers and returns their GCF using the Euclidean Algorithim
*/ 

public class euclideanAlg {
	public static void main(String[] args) {
		// Initialize variables
		
		int num1, num2;
		Scanner reader = new Scanner(System.in);
		euclideanAlg algorithm = new euclideanAlg();
		
		// Get user input
		System.out.println("Enter two numbers to find the GCF of");
		num1 = reader.nextInt();
		num2 = reader.nextInt();
		reader.close();
		
		//run the algorithm and return the values
		System.out.println("The GCF is " + algorithm.solve(num1, num2, num1%num2));
	}

	// Method that is just the euclidean algorithm
	public int solve(int x, int y, int ram) {
		while(ram != 0) {
			x = y;
			y = ram;
			ram = x%y;
		}
		return y;
	}
	
}
