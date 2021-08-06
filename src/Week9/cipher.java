package Week9;

import java.util.Scanner;

public class cipher {

	public static void main(String args[]) {
		
		// Declare variables
		String dummy = "abcdefghijklmnopqrstuvwxyz", input;
		Scanner reader = new Scanner(System.in);
		char[] indexes = dummy.toCharArray(), inputArr;
		
		// Ask the user what they want
		int charNum = 0, optionChosen;
		System.out.println("Encrypt (0) or Decrypt (1)?");
		optionChosen = reader.nextInt();
		System.out.println("Enter your message");
		String a = reader.next();
		input = a + reader.nextLine();
		
		// Close the reader
		reader.close();
		

		inputArr = input.toCharArray();
		// Loop that iterates over every letter in the input
		for(int i = 0; i < inputArr.length; i++) {
			// If there is a space, put a space in
			if(inputArr[i] == ' ') {
				System.out.print(" ");
			} else {
				// Compare the array of letters to the current processed char to see the value, a -> 0, b -> 1, etc, etc...
				for(int j = 0; j < 26; j++) {
					if(inputArr[i] == indexes[j]) charNum = j;
				}
				
				// The actual encrpt/decrypt
				if(optionChosen == 1) {
					if(charNum - 5 < 0) {
						System.out.print(indexes[26 - Math.abs(charNum - 5)]);
					} else {
						System.out.print(indexes[charNum - 5]);
					}
				} else {
					if(charNum + 5 > 25) {
						System.out.print(indexes[(charNum + 5) - 26]);
					} else {
						System.out.print(indexes[charNum + 5]);
					}
				}
		}
		
		}
	}
}


