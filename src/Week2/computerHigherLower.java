package Week2;

/*
Neev Mangal
2/10/21 
Tika Kude
B3 AP Computer Science A

This program selects a random number and then guesses a number, telling itself if it is too high or too low and algorithmically guessing again. The program stops  when the program has guessed the correct number, and prints out 
it's guesses as it goes. 
*/ 


public class computerHigherLower {
	public static void main(String[] args) {
//		This program selects a random number and then guesses a number, telling itself if it is too high or too low and algorithmically guessing again. The program stops  when the program has guessed the correct number, and prints out 
//		it's guesses as it goes. 	
		
	// Declare variables
		int guess, number, currentBound;
		Boolean correctGuess;
		
		// Initiate Variables
		number = (int) Math.floor(Math.random()*100);
		correctGuess = false;
		System.out.println("Guess a number between 0-100!");
		currentBound = 25;
		guess = 50;

		do {
			System.out.println("The computer guesses " + guess);
			
			if(guess < number) {
				System.out.println("too low!");
				guess += currentBound;
			} else if (guess > number) {
				System.out.println("too high!");
				guess -= currentBound;
			} else {
				correctGuess = true;
			}
			
			currentBound = (int) Math.ceil(currentBound/2);
			if(currentBound <= 0) {
				currentBound = 1;
			}

			// Ask again
			if(!correctGuess) {
			System.out.println("Guess again!");
			}
		} while(!correctGuess);
		
		
		System.out.println("Good Job, the number was " + number);
		
}
}
