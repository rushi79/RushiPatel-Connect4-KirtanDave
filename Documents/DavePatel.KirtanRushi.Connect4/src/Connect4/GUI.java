package Connect4;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.util.Random;

public class GUI {
	private JFrame frame;
	private JLabel[][] board;
	private static int thisPlayer;
	public static String[] modes = { "Two Players", "Single Player" };
	public static String mode;
	private static boolean singlePlayer;

	public static void main(String[] args) {
		mode = (String) JOptionPane.showInputDialog(null, "Select Game Mode", "Game Mode", JOptionPane.PLAIN_MESSAGE,
				null, modes, "--------");

		if (mode == null) {
			System.exit(1);
		} else if (mode == modes[0]) {
			singlePlayer = false;
		} else {
			singlePlayer = true;
		}
		ConnectFour logic = new ConnectFour();
		GUI gui = new GUI();
		ConnectFourListener listener = new ConnectFourListener(logic, gui, mode);
	}

	public GUI() {
		onBoard();
	}

	public void onBoard() {

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

	public void MouseListener(ConnectFourListener listener) {
		for (int ROW = 0; ROW < 6; ROW++) {
			for (int COL = 0; COL < 7; COL++) {
				board[COL][ROW].addMouseListener(listener);
			}
		}
	}

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

	public void updateColour(int COL, int ROW) {
		if (thisPlayer == 1) {
			board[COL][ROW].setOpaque(true);
			board[COL][ROW].setBackground(Color.red);

		} else {
			board[COL][ROW].setOpaque(true);
			board[COL][ROW].setBackground(Color.yellow);
		}
		thisPlayer = (thisPlayer % 2) + 1;

	}
}
