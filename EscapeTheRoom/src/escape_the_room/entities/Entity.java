package escape_the_room.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import escape_the_room.Handler;
import escape_the_room.inventory.Inventory;

public abstract class Entity {

	protected Handler handler;
	protected float x, y;
	protected int height, width;
	
	protected boolean interactionComplete;
	protected boolean active = true;
	protected boolean hidden;
	protected Inventory inventory;
	protected Rectangle bounds;

	public Entity(Handler handler, float x, float y, int height, int width, boolean interactionComplete, boolean hidden, Inventory inventory) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.interactionComplete = interactionComplete;
		this.hidden = hidden;
		this.inventory = inventory;

		bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract void interaction();
	
	public void interact() {
		if(!interactionComplete)
			interaction();
	}
	
	// Checks if entity collides with another object
	public boolean checkEntityCollision(float xOffset, float yOffset) {
		
		for (Entity e : handler.getRoomManager().getCurrentRoom().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
				return true;
		}
		return false;
	}
	
	// Returns bounds of entities
	public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		
		return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width,
				bounds.height);
	}
	
	
	// GETTERS AND SETTERS

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isInteractionComplete() {
		return interactionComplete;
	}

	public void setInteractionComplete(boolean interactionComplete) {
		this.interactionComplete = interactionComplete;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

}
