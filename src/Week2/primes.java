package Week2;

/*
Neev Mangal
2/10/21 
Tika Kude
B3 AP Computer Science A

This program efficiently prints all primes 1-100
*/ 

public class primes {
	public static void main(String[] args) {
    // This program efficiently prints all primes 1-100
		
	// Declare variables and Scanner
		Boolean isPrime;
		int numberBeingChecked;
		
		// Initiate Variables
		isPrime = true;
		numberBeingChecked = 2;
		
		// This for loop checks every number
		System.out.println(2);
		for(; numberBeingChecked <101; numberBeingChecked++) {
			// Assume every number is prime unless program proves otherwise
			isPrime = true;
			// Root out all the evens
			if(numberBeingChecked %2 == 0) {
				
			} else {
				//If it's an odd number, divide it by every odd number below it up to it's square root
				for(int i = 3; i < (int) Math.ceil(Math.sqrt(numberBeingChecked)); i= i+2) {
					// If the remainder is 0, it is not prime. Mark it as not prime and end the loop by saying setting i equal to the number being checked
					if(numberBeingChecked%i == 0) {
						isPrime = false;
						i = numberBeingChecked;
					}
				}
				if(isPrime) {
					System.out.println(numberBeingChecked);
				}
			}
		}
		
		
	}
}
