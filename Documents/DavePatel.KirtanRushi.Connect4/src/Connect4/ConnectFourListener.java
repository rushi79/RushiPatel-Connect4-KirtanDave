package Connect4;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

public class ConnectFourListener implements MouseListener {
	AI gameAI;
	GUI gui;
	ConnectFour game;
	private int turnCount = 0;
	private String mode;
	public static String[] modes = { "Two Players", "Single Player" };
	private static boolean singlePlayer;
	private int move;

	public ConnectFourListener(ConnectFour game, GUI gui, String mode) {
		this.game = game;
		this.gui = gui;
		this.mode = mode;
		gui.MouseListener(this);
	}

	public void mouseClicked(MouseEvent event) {
		//Multiplayer
		Random rand = new Random();
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
		//Single Player
		if (mode == modes[0]) {
			singlePlayer = false;
		} else {
			singlePlayer = true;
			gameAI = new AI();
		}
		int rowComp;
		int colComp;
		if (mode == modes[1]) {
			gameAI.ChooseMove();
			colComp = gameAI.MakeMove();
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

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}