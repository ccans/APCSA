package Quizzes;

import java.util.Scanner;

public class Quiz9_1 {
	
	
	public static void main(String args[]) {
		// Declare variables
		String input, temp;
		boolean hasThe = false;
		System.out.println("Enter your sentence");
		Scanner reader = new Scanner(System.in);
		input  = reader.nextLine();
		String inputArr[] = input.split(" ");
		
		for(int i = 0; i < inputArr.length; i++) {
			temp = inputArr[i];
			if(temp.equals("the"))hasThe = true;

		}
		reader.close();
		
		if(hasThe) {
			System.out.println("Yes, the word the is in the sentence");
		} else {
			System.out.println("No, the word the is not in the sentence");
		}
		
		System.out.println("The length is " + input.length());
		
		System.out.println(input.replaceAll("e","a").toUpperCase());
	}
	
	
	
	
	
	
}
