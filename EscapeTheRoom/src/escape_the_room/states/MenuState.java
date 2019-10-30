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

public class MenuState extends State {
	
	public MenuState(Handler handler) {
		super(handler);
		
		menuUIManager = new UIManager(handler);
		
		// Add buttons:
		
		menuUIManager.addObject(new UIImageButton(320, 216, 192, 96, Assets.startButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().setRoom1(handler.getGame().getRoom1());
				handler.getGame().getRoom1().setCurrent(true);
				State.setCurrentState(handler.getGame().gameState);
			}}));
		
		
		menuUIManager.addObject(new UIImageButton(320, 328, 192, 96, Assets.levelButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(handler.getGame().levelsState.getLevelsUIManager());
				State.setCurrentState(handler.getGame().levelsState);
			}}));
		
		
		menuUIManager.addObject(new UIImageButton(320, 440, 192, 96, Assets.exitButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getGame().getDisplay().getFrame().dispatchEvent(new WindowEvent(handler.getGame().getDisplay().getFrame(), WindowEvent.WINDOW_CLOSING));
			}}));
		
		
		menuUIManager.addObject(new UISoundImageButton(368, 552, 96, 96, Assets.soundButton, new ClickListener() {

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
		if(State.getCurrentState() == this)
			handler.getGame().getMouseManager().setUIManager(menuUIManager);
		
		menuUIManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		menuUIManager.render(g);
		Text.drawString(handler, "Escape The Room!", 420, 152, true, Color.BLACK, Assets.font64);
	}
	
}