package Week5;

import java.util.Scanner;

/*
Neev Mangal
3/4/21 
Tika Kude
B3 AP Computer Science A

 This program uses recursive methods to reverse a number
*/ 


public class reversenumber {
	
	public String reverse(String a) {
		if(a.length() == 1) {
			return a;
		} else if(a.length() == 2) {
			return "" + a.toCharArray()[1] + a.toCharArray()[0];
		} else {
			return a.toCharArray()[a.length() - 1] + reverse(a.substring(1, a.length()-1)) + a.toCharArray()[0];
		}
	}

	public static void main(String[] args) {
		
		// Initialize variables
		String input;
		Scanner reader = new Scanner(System.in);
		reversenumber worker = new reversenumber();
		
		// Get input
		System.out.println("Enter a number to reverse");
		input = Integer.toString(reader.nextInt());
		reader.close();
		
		// calculate and output
		System.out.println(worker.reverse(input)); 
		

	}

	

}
