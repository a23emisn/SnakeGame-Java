package Snake;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class Represents a snake object.
 */
public class Snake extends GridObject {
	private Cell head;
	private List<Cell> body = new ArrayList<>();
	private Grid grid;
	private int middleY;
	private int middleX;
	private Cell lastBody;
	private Game game;
	private GridObject apple;

	// Snake constructor.
	public Snake(Grid grid, Game game) {
		this.grid = grid;
		this.game = game;
		// Initialize the snake's head and body position to the middle of the grid.
		middleY = grid.getGrid().length / 2;
		middleX = grid.getGrid()[0].length / 2;
		head = grid.getGrid()[middleY][middleX];

		body.add(grid.getGrid()[middleY + 1][middleX]);

		// Mark the head and the initial body cell on the grid.
		head.setContains(1);
		body.get(0).setContains(1);
	}

	@Override
	public void move(int headDirection) {
		if (game.isGameOver())
			return; // If the game is over, don't move the snake.

		// Store the current position of the head
		body.add(head);
		lastBody = grid.getGrid()[body.get(0).getX()][body.get(0).getY()];
		lastBody.setContains(0);
		body.remove(0);
		// Get the current head.
		// Determine the new position of the head based on the direction.
		switch (headDirection) {
		case 0:
			head = grid.getGrid()[head.getX() - 1][head.getY()];
			break;
		case 1:
			head = grid.getGrid()[head.getX()][head.getY() + 1];
			break;
		case 2:
			head = grid.getGrid()[head.getX() + 1][head.getY()];
			break;
		case 3:
			head = grid.getGrid()[head.getX()][head.getY() - 1];
			break;
		}

		// Handle snake eating something.
		if (head.getContains() != 0) {
			ateSometing(head.getContains(), lastBody);
		}

		// Mark the new head position on the grid.
		head.setContains(1);

	}

	private void ateSometing(int ate, Cell lastBody) {
		switch (ate) {
		case 1: // Snake hits its own body.
			game.gameOver();
			break;
		case 2: // Snake eats an apple.
			body.add(0, lastBody); // Grow the snake's body.
			lastBody.setContains(1);
			apple = new Apple(); // Create a new apple.
			apple.move(grid.getGrid()); // Place the new apple on the grid.
			game.incrementScore(); // Increment the score.
			break;
		case 3: // Snake hits a boundary or wall.
			game.gameOver();
			break;
		}
	}
}
