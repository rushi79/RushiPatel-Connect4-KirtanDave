package Connect4;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Kirtan/Rushi
 *
 */
public class ConnectFourListener implements MouseListener {
	AI gameAI;
	GUI gui;
	ConnectFour game;
	private int turnCount = 0;
	private String mode;
	public static String[] modes = { "Two Players", "Single Player" };
	@SuppressWarnings("unused")
	private static boolean singlePlayer;

	/**
	 * Create objects and initialize variables
	 * 
	 * @param game
	 * @param gui
	 * @param mode
	 */
	public ConnectFourListener(ConnectFour game, GUI gui, String mode) {
		this.game = game;
		this.gui = gui;
		this.mode = mode;
		gui.MouseListener(this);
	}

	/**
	 * According to the mode of the current state(single player or multiplayer), it will display 
	 * a interface according to the players choice of mode.
	 * Implement Draw/Win/loss
	 */
	public void mouseClicked(MouseEvent event) {
		// Multiplayer
		JLabel label = (JLabel) event.getComponent();
		int COL = gui.columnSpace(label);
		int ROW = game.drop(COL);
		if (ROW != -1) {
			gui.updateColour(COL, ROW);
			turnCount = turnCount + 1;
		} else {
			JOptionPane.showMessageDialog(null, "Column is FULL!");

		}
		if (game.hasWon() == true) {
			game.printMessage();
		}

		// Single Player
		if (mode == modes[0]) {
			singlePlayer = false;
		} else {
			singlePlayer = true;
			gameAI = new AI();
		}
		int rowComp;
		int colComp;
		if (mode == modes[1]) {
			gameAI.makeMove();
			colComp = gameAI.chooseMove();
			rowComp = game.drop(colComp);
			if (ROW != -1) {
				gui.updateColour(colComp, rowComp);
				turnCount = turnCount + 1;
			} else if (game.hasWon() == true) {
				game.printMessage();

			} else {
				JOptionPane.showMessageDialog(null, "Column is FULL!");

			}
		}
		//Draw Game
		if (turnCount == 42) {
			JOptionPane.showMessageDialog(null, "Draw Game");
			int reply2 = JOptionPane.showConfirmDialog(null, "New Game?", "New Game", JOptionPane.YES_NO_OPTION);
			if (reply2 == JOptionPane.NO_OPTION) {
				System.exit(0);
			} else if (reply2 == JOptionPane.YES_OPTION) {
				GUI.main(null);
			}
		}

	}

	/**
	 * Checks if mouse has entered an action
	 */
	public void mouseEntered(MouseEvent arg0) {

	}

	/**
	 * Checks if mouse has stopped entering an action
	 */
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Checks when mouse clicked
	 */
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * Checks when mouse click has been let go
	 */
	public void mouseReleased(MouseEvent e) {

	}

}
