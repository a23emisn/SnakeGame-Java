package Snake;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This Class Represents the information sub menu "HowToPlay", and methods for
 * updating the this.
 */
public class HowToPlay {
	private JLabel howToPlayMenuTitle;
	private JFrame mainWindow;
	private Menu menu;
	private JLabel gameDescription;
	private JPanel menuSubPanel;
	private JPanel textContainer;
	private ActionListener returnToMenuButtonListener;
	private JButton returnToMenuButton;

	/**
	 * Constructor for the sub menu HowToPlay.
	 *
	 * @param mainWindow, menu The instances of menu and JFrame, used as template
	 *                    for HowToPlay.
	 */
	public HowToPlay(JFrame mainWindow, Menu menu) {
		this.mainWindow = mainWindow;
		this.menu = menu;
		createReturnToMenuButtonListener();
	}

	// Method that calls methods to clear and update the JFrame with the sub
	// menu contents.
	public void display() {
		clearJFrame();
		createHowToPlayComponents();
		rePaintJFrame();
	}

	// Method to clear the mainWindow
	private void clearJFrame() {
		mainWindow.getContentPane().removeAll();
		mainWindow.getContentPane().invalidate();
	}

	// Calls methods to create individual components and add to the sub menu.
	private void createHowToPlayComponents() {
		mainWindow.setLayout(new BorderLayout());
		menuSubPanel = new JPanel();
		menuSubPanel.setLayout(new BoxLayout(menuSubPanel, BoxLayout.Y_AXIS));
		addMenuTitle();
		addHowToPlayText();
		addReturnToMainMenuButton();
		mainWindow.add(menuSubPanel, BorderLayout.CENTER);
	}

	// Method to create and add a JLabel with the title for the sub menu.
	private void addMenuTitle() {
		howToPlayMenuTitle = new JLabel("How To Play:");
		howToPlayMenuTitle.setFont(new Font("HELVETICA", Font.BOLD, 40));
		howToPlayMenuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		menuSubPanel.add(howToPlayMenuTitle);
		menuSubPanel.add(Box.createVerticalGlue()); // Adds spacing below menu title section,
													// used to center area vertically.
	}

	// Method to create and add a JLabel with the sub menu information text.
	private void addHowToPlayText() {
		textContainer = new JPanel();
		textContainer.setVisible(true);
		gameDescription = new JLabel();
		gameDescription.setFont(new Font("HELVETICA", Font.BOLD, 15));
		gameDescription.setText(
				"<html>To play Almigty Snake, use the arrow keys on your keyboard <br> to navigate the snake across the screen. Your goal is <br> to eat the appearing apples, which makes the snake grow. <br><br> Avoid hitting the lava or the snake's own body, as this will <br> end the game. To win Almighty-Snake, reach the maximum <br>  size, in other words, making the snake cover the entire grid.<br> Please use your preferred grid size and snake speed! <br> <br>  Good Luck!</html>");
		gameDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
		textContainer.add(gameDescription);
		menuSubPanel.add(textContainer);
		menuSubPanel.add(Box.createVerticalGlue()); // Adds spacing below text container
													// section, used to center area
													// vertically.
	}

	// Method to create and add a returnToMainMenu button.
	private void addReturnToMainMenuButton() {
		returnToMenuButton = new JButton("Return to main menu");
		returnToMenuButton.addActionListener(returnToMenuButtonListener);
		returnToMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		returnToMenuButton.setFont(returnToMenuButton.getFont().deriveFont(Font.BOLD, 14));
		menuSubPanel.add(returnToMenuButton);
		menuSubPanel.add(Box.createVerticalGlue()); // Adds spacing below returnToMenuButton
													// section, used to center area
													// vertically.
	}

	// Revalidates and repaints the mainWindow to show the information sub menu.
	private void rePaintJFrame() {
		mainWindow.revalidate();
		mainWindow.repaint();
	}

	// Creates an ActionListener for the returnToMainMenu button.
	private void createReturnToMenuButtonListener() {
		returnToMenuButtonListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menu.reDisplayMenu(); // Calls method to redisplay the mainMenu.
			}
		};
	}
}