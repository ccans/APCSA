package finalProject;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class fifteen {
	
	// Class variables, board, blankspace, and score
	private int[][] board;
	private int[] blankSpace = new int[2];
	private int score = 0;
	
	
	// Constructor method
	public fifteen() {
		board = new int[3][3];
		createBoard();
	}
	
	// Returns the board
	public int[][] getBoard() {
		return board;
	}
	
	// Creates a random 3x3 fifteen board. Checks for validity
	public void createBoard() {
	int[] list = new int[9];
	boolean checkValid = false;;
		ArrayList<Integer> indices  = new ArrayList<Integer>();

		do {
			
		
			
			for(int y = 0; y < (board.length*board.length); y++) {
				indices.add(y);
				board[y/3][y%3] = 0;
			}
		for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {

				int k = (int) (Math.random()*indices.size());
				board[i][j] = indices.get(k);
				if(indices.get(k) == 0) {
					blankSpace[0] = i;
					blankSpace[1] = j;
				}
				list[3*i + j] = indices.get(k);
				indices.remove(k);
				
			}

		}
		checkValid = isValidBoard(getInversions(list));
	} while (checkValid == false);
		
		int[] a = new int[2];
		int[] b = new int[2];
		
		for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 6) {
					a[0] = i; 
					a[1] = j;
				}
			}
		}
		
		for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] == 8) {
					b[0] = i; 
					b[1] = j;
				}
			}
		}
		
		board[b[0]][b[1]] = 6;
		board[a[0]][a[1]] = 8;
		
		
	}



	    
	// A math function that takes in the board as a 1d array and returns the number of "inversions". Check documentation for further reading
	public int getInversions(int[] arr) {
		int inv_count = 0;
		int N = 3;
	    for (int i = 0; i < N * N; i++)
	    {
	        for (int j = i + 1; j < N * N; j++)
	        {

	            if (arr[i] > arr[j] && arr[i] != 0 && arr[j] != 0)
	                inv_count++;
	        }
	    }
	    return inv_count;
	}
// Takes in a number of inversions and checks if it's valid.
public boolean isValidBoard(int inv) {
	if (inv%2 == 1) return true;
	else return false;
}

	// Checks if the move the user is trying to make is valid (next to the empty square)
	public boolean isValidMove(int i) {
		if(Math.abs(getCoords(i)[0] - blankSpace[0]) + Math.abs(getCoords(i)[1] - blankSpace[1]) == 1) return true;
		return false;
		}
	
	// Prints the board (for testing)
	public void printBoard() {
for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
}
System.out.println();

		}

	}

	// Takes in a number and returns its coordinates on the board
	public int[] getCoords(int num) {
		for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				int[] coord = {i,j};
				if(board[i][j] == num) return coord;
			}
		}
		return null;
	}
	
	// Takes in a number , swaps the blank space with the valid move that the user selects
	public void makeMove(int i) {
		int[] ph = getCoords(i);
		board[blankSpace[0]][blankSpace[1]] = i;
		board[ph[0]][ph[1]] = 0;
		blankSpace[0] = ph[0];
		blankSpace[1] = ph[1];
	}

		// Checks if the board is in the "solved" state
	public boolean wonGame() {
		int curNum = 1;
	for(int i =0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] != curNum && curNum != 9) {
					return false;
				}
				curNum++;
			}
		}
		return true;
	}




	
	// A recursive function that assigns an action listener to every button on the GUI
	// If a (valid) button is pressed, it makes a move and calls itself to re-assign action listeners to every button
	// Checks if the game is won after every move and takes appropriate action
	public void renderFrame(fifteen game, gridGUI gui) {
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				if(gui.getGrid()[i][k].getText() != "") {
				if(game.isValidMove(Integer.parseInt(gui.getGrid()[i][k].getText()))) {
					gui.getGrid()[i][k].addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e) {
							JButton button = (JButton) e.getSource();
							score++;
								game.makeMove(Integer.parseInt(button.getText()));
								gui.updateFrame(game.getBoard());
								game.renderFrame(game, gui);
								if(wonGame()) {
									System.out.println("Your score is " + score) ;
									master.tictacGame.reportScore(score);
									if(master.tictacGame.playAgain()) {
										score = 0;
										createBoard();
										gui.updateFrame(game.getBoard());
										game.renderFrame(game, gui);
									} else {
										master.tictacGame.tictacGui.showFrame();
										gui.removeFrame();
									}
								} 
						} 
	        		});
				}
			}

			}
		}
	}


}







