package Snake;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * This Class Represents the game over dialog.
 */
public class GameOver {
	private final JFrame parent;
	private final int score;
	private final int gridSize;
	private final int snakeSpeed;
	private JLabel resultsLabel;
	private JDialog dialog;
	private JButton playAgain;
	private JButton returnToMenu;
	private JPanel buttonPanel;

	// Constructor for GameOver class.
	public GameOver(JFrame parent, int score, int gridSize, int snakeSpeed) {
		this.parent = parent;
		this.score = score;
		this.gridSize = gridSize;
		this.snakeSpeed = snakeSpeed;
		initializeDialog();
	}

	// Method to create dialog and add individual components.
	private void initializeDialog() {
		dialog = new JDialog(parent, "Game Over", true); // Create a new JDialog.
		dialog.setUndecorated(true); // Disable Dialog window operations.
		dialog.setLayout(new BorderLayout());
		createResultsLabel();
		createButtons();
		dialog.add(resultsLabel, BorderLayout.CENTER); // Add and align the results label in the middle of the dialog
		dialog.add(buttonPanel, BorderLayout.SOUTH); // Add the buttons at the bottom of the dialog.
		dialog.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		dialog.setSize(400, 150); // Set dialog size;
		dialog.setLocationRelativeTo(parent); // Display the dialog in the middle of gameWindow.
	}

	/*
	 * Method to check if game was won, or if snake died. If score is lower than
	 * grid*grid, the snake somehow died. Otherwise if the score equals the
	 * grid*grid size - 2, the snake ate all apples and won. The JLabel text is set
	 * thereafter.
	 */
	private void checkIfGameWon() {
		if (score < ((gridSize - 2) * (gridSize - 2)) - 2) {
			resultsLabel.setText("Game Over! You scored: " + score);
		} else if (score == ((gridSize - 2) * (gridSize - 2)) - 2) {
			resultsLabel.setText("Congrats, you Won! You scored: " + score);
		}
	}

	// Method to set the dialog to visible.
	public void showDialog() {
		dialog.setVisible(true);
	}

	// Create and add ResultsLabel.
	public void createResultsLabel() {
		resultsLabel = new JLabel();
		checkIfGameWon(); // Check results of the game;
		resultsLabel.setFont(new Font("Arial", Font.BOLD, 20));
		resultsLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

	// Create and add the JDialog option buttons.
	public void createButtons() {
		playAgain = new JButton("Play Again");
		playAgain.addActionListener(playAgainActionListener);
		returnToMenu = new JButton("Return to Menu");
		returnToMenu.addActionListener(returnToMenuActionListener);
		buttonPanel = new JPanel(new FlowLayout()); // Panel to hold buttons.
		buttonPanel.add(playAgain);
		buttonPanel.add(returnToMenu);
	}

	// Method to handle a play again query from button.
	private void playAgainPressed() {
		dialog.dispose(); // Close the dialog.
		parent.dispose(); // Close the gameWindow.
		Game newGame = new Game(gridSize, snakeSpeed); // Initialize a new game.
		newGame.start(); // Run the new game.
	}

	// Method to handle a return to menu query from button.
	private void returnToMenuPressed() {
		dialog.dispose(); // Close the dialog.
		parent.dispose(); // Close the gameWindow.
	}

	private ActionListener playAgainActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			playAgainPressed(); // Method that launches the HowToPlay menu.
		}
	};
	private ActionListener returnToMenuActionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			returnToMenuPressed(); // Method that launches the HowToPlay menu.
		}
	};
}
