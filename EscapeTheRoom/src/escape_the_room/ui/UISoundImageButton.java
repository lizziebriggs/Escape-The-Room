package escape_the_room.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import escape_the_room.gfx.Assets;

public class UISoundImageButton extends UIObject{
	
	private BufferedImage[] images;
	private ClickListener clicker;

	public UISoundImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker){
		super(x, y, width, height);
		this.images = images;
		this.clicker = clicker;
	}

	@Override
	public void tick() {}
	
	// Changes button image depending on if music is playing or not
	@Override
	public void render(Graphics g) {
		if(Assets.bgMusic.getIsPlaying())
			g.drawImage(images[0], (int) x, (int) y, width, height, null);
		else
			g.drawImage(images[1], (int) x, (int) y, width, height, null);
	}

	@Override
	public void onClick() {
		clicker.onClick();
	}
}