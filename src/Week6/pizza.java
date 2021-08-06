package Week6;

import java.util.Scanner;

/*

Neev Mangal
3/8/21 
Tika Kude
B3 AP Computer Science A

This program has an pizza class with a number of functions
*/

public class pizza {
	
	// Some private integers to the pizza itself
	private int pizzaSize, toppingsCount, drinksCount, drinkSize, cost, preferredMethod;
	
	// Function that takes in all user choices and outputs their order confirmation
	public void makeOrder(int psize, int tcount, int dcount, int dsize, int deliveryMethod) {
		pizzaSize = psize;
		toppingsCount = tcount;
		drinksCount = dcount;
		drinkSize = dsize;
		preferredMethod = deliveryMethod;
		
		String outputString = "Your " + ascertainSize(psize) + " pizza with " + tcount + " toppings has been ordered. Additionally, your " + drinksCount +  " " + ascertainSize(dsize) + " drinks have been ordered, all for ";
		switch(deliveryMethod) {
			case 1:
				outputString += "Dine-in";
				break;
			case 2:
				outputString += "Pick-up";
				break;
			case 3:
				outputString += "Delivery";
				break;
			default:
				outputString += "Unknown";
		}
		System.out.println(outputString);
		
		System.out.println("The total cost is " + ((pizzaSize*2) + (tcount*.25) + (dcount * dsize)));
	}

	// For drinks and pizza, takes in the integer that the user put in an outputs the size 
	private String ascertainSize(int input) {
		switch(input) {
		case 1:
			return "small";
		case 2:
			return "medium";
		case 3:
			return "large";
		default:
			return "unknown";
	}
	}
	public static void main(String[] args) {
		
		// Initialize Variables
		Scanner reader = new Scanner(System.in);
		int size, countT, countD, sizeD, option;
		
		// Get user input
		
		System.out.println("What size of pizza would you like (1 - Small, 2 - Medium, 3 - Large)");
		size = reader.nextInt();
		System.out.println("How many toppings would you like?");
		countT = reader.nextInt();
		System.out.println("How many drinks would you like?");
		countD = reader.nextInt();
		System.out.println("What size would you like them to be? (1 - Small, 2 - Medium, 3 - Large)");
		sizeD = reader.nextInt();
		System.out.println("What method would you to get your pizza? (1 - Dine In, 2 - Pick Up, 3 - Delivery)");
		option = reader.nextInt();
		reader.close();
		
		// Make the order
		pizza tempPizza = new pizza();
		tempPizza.makeOrder(size, countT, countD, sizeD, option);
		
	}

}
