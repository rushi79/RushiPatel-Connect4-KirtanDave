package Connect4;

import java.util.*;

/**
 * @author Kirtan/Rushi Player 1 game mode AI
 */
public class AI {
	private int move;

	/**
	 * Returns the move made by AI
	 * 
	 * @return move
	 */
	public int chooseMove() {
		return move;
	}

	/**
	 * Sets move done by AI
	 */
	public void makeMove() {
		move();
	}

	/**
	 * Random number selected between 1-7
	 */
	private void move() {
		Random rand = new Random();
		this.move = rand.nextInt(7);
	}

}
