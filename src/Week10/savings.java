package Week10;

public class savings extends account {
	
	public savings() {
		balance = 100;
	}
	
	// Withdraw a specific amount, unless the user has less then is being requested to withdraw
	public void withdraw(int amount) {
		if(amount > balance) System.out.println("You don't have that much!");
		else balance = balance - amount;
		printBal();
	}
		
}
