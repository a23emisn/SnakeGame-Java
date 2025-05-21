package Snake;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * This Class Represents the game menu screen.
 */
public class Menu {
	private JFrame mainMenu;
	private HowToPlay howToPlayInfo;
	private JButton startGameButton;
	private Game game;
	private int gridSize;
	private int snakeSpeed;
	private boolean gridSizeIsSet;
	private boolean snakeSpeedIsSet;
	private JPanel menuContents;
	private JLabel titleLabel;
	private JLabel gridSelectionLabel;
	private JPanel gridSizePanel;
	private JRadioButton gridSize6x6;
	private JRadioButton gridSize12x12;
	private JRadioButton gridSize18x18;
	private ButtonGroup snakeSpeedSelection;
	private ButtonGroup gridSizeSelection;
	private JRadioButton snakeSpeed1;
	private JRadioButton snakeSpeed2;
	private JRadioButton snakeSpeed3;
	private JPanel snakeSpeedPanel;
	private JLabel speedSelectionLabel;
	private JButton howToPlayButton;
	private JPanel buttonPanel;
	private JPanel infoPanel;
	private JLabel creatorsLabel;

	// Central method that calls methods for creating the main menu.
	public void execute() {
		initializeMainMenu();
		createMenuComponents();
		setMainFrameVisibility(true);
	}

	// Initializes the game menu JFrame, and a creates a LeaderBoard Object.
	private void initializeMainMenu() {
		mainMenu = new JFrame("ALMIGHTY SNAKE v1.0");
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setSize(500, 500);
		mainMenu.setResizable(false);
		mainMenu.setLocationRelativeTo(null); // Centers the frame in the screen
		howToPlayInfo = new HowToPlay(mainMenu, this);
	}

	// Calls individual functions for creating individual menu components.
	private void createMenuComponents() {
		menuContents = new JPanel();
		menuContents.setLayout(new BoxLayout(menuContents, BoxLayout.Y_AXIS));

		// Call functions to create respective section, and then add them to
		// menuContents JPanel.
		addTitleLabel(menuContents);
		addGridSizeSelection(menuContents);
		addSnakeSpeedSelection(menuContents);
		addButtons(menuContents);
		addCreatorsLabel(menuContents);

		mainMenu.add(menuContents); // Adds the JPanel menuContents to
									// the main Frame.
	}

	// Creates and adds the game title to the game menu
	private void addTitleLabel(Container container) {
		titleLabel = new JLabel("ALMIGHTY SNAKE");
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setFont(new Font("HELVETICA", Font.BOLD, 40));
		container.add(titleLabel);
		container.add(Box.createVerticalGlue()); // Adds spacing below TitleLabel section,
													// used to center area vertically.
	}

	// Creates the gridSizeSelection section.
	private void addGridSizeSelection(Container container) {
		// Creates the label for this section.
		gridSelectionLabel = new JLabel("Select the grid size:");
		gridSelectionLabel.setFont(new Font("HELVETICA", Font.BOLD, 19));
		gridSelectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(gridSelectionLabel);

		// Creates panel to contain contents of this section.
		gridSizePanel = new JPanel();
		gridSizePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Creates the ButtonGroup, buttons and add ActionListeners.
		gridSizeSelection = new ButtonGroup();
		gridSize6x6 = new JRadioButton("6 x 6");
		gridSize6x6.setFont(gridSize6x6.getFont().deriveFont(Font.BOLD, 16));
		gridSize6x6.addActionListener(gridSizeButtonListener(6 + 2));
		gridSize12x12 = new JRadioButton("12 x 12");
		gridSize12x12.setFont(gridSize12x12.getFont().deriveFont(Font.BOLD, 16));
		gridSize12x12.addActionListener(gridSizeButtonListener(12 + 2));
		gridSize18x18 = new JRadioButton("18 x 18");
		gridSize18x18.setFont(gridSize18x18.getFont().deriveFont(Font.BOLD, 16));
		gridSize18x18.addActionListener(gridSizeButtonListener(16 + 2));

		// Add the buttons to the ButtonGroup.
		gridSizeSelection.add(gridSize6x6);
		gridSizeSelection.add(gridSize12x12);
		gridSizeSelection.add(gridSize18x18);

		// Add the buttons to the JPanel.
		gridSizePanel.add(gridSize6x6);
		gridSizePanel.add(gridSize12x12);
		gridSizePanel.add(gridSize18x18);

		container.add(gridSizePanel);
		container.add(Box.createVerticalGlue()); // Adds spacing below gridSizeSelection
													// section, used to center area
													// vertically.
	}

