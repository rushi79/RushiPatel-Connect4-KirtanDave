package Connect4;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

/**
 * @author Kirtan/Rushi 
 * Consists of a graphical interface in which a user can play the game.
 */
public class GUI {
	private JFrame frame;
	private JLabel[][] board;
	private static int thisPlayer;
	public static String[] modes = { "Two Players", "Single Player" };
	public static String mode;

	/**
	 *Allows the user to choose a mode (Single Player or Multiplayer) 
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		mode = (String) JOptionPane.showInputDialog(null, "Select Game Mode", "Game Mode", JOptionPane.PLAIN_MESSAGE,
				null, modes, "--------");

		if (mode == null) {
			System.exit(1);
		} else if (mode == modes[0]) {
		} else {
		}
		ConnectFour logic = new ConnectFour();
		GUI gui = new GUI();
		ConnectFourListener listener = new ConnectFourListener(logic, gui, mode);
	}

	/**
	 * Sets a frame in which the game will run on.
	 * Initializes the board with a grid. 
	 */
	public GUI() {

		frame = new JFrame("Connect Four");
		JPanel panel = (JPanel) frame.getContentPane();
		panel.setLayout(new GridLayout(6, 7));
		panel.setBackground(Color.LIGHT_GRAY);
		board = new JLabel[7][6];
		for (int ROW = 5; ROW >= 0; ROW--) {
			for (int COL = 0; COL < 7; COL++) {
				board[COL][ROW] = new JLabel();
				board[COL][ROW].setHorizontalAlignment(SwingConstants.CENTER);
				board[COL][ROW].setBorder(new LineBorder(Color.BLACK));
				panel.add(board[COL][ROW]);
			}
		}
		frame.setContentPane(panel);
		frame.setSize(700, 600);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Player 1: Red,  Player 2: Yellow,  Click on any column to drop colour",
				"Instructions", JOptionPane.PLAIN_MESSAGE, null);
		thisPlayer = 1;
	}

	/**
	 * Add a mouse listener for every column on the grid
	 * @param listener
	 */
	public void MouseListener(ConnectFourListener listener) {
		for (int ROW = 0; ROW < 6; ROW++) {
			for (int COL = 0; COL < 7; COL++) {
				board[COL][ROW].addMouseListener(listener);
			}
		}
	}

	/**
	 * Check for column space, if found then it will allow the user to drop a colour.
	 * @param label
	 * @return returnColumn
	 */
	public int columnSpace(JLabel label) {
		int returnColumn = -1;
		for (int ROW = 0; ROW < 6; ROW++) {
			for (int COL = 0; COL < 7; COL++) {
				if (board[COL][ROW] == label) {
					returnColumn = COL;
				}
			}
		}
		return returnColumn;
	}

	/**
	 * updates a colour according to player.
	 * player 1 : red
	 * player 2: yellow
	 * @param COL, ROW
	 */
	public void updateColour(int COL, int ROW) {
		if (thisPlayer == 1) {
			board[COL][ROW].setOpaque(true);
			board[COL][ROW].setBackground(Color.red);

		} else if (thisPlayer == 2) {
			board[COL][ROW].setOpaque(true);
			board[COL][ROW].setBackground(Color.yellow);
		}
		thisPlayer = (thisPlayer % 2) + 1;

	}
}
