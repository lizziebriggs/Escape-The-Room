package escape_the_room.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import escape_the_room.Handler;
import escape_the_room.entities.Entity;
import escape_the_room.gfx.Animation;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;

public class Player extends Creature {		
	
	// Still Player
	private BufferedImage curPosition;
	
	// Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	// Interaction timer
	// Prevents player from spamming on interactions
	private long lastInteractionTimer, interactionCooldown = 150, interactionTimer = interactionCooldown;
	
	public Player(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, interactionComplete, hidden, inventory);
		
		bounds.x = 8;
		bounds.y = 25;
		bounds.width = 80;
		bounds.height = 45;
		
		// Still Player
		curPosition = Assets.player_down[1];
		
		// Animations
		animDown = new Animation(250, Assets.player_down);
		animUp = new Animation(250, Assets.player_up);
		animLeft = new Animation(250, Assets.player_left);
		animRight = new Animation(250, Assets.player_right);
	}

	@Override
	public void tick() {
		
		// Animations
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		// Movement		
		getInput();
		move();
		handler.getGameCamera().centreOnEntity(this);
		
		// Interaction
		checkInteraction();
		
		// Inventory
		inventory.tick();
	}
	
	private void checkInteraction(){
		
		// Checks if player can interact with entity again
		interactionTimer += System.currentTimeMillis() - lastInteractionTimer;
		lastInteractionTimer = System.currentTimeMillis();
		if(interactionTimer < interactionCooldown)
			return;
		
		// Player can't interact with objects if inventory is open
		if(inventory.isActive())
			return;
		
		// Collision bounds rectangle
		Rectangle cb = getCollisionBounds(0, 0);
		
		// Interaction rectangle
		Rectangle ir = new Rectangle();
		int irSize = 20;
		ir.width = irSize;
		ir.height = irSize;
		
		// Sets bounds for interaction depending on player's interaction direction
		if(handler.getKeyManager().interactionUp) {
			ir.x = cb.x + cb.width / 2 - irSize / 2;
			ir.y = cb.y - irSize;
		} else if(handler.getKeyManager().interactionDown) {
			ir.x = cb.x + cb.width / 2 - irSize / 2;
			ir.y = cb.y + cb.height;
		} else if(handler.getKeyManager().interactionLeft) {
			ir.x = cb.x - irSize;
			ir.y = cb.y + cb.height / 2 - irSize / 2;
		} else if(handler.getKeyManager().interactionRight) {
			ir.x = cb.x + cb.width;
			ir.y = cb.y + cb.height / 2 - irSize / 2;
		} else {
			return;
		}
		
		interactionTimer = 0;
		
		// If player intersects with entity, interaction action will take place
		for(Entity e : handler.getRoomManager().getCurrentRoom().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0, 0).intersects(ir)){
				e.interact();
				return;
			}
		}
	}
	
	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		// Player cannot move if inventory is active
		if(inventory.isActive())
			return;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void postRender(Graphics g) {
		inventory.render(g);
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		
		// Animation for player interaction
		if(handler.getKeyManager().interactionDown) {
			return Assets.player_selDown;
		} else if(handler.getKeyManager().interactionUp) {
			return Assets.player_selUp;
		} else if(handler.getKeyManager().interactionLeft) {
			return Assets.player_selLeft;
		} else if(handler.getKeyManager().interactionRight) {
			return Assets.player_selRight;
		
		// Animation for player movement
		} else if(xMove < 0) {
			curPosition = Assets.player_left[0];
			return animLeft.getCurrentFrame();
		} else if(xMove > 0) {
			curPosition = Assets.player_right[1];
			return animRight.getCurrentFrame();
		} else if(yMove < 0) {
			curPosition = Assets.player_up[1];
			return animUp.getCurrentFrame();
		} else if(yMove > 0) {
			curPosition = Assets.player_down[1];
			return animDown.getCurrentFrame();
		} else {
			return curPosition;
		}
	}

	@Override
	public void interaction() {
		// Player currently has no interaction
	}
	
	
	//GETTERS AND SETTERS
	
	public Inventory getInventory(){
		return inventory;
	}
	
	public void setInventory(Inventory inventory){
		this.inventory = inventory;
	}

}
