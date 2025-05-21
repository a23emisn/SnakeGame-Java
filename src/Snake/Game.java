package Snake;

/**
 * This Class manages the game logic.
 */
public class Game extends Thread {
	private GameOver gameOver;
	private int snakeSpeed;
	private int gridSize;
	private int score;
	private Grid grid;
	private GridObject snake;
	private GridObject apple;
	private GameWindow gameWindow;
	private KeyInput arrowKeyInput;
	private boolean live;

	// Constructor initializes the game with grid size and snake speed.
	public Game(int gridSize, int snakeSpeed) {
		this.gridSize = gridSize;
		this.snakeSpeed = snakeSpeed;
		grid = new Grid(gridSize);
		arrowKeyInput = new KeyInput();
		gameWindow = new GameWindow(arrowKeyInput, this);
		snake = new Snake(grid, this);
	}

	@Override
	public void run() {
		gameWindow.initializeGameWindow(gridSize, snakeSpeed); // Calls method to initialize the game window.

		apple = new Apple();
		apple.move(grid.getGrid()); // Place the apple on the grid.
		int previousHeadDirection = 0;
		live = true; // Set game state to running.
		while (live) {
			int headDirection = arrowKeyInput.getHeadDirection();

			// Prevent the snake from reversing onto itself.
			if (previousHeadDirection - headDirection == 2 || headDirection - previousHeadDirection == 2) {
				headDirection = previousHeadDirection;
			}

			snake.move(headDirection); // Move the snake in the current direction.
			previousHeadDirection = headDirection;

			// Update the game window with the new grid state
			gameWindow.updateSnakeGrid(grid.getGrid(), gridSize);

			// Pause the game loop at the control of the speed of the game.
			try {
				Thread.sleep(snakeSpeed);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Triggered when the game is over.
	public void gameOver() {
		live = false;
		gameOver = new GameOver(gameWindow.gameWindow, score, gridSize, snakeSpeed);
		gameOver.showDialog();
	}

	// Check if game is over.
	public boolean isGameOver() {
		return !live;
	}

	// Increment the score.
	public void incrementScore() {
		score += 1;
		gameWindow.updateScore();
	}

	// Returns the current score
	public int getScore() {
		return score;
	}
}
