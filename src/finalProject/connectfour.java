package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;

public class connectfour {
	
	// 2D array and variables
	private int[][] board = new int[6][7];
	private int currentPlayer = 1;

	public connectfour() {
		
	}
	
	// Just checks that the column is not full. If not, then returns true, otherwise returns false. Checks whether a drop is valid 
	public boolean canDrop(int column) {
		if(board[0][column] == 0) return true;
		return false;
	}
	
	// Takes input of a column and performs a drop -- puts a player's token at the next avaliable spot in that column
	public int drop(int column) {
		int row = 0;
		for(int i = 0; i < 6; i++) {
			if(board[i][column] == 0) {
				board[i][column] = currentPlayer;
				if(currentPlayer == 1) currentPlayer = 2;
				else if(currentPlayer == 2) currentPlayer = 1;
				row = i;
				break;
			}
		}

		return row;
	}
	
	// Takes in a column and a row and checks if the user won the game by dropping a token at that position
	// Run after every turn to check if the token dropped on the last turn generated a wincase
	// Checks horizontally, vertically, and diagonally
	public boolean didWin(int column, int row) {

		int player = currentPlayer;
		if(player == 2) {
			player = 1;
		} else {
			player = 2;
		}
		
		
		

		int iterator = 0;

		// Search left-right wincase

		for(int i = column - 1; i >= 0; i--) {
			if(board[row][i] == player) {
iterator++;
			} else {
				break;
			} 
		}

for(int i = column + 1; i < 7; i++) {
			if(board[row][i] == player) {
iterator++;
			} else {
				break;
			} 
		}

		if((iterator + 1) >= 4) return true;
		

		// Search top-bottom wincase
		iterator = 0;
for(int i = row- 1; i >= 0; i--) {
			if(board[i][column] == player) {
iterator++;
			} else {
				break;
			} 
		}

for(int i = row+ 1; i < 6; i++) {
			if(board[i][column] == player) {
iterator++;
			} else {
				break;
			} 
		}
		
if((iterator + 1) >= 4) return true;


// Search left diagonal wincase

iterator = 0;
for(int i = 1; (i + row < 6 && i + column < 7); i++) {
if(board[row + i][column + i] == player){
 iterator++;
} else {
	break;
}
}

for(int i = 1; (row - i >= 0 && column - i >= 0); i++) {
if(board[row - i][column - i] == player){
 iterator++;
} else {
	break;
}
}

if((iterator + 1) >= 4) return true;

// Search right diagonal wincase

iterator = 0;
for(int i = 1; (i + row < 6 && column - i>= 0); i++) {
if(board[row + i][column - i] == player){
 iterator++;
} else {
	break;
}
}

for(int i = 1; (row - i >= 0 && column + i < 7); i++) {
if(board[row - i][column + i] == player){
 iterator++;
} else {
	break;
}
}

if((iterator + 1) >= 4) return true;

return false;




	}
	
	// Prints the board
	public void printBoard() {
		for(int i = board.length - 1; i >= 0; i--) {
					for(int j = 0; j < board[0].length; j++) {
						System.out.print(board[i][j] + " ");
					}
					System.out.println();
		}
	}
	
	// Returns the board right-side up
	public int[][] getBoard() {
		int[][] temp = new int[6][7];
		for(int i = board.length - 1; i >= 0; i--) {
			for(int j = 0; j < board[0].length; j++) {
				temp[5 - i][j] = board[i][j];
			}
		}
		return temp;
	}
	
	// A recursive GUI function that is run whenever a button is pressed. It uupdates the board and GUi accordingly, and also 
	// reports who won and terminates the JFrame when a user wins
	public void renderFrame(connectfour game, gridGUI gui) {
		for(int i = 0; i < 6; i++) {
			for(int k = 0; k < 7; k++) {
					gui.getGrid()[i][k].setName(i + " " + k);
					gui.getGrid()[i][k].addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton button = (JButton) e.getSource();
							if(button.getName() != "") {
								game.drop(Integer.parseInt(button.getName().substring(2, 3)));
								gui.updateFrame(game.getBoard());
								game.renderFrame(game, gui);
								if(didWin(Integer.parseInt(button.getName().substring(2, 3)), Integer.parseInt(button.getName().substring(0, 1)))) {
									
									if(currentPlayer == 1) {
										master.tictacGame.reportScore(2);
										master.tictacGame.reportScore(1);
									} else {
										master.tictacGame.reportScore(1);
										master.tictacGame.reportScore(2);
									}
									gui.removeFrame();
									master.tictacGame.tictacGui.showFrame();
								} 	
							}
						} 
	        		});
				

			}
		}
	}


	
	
}



