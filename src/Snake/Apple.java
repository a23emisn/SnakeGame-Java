package Snake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This Class an apple and manages it's randomized spawn.
 */
public class Apple extends GridObject {

	private List<Cell> emptyCells;
	private Cell randomEmptyCell;

	// when called will instantiate an gameObject apple at random position.
	@Override
	public void move(Cell[][] grid) {
		emptyCells = new ArrayList<>();
		for (Cell[] row : grid) {
			for (Cell cell : row) {
				if (cell.getContains() == 0) {
					emptyCells.add(cell);
				}
			}
		}

		// Set the cell to contain an apple.
		if (!emptyCells.isEmpty()) {
			Collections.shuffle(emptyCells);
			randomEmptyCell = emptyCells.get(0);
			randomEmptyCell.setContains(2);
		}
	}
}
