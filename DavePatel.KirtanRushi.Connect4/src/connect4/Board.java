package connect4;

public class Board {
	private int grid[][];
	private static final int rows = 7;
	private static final int columns = 6;
	private int spacesLeft = 0;

	Board() {
		grid = new int[rows][columns];
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < columns; y++) {
				grid[x][y] = 0;
				spacesLeft++;
			}
		}
	}

	public int getSpacesLeft() {
		return spacesLeft;
	}

	public int[][] getGrid() {
		return grid;
	}

	public boolean gridEquals(int a, int b, int c) {
		return grid[a][b] == c;
	}

	public int getRows() {// returns the rows
		return rows;
	}

	public int getColumns() {// returns the rows
		return columns;
	}

	public boolean isColumnFull(int col) {// checks for room in column and
											// returns free spot.
		boolean result = true;
		if (grid[6][col] == 0) {
			result = false;
		}
		return result;
	}

	public void update(int col) {
		int row = 0;
		boolean found = false;
		while (!found && row < 6) {
			if (grid[row][col] == 0) {
				grid[row][col] = -1;
				found = true;
			}
			row++;
		}
	}
}
