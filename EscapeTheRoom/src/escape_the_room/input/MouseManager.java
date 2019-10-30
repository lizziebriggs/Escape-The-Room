package escape_the_room.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import escape_the_room.ui.UIManager;

public class MouseManager implements MouseListener, MouseMotionListener {

	private boolean leftPressed, rightPressed;
	private int mouseX, mouseY;
	private UIManager uiManager;
	
	public MouseManager() {
		
	}
	
	
	// Implemented Methods
	
	// Mouse button clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	
	// Mouse button pressed
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = true;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = true;
	}
	
	// Mouse button released
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON1)
			leftPressed = false;
		else if(e.getButton() == MouseEvent.BUTTON3)
			rightPressed = false;
		
		if(uiManager != null)
			uiManager.onMouseRelease(e);
	}

	// Mouse cursor moved
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		
		if(uiManager != null)
			uiManager.onMouseMove(e);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
	
	//GETTERS AND SETTERS

	public boolean isLeftPressed(){
		return leftPressed;
	}
	
	public boolean isRightPressed(){
		return rightPressed;
	}
	
	public int getMouseX(){
		return mouseX;
	}
	
	public int getMouseY(){
		return mouseY;
	}
	
	public void setUIManager(UIManager uiManager){
		this.uiManager = uiManager;
	}
	
	public UIManager getUiManager() {
		return uiManager;
	}
	
}