	// Creates the gridSizeSelection section.
	private void addSnakeSpeedSelection(Container container) {
		// Creates the label for this section.
		speedSelectionLabel = new JLabel("Select your snake's speed:");
		speedSelectionLabel.setFont(new Font("HELVETICA", Font.BOLD, 19));
		speedSelectionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		container.add(speedSelectionLabel);

		// Creates panel to contain contents of this section.
		snakeSpeedPanel = new JPanel();
		snakeSpeedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Create the ButtonGroup, buttons and add ActionListeners.
		snakeSpeedSelection = new ButtonGroup();
		snakeSpeed1 = new JRadioButton("Slow");
		snakeSpeed1.setFont(snakeSpeed1.getFont().deriveFont(Font.BOLD, 16));
		snakeSpeed1.addActionListener(snakeSpeedButtonListener(450));
		snakeSpeed2 = new JRadioButton("Medium");
		snakeSpeed2.setFont(snakeSpeed2.getFont().deriveFont(Font.BOLD, 16));
		snakeSpeed2.addActionListener(snakeSpeedButtonListener(300));
		snakeSpeed3 = new JRadioButton("Fast");
		snakeSpeed3.setFont(snakeSpeed3.getFont().deriveFont(Font.BOLD, 16));
		snakeSpeed3.addActionListener(snakeSpeedButtonListener(150));

		// Add the buttons to the ButtonGroup.
		snakeSpeedSelection.add(snakeSpeed1);
		snakeSpeedSelection.add(snakeSpeed2);
		snakeSpeedSelection.add(snakeSpeed3);

		// Add the buttons to the JPanel.
		snakeSpeedPanel.add(snakeSpeed1);
		snakeSpeedPanel.add(snakeSpeed2);
		snakeSpeedPanel.add(snakeSpeed3);

		container.add(snakeSpeedPanel);
		container.add(Box.createVerticalGlue()); // Adds spacing below snakeSpeedSelection
													// section, used to center area
													// vertically.
	}

	// Creates and adds the start game and LeaderBoard buttons.
	private void addButtons(Container container) {
		startGameButton = new JButton("Start Game");
		startGameButton.addActionListener(StartGameButtonListener);
		startGameButton.setEnabled(false);

		howToPlayButton = new JButton("How to play?");
		howToPlayButton.addActionListener(howToPlayButtonListener);
		howToPlayButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		startGameButton.setFont(startGameButton.getFont().deriveFont(Font.BOLD, 35));
		howToPlayButton.setFont(howToPlayButton.getFont().deriveFont(Font.BOLD, 14));
		buttonPanel.add(startGameButton);
		container.add(buttonPanel);
		container.add(Box.createVerticalGlue()); // Adds spacing above
													// viewLeaderboardButton, used
													// to center vertically.
		container.add(howToPlayButton);
		container.add(Box.createVerticalGlue()); // Adds spacing below
													// viewLeaderboardButton, used
													// to center vertically.
	}

	// Creates and adds a panel and a label with creators of the game to the
	// mainWindow.
	private void addCreatorsLabel(Container container) {
		infoPanel = new JPanel(new FlowLayout());
		creatorsLabel = new JLabel("By Peter and snackan80.");
		creatorsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		infoPanel.add(creatorsLabel);
		container.add(creatorsLabel, BorderLayout.SOUTH);
	}

	/**
	 * Sets the visibility of the main menu.
	 * 
	 * @param visibility The boolean value for visibility.
	 */
	private void setMainFrameVisibility(boolean visibility) {
		mainMenu.setVisible(visibility);
	}

	// Method that initializes the game window and starts the game.
	public void startGame() {
		game = new Game(gridSize, snakeSpeed);
		game.start();
	}

	// ActionListener for "Start Game"-button, calls method "startGame()".
	private ActionListener StartGameButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			startGame();
		}
	};

	/**
	 * Creates ActionListener for gridSize buttons.
	 * 
	 * @param size The selected grid size.
	 * @return ActionListener
	 */
	private ActionListener gridSizeButtonListener(int size) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gridSizeIsSet = true;
				gridSize = size; // Assign the selected grid size to variable gridSize.
				updateButtonState(); // Check if start game button can be
										// enabled.
			}
		};
	}

	/**
	 * Creates ActionListener for snakeSpeed buttons.
	 * 
	 * @param speed The selected snake speed.
	 */
	private ActionListener snakeSpeedButtonListener(int speed) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				snakeSpeedIsSet = true;
				snakeSpeed = speed; // Assign the selected speed to variable snakeSpeed.
				updateButtonState(); // Check if start game button can be
										// enabled.
			}
		};
	}

	// Checks if gridSize and snakeSpeed selections are made, and if so enables
	// start game-button.
	private void updateButtonState() {
		if (gridSizeIsSet && snakeSpeedIsSet) {
			startGameButton.setEnabled(true);
		}
	}

	// Creates ActionListener for the How to play button.
	private ActionListener howToPlayButtonListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			howToPlayInfo.display(); // Method that launches the HowToPlay menu.
		}
	};

	// Method that redisplays menu when exiting HowToPlay sub menu.
	public void reDisplayMenu() {
		mainMenu.getContentPane().removeAll();
		mainMenu.getContentPane().invalidate();
		mainMenu.setLayout(new BorderLayout());
		createMenuComponents();
		mainMenu.revalidate();
		mainMenu.repaint();
		gridSizeIsSet = false; // Reset gridSize selection.
		snakeSpeedIsSet = false; // Reset snakeSpeed selection.
	}
}
