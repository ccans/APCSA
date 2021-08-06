package Midterm;

import java.util.Scanner;

/*

Neev Mangal
3/6/21 
Tika Kude
B3 AP Computer Science A

This program reads in 2 numbers and prints out all the values o 2*the smaller number that are less then the larger number

*/

public class loopy {

	public static void main(String[] args) {
		
		
		// Initialize variables
		int smaller, larger;
		Scanner reader = new Scanner(System.in);
		
		// Get user input
		System.out.println("Enter the smaller number");
		smaller = reader.nextInt();
		System.out.println("Enter the larger number");
		larger = reader.nextInt();
		reader.close();
		
		// Loop + output
		while(smaller < larger)  {
			if(smaller*2 < larger) System.out.print(smaller + ", ");
			else System.out.print(smaller);
			smaller*=2;
		}


	}

}
