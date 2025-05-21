package Snake;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * This Class Represents the game-window, and methods for updating the window.
 */
public class GameWindow {
	private int score = 0;
	private JPanel windowContents;
	public JFrame gameWindow;
	private JLabel scoreLabel;
	private JPanel snakeGrid;
	private JPanel scorePanel;
	private KeyInput arrowKeyInput;
	private JPanel coloredPanel;
	private Cell cell;
	private Game game;
	private static final Color snakeGreen = new Color(36, 62, 19);
	private static final Color lavaOrange = new Color(247, 104, 6);
	private static final Color appleRed = new Color(241, 12, 69);
	private static final Color groundGray = new Color(59, 59, 59);
	private static final Border groundBorder = BorderFactory.createLineBorder(groundGray);
	private static final Border appleBorder = BorderFactory.createLineBorder(appleRed);
	private static final Border snakeBorder = BorderFactory.createLineBorder(Color.BLACK);

	// Constructor for GameWindow class.
	public GameWindow(KeyInput arrowKeyInput, Game game) {
		this.arrowKeyInput = arrowKeyInput;
		this.game = game;
	}

	// Initializes the game window JFrame.
	public void initializeGameWindow(int gridSize, int snakeSpeed) {
		initializeGameFrame();
		createWindowContents();
		createSnakeGrid(gridSize);
	}

	// Initializes the game window JFrame.
	private void initializeGameFrame() {
		gameWindow = new JFrame("ALMIGHTY SNAKE v1.0");
		gameWindow.setLayout(new BorderLayout());
		gameWindow.setSize(800, 800);
		gameWindow.setLocationRelativeTo(null); // Center the frame on the screen
		gameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window closes and
																		// removes resources in use.
		gameWindow.setVisible(true);
		gameWindow.addKeyListener(arrowKeyInput); // adds a KeyListener object to this window.
	}

	// Create the individual components and add them to the window.
	private void createWindowContents() {
		windowContents = new JPanel(new BorderLayout());
		windowContents.setPreferredSize(new Dimension(400, 400)); // Set preferred size
		windowContents.setVisible(true);

		scorePanel = new JPanel();
		scoreLabel = new JLabel("SCORE: " + score);
		scoreLabel.setFont(new Font("HELVETICA", Font.BOLD, 40));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the label
		scorePanel.add(scoreLabel);
		windowContents.add(scorePanel, BorderLayout.SOUTH); // Add title label to the top

		// Ensure that the windowContents panel expands to fill available space
		gameWindow.add(windowContents, BorderLayout.CENTER);
	}

	/**
	 * Creates a initial grid of selected size and adds it to the game window frame.
	 */
	private void createSnakeGrid(int gridSize) {
		snakeGrid = new JPanel(new GridLayout(gridSize, gridSize));
		for (int i = 1; i <= gridSize * gridSize; i++) {
			coloredPanel = new JPanel();
			coloredPanel.setBackground(groundGray);
			snakeGrid.add(coloredPanel);
		}
		// Add the grid panel to the window contents
		windowContents.add(snakeGrid, BorderLayout.CENTER);
	}

	// Method that updates the grid, sets color of the individual JPanel in
	// grid, that represents a cell, depending on what the cell contains.
	public void updateSnakeGrid(Cell[][] grid, int gridSize) {
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				cell = grid[i][j];
				coloredPanel = (JPanel) snakeGrid.getComponent(i * gridSize + j);
				switch (cell.getContains()) {
				case 0:
					coloredPanel.setBackground(groundGray); // Set color if cell is ground.
					coloredPanel.setBorder(groundBorder);
					break;
				case 1:
					coloredPanel.setBackground(snakeGreen); // Set color if cell is part of the snake.
					coloredPanel.setBorder(snakeBorder);
					break;
				case 2:
					coloredPanel.setBackground(appleRed); // Set color if cell is apple.
					coloredPanel.setBorder(appleBorder);
					break;
				case 3:
					coloredPanel.setBackground(lavaOrange); // Set color if cell is lava.
					break;
				}
			}
		}

		// Repaint the grid panel to reflect changes.
		snakeGrid.revalidate();
		snakeGrid.repaint();
	}

	// Method that updates the score in gameWindow.
	public void updateScore() {
		score = game.getScore();
		scoreLabel.setText("SCORE: " + score);
		scorePanel.revalidate();
		scorePanel.repaint();
	}
}
