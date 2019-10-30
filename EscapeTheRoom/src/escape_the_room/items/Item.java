package escape_the_room.items;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;

public class Item {
	
	// Items
	public static Item[] items = new Item[256];
	public static Item greenKeyItem = new Item(Assets.greenKey, "Green Key", 0);
	public static Item redKeyItem = new Item(Assets.redKey, "Red Key", 1);
	public static Item blueKeyItem = new Item(Assets.blueKey, "Blue Key", 2);
	public static Item yellowKeyItem = new Item(Assets.yellowKey, "Yellow Key", 3);
	public static Item bucketEmptyItem = new Item(Assets.bucketEmpty, "Bucket", 4);
	public static Item bucketFullItem = new Item(Assets.bucketFull, "Filled Bucket", 5);
	public static Item faucetHandleItem = new Item(Assets.faucetHandle, "Faucet Handle", 6);

	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32;
	
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;
	
	protected Rectangle bounds;
	
	protected int x, y, count;
	protected boolean pickedUp = false;
	
	public Item(BufferedImage texture, String name, int id) {
		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;
		
		bounds = new Rectangle(x, y, ITEMWIDTH, ITEMHEIGHT);
		
		items[id] = this;
	}
	
	public void tick() {
		if(handler.getRoomManager().getCurrentRoom().getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
			pickedUp = true;
			handler.getRoomManager().getCurrentRoom().getEntityManager().getPlayer().getInventory().addItem(this);
		}
	}
	
	// Renders item in room
	public void render(Graphics g) {
		if(handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}
	
	// Renders item in inventory
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}
	
	// FOR TESTING PURPOSES
	// Adds item straight to inventory instead of having to pick it up
	public Item createNewPickedUp(int count) {
		Item i = new Item(texture, name, id);
		i.setPickedUp(true);
		i.setCount(count);
		return i;
	}
	
	// Adds item to specific place in room
	public Item createNewNotPickedUp(int x, int y) {
		Item i = new Item(texture, name, id);
		i.setPickedUp(false);
		i.setPosition(x, y);
		return i;
	}
	
	// Sets position for where item must be when added to room
	public void setPosition (int x, int y) {
		this.x = x;
		this.y = y - 20;
		bounds.x = x;
		bounds.y = y;
	}
	
	
	// GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}
}