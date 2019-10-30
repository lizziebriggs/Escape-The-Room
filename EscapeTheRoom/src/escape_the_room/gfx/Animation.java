package escape_the_room.gfx;

import java.awt.image.BufferedImage;

public class Animation {
	
	private int speed, index;
	private long lastTime, timer;
	private BufferedImage[] frames;
	
	public Animation(int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	public void tick(){
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		// Goes through each frame in animation
		if(timer > speed) {
			index ++;
			timer = 0;
			if(index >= frames.length) {
				index = 0;
			}
		}
	}
	
	// Gives current frame for animation
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}

}
