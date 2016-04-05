package Connect4;

import javax.swing.JOptionPane;

public class ConnectFour {

	private int[][] board;
	private int thisPlayer;
	private boolean declareWinner = false;
	private static String mode;
	public static String[] modes = { "Two Players", "Single Player" };

	public ConnectFour() {
		// create the board
		board = new int[7][6];
		for (int ROW = 0; ROW < 6; ROW++) {
			for (int COL = 0; COL < 7; COL++) {
				board[COL][ROW] = 0;
			}
		}
		thisPlayer = 2;
	}

	int drop(int COL) {

		for (int ROW = 0; ROW < 6; ROW++) {
			if (ROW < 6 && board[COL][ROW] == 0) {
				board[COL][ROW] = thisPlayer;

				thisPlayer = (thisPlayer % 2) + 1;

				return ROW;
			}
		}
		// drop a color until it returns -1.
		return -1;
	}

	public boolean hasWon() {

		// check for a horizontal win " - "
		for (int ROW = 0; ROW < 6; ROW++) {
			for (int COL = 0; COL < 4; COL++) {
				if (board[COL][ROW] != 0 && board[COL][ROW] == board[COL + 1][ROW]
						&& board[COL][ROW] == board[COL + 2][ROW] && board[COL][ROW] == board[COL + 3][ROW]) {
					declareWinner = true;
				}
			}
		}

		// check for a vertical win " | "
		for (int ROW = 0; ROW < 3; ROW++) {
			for (int COL = 0; COL < 7; COL++) {
				if (board[COL][ROW] != 0 && board[COL][ROW] == board[COL][ROW + 1]
						&& board[COL][ROW] == board[COL][ROW + 2] && board[COL][ROW] == board[COL][ROW + 3]) {
					declareWinner = true;
				}
			}
		}

		// check for a diagonal win " / "
		for (int ROW = 0; ROW < 3; ROW++) {
			for (int COL = 0; COL < 4; COL++) {
				if (board[COL][ROW] != 0 && board[COL][ROW] == board[COL + 1][ROW + 1]
						&& board[COL][ROW] == board[COL + 2][ROW + 2] && board[COL][ROW] == board[COL + 3][ROW + 3]) {
					declareWinner = true;
				}
			}
		}

		// check for a diagonal win " \ "
		for (int ROW = 3; ROW < 6; ROW++) {
			for (int COL = 0; COL < 4; COL++) {
				if (board[COL][ROW] != 0 && board[COL][ROW] == board[COL + 1][ROW - 1]
						&& board[COL][ROW] == board[COL + 2][ROW - 2] && board[COL][ROW] == board[COL + 3][ROW - 3]) {
					declareWinner = true;
				}
			}
		}

		return declareWinner;
	}

	public void printMessage() {

		if (declareWinner = true) {
			JOptionPane.showMessageDialog(null, "Player " + thisPlayer + " won!!");
			int reply = JOptionPane.showConfirmDialog(null, "New Game?", "New Game", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.NO_OPTION) {
				System.exit(1);
			} else if (reply == JOptionPane.YES_OPTION) {
				GUI.main(null);

			}
		}
	}
}
