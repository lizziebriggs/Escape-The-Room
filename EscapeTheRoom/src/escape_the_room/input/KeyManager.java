package escape_the_room.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	
	private boolean[] keys, justPressed, cantPress;
	public boolean up, down, left, right;
	public boolean interactionUp, interactionDown, interactionLeft, interactionRight;
	public boolean selectItem;
	
	public KeyManager() {
		
		keys = new boolean[256];
		justPressed = new boolean[keys.length];
		cantPress = new boolean[keys.length];
	}
	
	public void tick() {
		
		// Checks if user has just pressed a key, and can press it again
		for(int i = 0; i < keys.length; i++) {
			if(cantPress[i] && !keys[i]) {
				cantPress[i] = false;
			} else if(justPressed[i]) {
				cantPress[i] = true;
				justPressed[i] = false;
			}
			
			if(!cantPress[i] && keys[i]) {
				justPressed[i] = true;
			}
		}
		
		// Sets each key an action
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		
		interactionUp = keys[KeyEvent.VK_UP];
		interactionDown = keys[KeyEvent.VK_DOWN];
		interactionLeft = keys[KeyEvent.VK_LEFT];
		interactionRight = keys[KeyEvent.VK_RIGHT];
		
		selectItem = keys[KeyEvent.VK_ENTER];
	}
	
	
	// Key has just been pressed
	public boolean keyJustPressed(int keyCode) {
		
		 // Stops error if wrong value is passed in
		if(keyCode < 0 || keyCode >= keys.length)
			return false;
		return justPressed[keyCode];
	}
	
	
	// Implemented methods
	
	// Key is being pressed
	@Override
	public void keyPressed(KeyEvent e) {
		
		 // Stops error if wrong value is passed in
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		
		keys[e.getKeyCode()] = true;
	}
	
	// Key is not being pressed
	@Override
	public void keyReleased(KeyEvent e) {
		
		 // Stops error if wrong value is passed in
		if(e.getKeyCode() < 0 || e.getKeyCode() >= keys.length)
			return;
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
