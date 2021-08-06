package Week6;

/*

Neev Mangal
3/11/21 
Tika Kude
B3 AP Computer Science A

This program generates 100 random numbers. Outputs them forwards, backwards, and 
*/

public class random {
	public static void main(String args[]) {
		// Create the list of randomly generated numbers
		int[] numbers = new int[100];
		int[] occurences = new int[100];
		
		for(int i = 0; i < 100; i++) {
			numbers[i] =  (int) Math.floor(Math.random()*100);
			occurences[numbers[i]]++;
		}
		
		// Print the list forward and backward
		System.out.println("List of numbers generated");
		for(int j = 0; j < 100; j++) System.out.print(numbers[j] + ", ");
		System.out.println();
		System.out.println("Backwards list of numbers generated");
		for(int k = 99; k >= 0; k--) System.out.print(numbers[k] + ", ");
		System.out.println();
		
		// Print out how many times each number occurred
		
		for(int l = 0; l < 100; l++) {
			System.out.println("The number " + (l+1) + " occurred " + occurences[l] + " times");
		}
		
	
		
		
	}
}
