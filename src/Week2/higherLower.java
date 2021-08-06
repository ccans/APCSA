package Week2;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/10/21 
Tika Kude
B3 AP Computer Science A

This program selects a random number and then asks the user to guess the number, telling them if they are too high or too low and letting them guess again. The program stops  when the user has guessed the correct number. 
*/ 


public class higherLower {
	public static void main(String[] args) {
    // This program selects a random number and then asks the user to guess the number, telling them if they are too high or too low and letting them guess again. The program stops  when the user has guessed the correct number. 
		
	// Declare variables and Scanner
		int guess, number;
		Boolean correctGuess;
		Scanner reader = new Scanner(System.in);
		
		// Initiate Variables
		number = (int) Math.floor(Math.random()*100);
		correctGuess = false;
		System.out.println("Guess a number between 0-100!");

		while(!correctGuess) {
			// Get the user input 
			guess = reader.nextInt(); 
			if(guess < number) {
				System.out.println("too low!");
			} else if (guess > number) {
				System.out.println("too high!");
			} else {
				correctGuess = true;
			}
			// Ask again
			if(!correctGuess) {
			System.out.println("Guess again!");
			}
		}
		
		
		
		
		
		reader.close();
		System.out.println("Good Job, the number was " + number);
		
}
}
