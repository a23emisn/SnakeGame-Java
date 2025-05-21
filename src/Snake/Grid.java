package Snake;

/**
 * This Class Represents the grid or "playable area".
 */
public class Grid {
	private Cell[][] grid;
	private Cell cell;

	// Constructor that initializes the grid to a specified size.
	public Grid(int gridSize) {
		this.setGrid(new Cell[gridSize][gridSize]);

		// Loop through each cell in the 2D grid array.
		for (int y = 0; y < gridSize; y++) {
			for (int x = 0; x < gridSize; x++) {
				cell = new Cell(x, y);

				// If the cell is on the edge of the grid, mark it differently (as a wall).
				if (y == 0 || x == 0 || y == gridSize - 1 || x == gridSize - 1) {
					cell.setContains(3);
				}
				// Assign the newly created cell to its position in the grid.
				getGrid()[x][y] = cell;
			}
		}
	}

	// Getter for grid.
	public Cell[][] getGrid() {
		return grid;
	}

	// Setter for grid.
	public void setGrid(Cell[][] grid) {
		this.grid = grid;
	}
}
