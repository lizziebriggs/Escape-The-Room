package escape_the_room.gfx;

import escape_the_room.Handler;
import escape_the_room.entities.Entity;
import escape_the_room.tiles.Tile;

public class GameCamera {
	
	private Handler handler;
	private float xOffset, yOffset;
	
	public GameCamera(Handler handler, float xOffset, float yOffset){
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	// Camera will not  move to show blank spaces on canvas
	public void checkBlankSpace() {
		if(xOffset < 0) {
			xOffset = 0;
		} else if(xOffset > handler.getRoomManager().getCurrentRoom().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getRoomManager().getCurrentRoom().getWidth() * Tile.TILEWIDTH - handler.getWidth();
		}
		
		if(yOffset < 0) {
			yOffset = 0;
		} else if(yOffset > handler.getRoomManager().getCurrentRoom().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getRoomManager().getCurrentRoom().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
		}
	}
	
	// Centres on player
	public void centreOnEntity(Entity e) {
		xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	
	// GETTERS AND SETTERS

	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
