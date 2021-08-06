package finalProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gridGUI {

	// Class varibles
	private JButton[][] grid;
	private JFrame view;
	private JPanel buttonPanel;
	
	// Constructor, takes a board/grid as an input and creates a JPanel of JButtons in a Grid, calls appropraite funcitons to create and get the GUI going
	public gridGUI(int[][] gridInput) {
		grid = new JButton[gridInput.length][gridInput[0].length];
		constructPanel(gridInput);
		view = new JFrame("Test");
		view.add(new JLabel("hi"));
		view.setPreferredSize(new Dimension(400, 400));
		constructGUI();
	}
	
	// Creates a JPanel and puts all the JButtons in the JButton grid on it. Adds the JPanel to the JFrame and makes it visible
	private void constructGUI() {
		
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(grid.length, grid.length));
        
        for(int i = 0; i < grid.length; i++) {
			for(int l = 0; l < grid[0].length; l++) {
				buttonPanel.add(grid[i][l]);
			}
		}
        view.add(buttonPanel);
        view.revalidate();
        view.repaint();
        view.pack();
        view.setVisible(true);
       
	}
	
	// A simple function that takes a grid of numbers, constructs new JButtons and puts them on the JPanel and puts the panel on the JFrame by calling the appropriate functions
	public void updateFrame(int[][] gridInput) {
		constructPanel(gridInput);
		view.remove(buttonPanel);
		constructGUI();
	}
	
	//takes a gridInput. This function creates all the JButton and adds appropraite action listeners (i.e. the battleship tictactoe button gets an action listener to run battleship
	public void constructPanel(int[][] gridInput) {
		try {
		boolean isTicTacToe = true;
		for(int i = 0; i < gridInput.length; i++) {
			for(int l = 0; l < gridInput[0].length; l++) {
				if(gridInput[i][l] == 7) isTicTacToe = false;
			}
		}
		
		for(int i = 0; i < gridInput.length; i++) {
			for(int l = 0; l < gridInput[0].length; l++) {

				JButton button = new JButton();
				button.setName(i + " " + l);
				if(gridInput[i][l] != 0) {
					button.setText(Integer.toString(gridInput[i][l]));
				}
				button.setBackground(new Color(255, (int) (240 - (15*Math.log(gridInput[i][l] + 1))), 255));
				if(gridInput[i][l] == -69) {
					button.setBackground(Color.white);
					if((i == 0 && l == 0) || (i == 2 && l == 2)) {
						button.setText("mystery");
						button.addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisButton = (JButton) e.getSource();
								
								master.tictacGame.currentPos = Integer.parseInt(thisButton.getName().substring(0, 1))*3 + Integer.parseInt(thisButton.getName().substring(2, 3)) + 1;          
								
								double rand = Math.random();
								
								if(rand > .8) {
									runBattleship();
								} else if (rand > .5) {
									start15();
								} else if(rand > .3) {
									connectFour();
								} else {
									runTF8();
								}
								
								
							} 
		        		});
					} else if((i == 0 && l == 1) || (i == 2 && l == 1)) {
						button.setText("2048");
						button.setName(i + " " + l);
						button.addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisButton = (JButton) e.getSource();
								
								master.tictacGame.currentPos = Integer.parseInt(thisButton.getName().substring(0, 1))*3 + Integer.parseInt(thisButton.getName().substring(2, 3)) + 1;          
								
								runTF8();
							} 
		        		});
					} else if((i == 0 && l == 2) || (i == 2 && l == 0)) {
						button.setText("15");
						button.setName(i + " " + l);
						button.addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisButton = (JButton) e.getSource();
								
								master.tictacGame.currentPos = Integer.parseInt(thisButton.getName().substring(0, 1))*3 + Integer.parseInt(thisButton.getName().substring(2, 3)) + 1;          
								
								start15();
							} 
		        		});
					} else if((i == 1 && l == 0) || (i == 1 && l == 2)) {
						button.setText("Connect 4");
						button.setName(i + " " + l);
						button.addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisButton = (JButton) e.getSource();
								
								master.tictacGame.currentPos = Integer.parseInt(thisButton.getName().substring(0, 1))*3 + Integer.parseInt(thisButton.getName().substring(2, 3)) + 1;          
								
								connectFour();
							} 
		        		});
					} else if(i == 1 && l == 1) {
						button.setText("Battleship");
						button.addActionListener(new ActionListener() { 
							@Override
							public void actionPerformed(ActionEvent e) {
								JButton thisButton = (JButton) e.getSource();
								
								master.tictacGame.currentPos = Integer.parseInt(thisButton.getName().substring(0, 1))*3 + Integer.parseInt(thisButton.getName().substring(2, 3)) + 1;          
								
								runBattleship();
							} 
		        		});
					}
					
					
				}
				
				if(isTicTacToe) {
					if(gridInput[i][l] == 1 && gridInput.length == 3) {
						button.setText("o");
					} else if(gridInput[i][l] == 2 && gridInput.length == 3) {
						button.setText("x");
					} 
				}
				

				grid[i][l] = button;
			}
			
		}
		} catch (Exception e) {
		}
	}
	
	// Returns the grid
	public JButton[][] getGrid() {
		return grid;
	}
	
	// Makes te frame invisible
	public void removeFrame() {
		view.setVisible(false);
	}
	
	// Makes the frame visible
	public void showFrame() {
		view.setVisible(true);
	}
	
	// Closes the frame
	public void terminateFrame() {
		view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
	}
	
	
	// Starts the 15 game
	public void start15() {
		fifteen game = new fifteen();
		gridGUI gui = new gridGUI(game.getBoard());
		master.tictacGame.hideGame(this);
		game.renderFrame(game, gui);
	}
	
	
	// Starts connectFour
	public void connectFour() {
		connectfour game = new connectfour();
		gridGUI gui2 = new gridGUI(game.getBoard());
		master.tictacGame.hideGame(this);
		game.renderFrame(game, gui2);
	}
	
	// Starts twentyfortyeight
	public void runTF8() {
		master.tictacGame.hideGame(this);
		twentyfortyeight game = new twentyfortyeight();
		gridGUI gui2 = new gridGUI(game.getBoard());
		game.renderFrame(game, gui2);
	}
	
	// Starts battleship
	public void runBattleship() {
		master.tictacGame.hideGame(this);
		battleshipMaster board = new battleshipMaster();
		board.setUpGame();
	}
	
}
