package escape_the_room.states;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowEvent;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.gfx.Text;
import escape_the_room.ui.ClickListener;
import escape_the_room.ui.UIImageButton;
import escape_the_room.ui.UIManager;
import escape_the_room.ui.UISoundImageButton;

public class PauseGameState extends State {
	
	private boolean active = false;
	
	public PauseGameState(Handler handler) {
		super(handler);
		
		pauseGameUIManager = new UIManager(handler);
		
		// Add buttons
		
		pauseGameUIManager.addObject(new UIImageButton(320, 216, 192, 96, Assets.resumeButton, new ClickListener() {

			@Override
			public void onClick() {
				State.setCurrentState(handler.getGame().gameState);
			}}));
		
		pauseGameUIManager.addObject(new UIImageButton(320, 328, 192, 96, Assets.menuButton, new ClickListener() {

			@Override
			public void onClick() {
				State.setCurrentState(handler.getGame().menuState);
			}}));
		
		
		pauseGameUIManager.addObject(new UIImageButton(320, 440, 192, 96, Assets.exitButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getGame().getDisplay().getFrame().dispatchEvent(new WindowEvent(handler.getGame().getDisplay().getFrame(), WindowEvent.WINDOW_CLOSING));
			}}));
		
		
		pauseGameUIManager.addObject(new UISoundImageButton(368, 552, 96, 96, Assets.soundButton, new ClickListener() {

			@Override
			public void onClick() {
				if(Assets.bgMusic.getIsPlaying())
					Assets.bgMusic.stopSound();
				else
					Assets.bgMusic.resumeSoundLoop();
			}}));

	}

	@Override
	public void tick() {
		handler.getGame().getMouseManager().setUIManager(pauseGameUIManager);
		pauseGameUIManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		pauseGameUIManager.render(g);
		Text.drawString(handler, "Game Paused", 420, 152, true, Color.BLACK, Assets.font64);
	}
	
	
	// GETTERS AND SETTERS

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
