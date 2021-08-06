package Quizzes;

import java.util.Scanner;

public class Quiz5_1 {

	
	public static void main(String args[]) {
		
		// Declare variables. While technically it would be most efficient to use 3 arrays in this specific problem, 1 array works just as well
		Scanner reader = new Scanner(System.in);
		int[] inputArr = new int[10];
		
		// Get User Input
		for(int i = 0; i < 10; i++) {
			System.out.println("Enter a number");
			inputArr[i] = reader.nextInt();
		}
		reader.close();
		
		// Output all the numbers
		System.out.println("The numbers you inputted");
		for(int k = 0; k < 10; k++) {
			System.out.print(inputArr[k] + " ");
		}

		System.out.println();
		System.out.println("Numbers greater the 20: ");
		// Print all the numbers > 20
		for(int j = 0; j < 10; j++) {
			if(inputArr[j] > 20) System.out.print(inputArr[j] + " ");
		}
		
		System.out.println();
		System.out.println("Numbers less then 10: ");
		// Print all the numbers < 10
		for(int h = 0; h < 10; h++) {
			if(inputArr[h]  < 10) System.out.print(inputArr[h] + " ");
		}
		
		
	}
}
