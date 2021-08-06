package finalProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TicTacToe {
	
	// Class variables
	private int[][]  board;
	private int turn;
	public gridGUI tictacGui;
	public int currentPos;
	private int[] scores = new int[2];
	
	// Constructor, sets up the board  
	public TicTacToe() {
		board = new int[3][3];
		turn = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = -69;
			}
} 
	}
	
	// Returns the board
	public int[][] getBoard() {
		return board;
	}
	
	//identify when someone wins
	public int checkWinner()
	{
		for (int a = 0; a < 8; a++) {
			int line = 0;

			//switch statements are all the possible ways to win
			switch (a) {
			case 0:
				line = board[0][0] + board[0][1] + board[0][2];
				break;
			case 1:
				line = board[1][0] + board[1][1] + board[1][2];
				break;
			case 2:
				line = board[2][0] + board[2][1] + board[2][2];
				break;
			case 3:
				line = board[0][0] + board[1][0] + board[2][0];
				break;
			case 4:
				line = board[0][1] + board[1][1] + board[2][1];
				break;
			case 5:
				line = board[0][2] + board[1][2] + board[2][2];
				break;
			case 6:
				line = board[0][0] + board[1][1] + board[2][2];
				break;
			case 7:
				line = board[0][2] + board[1][1] + board[2][0];
				break;
			}

			if (line == 3) {
				return 2;
			} else if (line == 6) {
				return 1;
			}
		}
		return 0;
	}
	

	// Places a token at the given location 
	public void placeToken(int loc) {
		if(board[(loc - 1)/3][((loc - 1)%3)] != -69) {
			
		} else if(turn == 1) {
			board[(loc - 1)/3][((loc - 1)%3)] = 1;
			turn = 2;
		} else {
			board[(loc - 1)/3][((loc - 1)%3)] = 2;
			turn = 1;
		}
	}
	
	// Hides the tictactoe GUI
	public void hideGame(gridGUI gui) {
		gui.removeFrame();
	}
	// Hides the tictactoe GUI
	public void showGame(gridGUI gui) {
		gui.showFrame();
	}
	
	// A recursive function that assigns an action listener to every button on the GUI
	// If a (valid) button is pressed, it makes a move and calls itself to re-assign action listeners to every button
	// Checks if the game is won after every move and takes appropriate action
	public void renderFrame(TicTacToe game, gridGUI gui) {
		int l = 1;
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				gui.getGrid()[i][k].setName(Integer.toString(l));
				l+=1;
				try {					
					gui.getGrid()[i][k].addActionListener(new ActionListener() { 
						@Override
						public void actionPerformed(ActionEvent e) {
//							JButton button = (JButton) e.getSource();
//							game.placeToken(Integer.parseInt(button.getName()));
							if(game.checkWinner() != 0) {
								System.out.println(game.checkWinner() + " won");
								gui.updateFrame(game.getBoard());
								game.renderFrame(game, gui);
							} else {
								gui.updateFrame(game.getBoard());
								game.renderFrame(game, gui);
							}
						} 
	        		});
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}
	}
	
	// A function that reports a score and, if two scores are reported, placs the appropriate token at the appropriate spot
	public void reportScore(int a) {
		if(scores[0] != 0) {
			if(a > scores[0]) {
				turn = 0;
				placeToken(currentPos);
				tictacGui.updateFrame(board);
			} else {
				turn = 1;
				placeToken(currentPos);
				tictacGui.updateFrame(board);
			}
			scores[0] = 0;
			
			if(checkWinner() != 0) {
				System.out.println("Congratulations! Player " + checkWinner() + " won!");
			}
		} else {
			scores[0] = a;
		}
	}
	
	// returns true or false as to whether player 2 needs to play
	public boolean playAgain() {
		if(scores[0] == 0) {
			return false;
		}
		return true;
	}
	
	
}


