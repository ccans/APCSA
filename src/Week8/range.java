package Week8;

import java.util.ArrayList;
import java.util.Scanner;

/*

Neev Mangal
3/22/21 
Tika Kude
B3 AP Computer Science A

This program takes in a variable amount of nubers and outputs how many are in certain ranges
*/

public class range {
	public static void main(String args[]) {
		
		// There is a way to do this program without arraylists and just having an array of length 10 that counts each range
		// And increments every time a number in that range pops up. It's also more efficient, but here is the way to do it using 
		// ArrayList
		
		// Declare Variables
		int rep, temp;
		ArrayList<Integer> input = new ArrayList<Integer>();
		int[] ranges = new int[10];
		Scanner reader = new Scanner(System.in);
		
		// Get user input
		boolean done = false;
		
		while(!done) {
			System.out.println("Enter a number (-1 to end)");
			temp = reader.nextInt();
			if(temp > 100 || temp < 0) {
				if(temp == -1) {
					done = true;
				} else {
					System.out.println("That is not a valid nuber");
				}
			} else {
				input.add(temp);
			}
		}
		reader.close();
		
		// Calculate how many are in what ranges
		for(int j = 0; j < input.size(); j++) {
			ranges[(int) (Math.floor(input.get(j) - 1) / 10)]++;
		}
		
		// Output
		for(int a = 0; a < 10; a++) {
			if(a == 0) {
				System.out.print((a*10 + 1) + " to " + (a+1)*10+ "   | ");

			} else if(a == 9) {
				System.out.print((a*10 + 1) + " to " + (a+1)*10+ " | ");

			} else {
				System.out.print((a*10 + 1) + " to " + (a+1)*10+ "  | ");

			}
			
			for(int k = 0; k < ranges[a]; k++) {
				System.out.print("*");
			}
			
			System.out.println(" ");
		}
		
	}
}
