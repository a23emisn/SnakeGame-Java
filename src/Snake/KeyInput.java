package Snake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class represents a key listener object for arrow keys. It listens for
 * keyboard input events and updates the head direction accordingly.
 */
public class KeyInput implements KeyListener {
	private int headDirection = 0;

	// Sets a direction depending on key input.
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP: // If up arrow was pressed.
			headDirection = 0;
			break;
		case KeyEvent.VK_DOWN: // If down arrow was pressed.
			headDirection = 2;
			break;
		case KeyEvent.VK_RIGHT: // If right arrow was pressed.
			headDirection = 1;
			break;
		case KeyEvent.VK_LEFT: // If left arrow was pressed.
			headDirection = 3;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	// Getter for direction.
	public int getHeadDirection() {
		return headDirection;
	}
}
