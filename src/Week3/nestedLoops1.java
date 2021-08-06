package Week3;

import java.util.Scanner;

/*
Neev Mangal
2/17/21 
Tika Kude
B3 AP Computer Science A

 This program uses nested loops to generate a pattern taking in an input n
 
 *(n-2 #'s)*
 (repeat n times)
 
*/ 


public class nestedLoops1 {

	public static void main(String[] args) {
		
		// Declare variables and scanner
		int input;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter a number to generate a pattern.");
		input = reader.nextInt();
		reader.close();
		
		// Outside  loop
		for(int i =0; i < input; i++) {
			// Inside loop
			for(int j = 0; j < input-2; j++) {
				if(j == 0)System.out.print("*");
				System.out.print('#');
			}
			System.out.println("*");	
		}
		
	}

}
