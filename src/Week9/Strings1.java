package Week9;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Strings1 {
	
	public static void main(String args[]) throws IOException {
		
		// Declare variables
		String input;
		Scanner reader = new Scanner(new File("input.txt"));
		
		// loop through 10 words and bisect them
		for(int i = 0;i < 10; i++) {
			input = reader.next().toUpperCase();
			
			System.out.println(input.substring(0, (int) Math.ceil(input.length()/2) + (input.length()%2 == 1 ? 1 : 0)) + " " + input.substring((int) Math.ceil(input.length()/2) + (input.length()%2 == 1 ? 1 : 0)));
			
		}
		
	}
	
	
}
