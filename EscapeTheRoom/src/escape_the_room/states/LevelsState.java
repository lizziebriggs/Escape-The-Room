package escape_the_room.states;

import java.awt.Color;
import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.gfx.Text;
import escape_the_room.ui.ClickListener;
import escape_the_room.ui.UIImageButton;
import escape_the_room.ui.UIManager;

public class LevelsState extends State {
	
	public LevelsState(Handler handler) {
		super(handler);
		
		levelsUIManager = new UIManager(handler);
		
		// Add buttons:
		
		levelsUIManager.addObject(new UIImageButton(64, 216, 64, 64, Assets.level1, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().getRoom1().setCurrent(true);
				State.setCurrentState(handler.getGame().gameState);
			}}));
		
		levelsUIManager.addObject(new UIImageButton(192, 216, 64, 64, Assets.level2, new ClickListener() {
			
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().getRoom2().setCurrent(true);
				State.setCurrentState(handler.getGame().gameState);
			}}));		
		
		
		
		levelsUIManager.addObject(new UIImageButton(320, 440, 192, 96, Assets.menuButton, new ClickListener() {

			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(handler.getGame().menuState.getMenuUIManager());
				State.setCurrentState(handler.getGame().menuState);
			}}));
	}

	@Override
	public void tick() {
		levelsUIManager.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.menuBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
		levelsUIManager.render(g);
		Text.drawString(handler, "Select Level", 420, 88, true, Color.BLACK, Assets.font64);
	}
}