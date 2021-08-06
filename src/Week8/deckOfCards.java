package Week8;

import java.util.ArrayList;

/*

Neev Mangal
3/26/21 
Tika Kude
B3 AP Computer Science A

This program is a functioning deck of cards with a variety of features
*/

public class deckOfCards {

	// Obviously a class of deck of cards must have an arrayList deck
	ArrayList<card> deck = new ArrayList<card>();
	
	
	// This class sets up the deck by putting card (another class i created) objects into the array list
	public void setupDeck() {
		String[] suits = {"Diamonds", "Spades", "Hearts", "Clubs"};

		// Nested for loops to add all 13 cards from each suit
		for(int u = 0; u < suits.length; u++) {
			for(int i = 0; i < 13; i++) {
				card tempCard = new card();
				tempCard.cardInit((i + 1), suits[u]);
				deck.add(tempCard);
			}
		}
		
		// A little bit of feedback
		System.out.println(deck.size() + " cards created!");
		
	}
	
	// This function is here so the 1, 11, 12, and 13 cards can function as Ace, Jack, Queen, and King for output
	
	public String fancyCard(int input) {
		if(input == 1) return "Ace";
		else if(input == 11) return "Jack";
		else if(input == 12) return "Queen";
		else if(input == 13) return "King";
		else return Integer.toString(input);
	}
	
	// Simple function
	public int numberOfCardsLeft() {
		return deck.size();
	}
	
	//NOTE: For shuffle I modified the canvas code to work with any size of deck
	
	public void shuffle() {
		for(int i=0; i< (int) (Math.floor(Math.random() * deck.size()))/2; i++) {
			//choose 2 random elements to swap
			int swapIndex1=(int)Math.floor(Math.random()*deck.size());
			if(swapIndex1==deck.size()) swapIndex1--;
			int swapIndex2=(int)Math.floor(Math.random()*deck.size());
			if(swapIndex2==deck.size()) swapIndex2--;
			//swap them
			card tmp= deck.get(swapIndex1);
			deck.set(swapIndex1, deck.get(swapIndex2));
			deck.set(swapIndex2, tmp);
		}
		System.out.println("Cards shuffled");
	}
	
	// Deals a card
	public void dealCard() {
		// Pick a random (valid) index
		int randIndex = (int)Math.floor(Math.random()*deck.size());
		if(randIndex== deck.size()) randIndex--;
		// Inform the user what was dealt
		System.out.println("Dealt the " + fancyCard(deck.get(randIndex).number) + " of " + deck.get(randIndex).suit);
		// Remove the card from the deck
		deck.remove(randIndex);
	}
	
	// Deals the top card
	public void dealTopCard() {
		// Pick the topmost index
		int randIndex = deck.size() - 1;
		// Let the user know what was dealt
		System.out.println("Dealt the " + fancyCard(deck.get(randIndex).number) + " of " + deck.get(randIndex).suit);
		// Remove the card from the deck
		deck.remove(randIndex);
	}
	
	public static void main(String args[]) {
		// Setup new deck
		deckOfCards deckOCards = new deckOfCards();
		deckOCards.setupDeck();
		
		// Shuffle it
		deckOCards.shuffle();
		
		// Deal it
		
		while(deckOCards.numberOfCardsLeft() > 0) {
			deckOCards.dealCard();
		}
		
//		NOTE: If you want to deal the top card simply do
//		
//		while(deckOCards.numberOfCardsLeft() > 0) {
//			deckOCards.dealTopCard();
//		}
		
		
	}
	
	
	
}
