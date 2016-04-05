package Connect4;

import java.util.*;

public class AI {
	private int move;

	public int MakeMove() {
		return move;
	}

	public void ChooseMove() {
		move();
	}

	private void move() {
		Random rand = new Random();
		this.move = rand.nextInt(6) + 1;
	}

}
