package escape_the_room.states;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.ui.UIManager;

public abstract class State {
	
	private static State currentState = null;
	
	protected Handler handler;
	protected UIManager menuUIManager;
	protected UIManager levelsUIManager;
	protected UIManager pauseGameUIManager;
	
	public State(Handler handler) {
		this.handler = handler;
	}
	
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	
	// GETTERS AND SETTERS
	
	public static void setCurrentState(State state) {
		currentState = state;
	}
	
	public static State getCurrentState() {
		return currentState;
	}

	public UIManager getMenuUIManager() {
		return menuUIManager;
	}

	public void setMenuUIManager(UIManager menuUIManager) {
		this.menuUIManager = menuUIManager;
	}

	public UIManager getLevelsUIManager() {
		return levelsUIManager;
	}

	public void setLevelsUIManager(UIManager levelsUIManager) {
		this.levelsUIManager = levelsUIManager;
	}


	public UIManager getPauseGameUIManager() {
		return pauseGameUIManager;
	}


	public void setPauseGameUIManager(UIManager pauseGameUIManager) {
		this.pauseGameUIManager = pauseGameUIManager;
	}	

}