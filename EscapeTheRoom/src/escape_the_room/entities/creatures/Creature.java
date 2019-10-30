package escape_the_room.entities.creatures;

import escape_the_room.Handler;
import escape_the_room.entities.Entity;
import escape_the_room.inventory.Inventory;
import escape_the_room.tiles.Tile;

public abstract class Creature extends Entity {
	
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 75,
							DEFAULT_CREATURE_HEIGHT = 75;
	
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int height, int width, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, height, width, interactionComplete, hidden, inventory);
		
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	
	// Moves creature
	public void move() {
		if(!checkEntityCollision(xMove, 0f))
			moveX();
		if(!checkEntityCollision(0f, yMove))
			moveY();
	}
	
	public void moveX() {
		
		// Move right
		if(xMove > 0) {
			
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT)) &&
					!collisionWithTile(tx, (int) ((y+ bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH - bounds.x  - bounds.width - 1;
			}
		
		// Move left
		} else if(xMove < 0) {
			
			int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int) ((y + bounds.y) / Tile.TILEHEIGHT)) &&
					!collisionWithTile(tx, (int) ((y+ bounds.y + bounds.height) / Tile.TILEHEIGHT))) {
				x += xMove;
			} else {
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
			
		}
	}
	
	public void moveY() {
		
		// Move up
		if(yMove < 0) {
			
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
			}
		
		// Move down
		} else if(yMove > 0) {
			
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
			
		}
	}
	
	// Checks if creature collides with solid tile
	protected boolean collisionWithTile(int x, int y) {
		return handler.getRoomManager().getCurrentRoom().getTile(x, y).isSolid();
	}
	
	
	// GETTERS AND SETTERS

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
