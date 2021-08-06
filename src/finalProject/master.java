package finalProject;

public class master {

	// Static instance of tictactoe
	static TicTacToe tictacGame;
	
	// Main method, start the tictactoe game with a new GUI
	public static void main(String[] args)
	{
		tictacGame = new TicTacToe();

		gridGUI gui = new gridGUI(tictacGame.getBoard());
		tictacGame.tictacGui = gui;
		gui.updateFrame(tictacGame.getBoard());

	}
	
}
