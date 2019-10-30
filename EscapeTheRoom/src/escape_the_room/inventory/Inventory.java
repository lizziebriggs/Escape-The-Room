package escape_the_room.inventory;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.gfx.Text;
import escape_the_room.items.Item;

public class Inventory {
	
	private Handler handler;
	private boolean active = false;
	private ArrayList<Item> inventoryItems;
	
	private int invX = 160, invY = 160,
			invWidth = 512, invHeight = 384,
			invListCenterX = invX + 171,
			invListCenterY = invY + invHeight / 2 + 5,
			invListSpacing = 30;
	
	private int invImageX = 548, invImageY = 194,
			invImageWidth = 64, invImageHeight = 64;
	
	private int invCountX = 580, invCountY = 284;
	
	private int selectedItem = 0;
	private Item itemToUse;
	
	public Inventory(Handler handler){
		this.handler = handler;
		inventoryItems = new ArrayList<Item>();
		
		// Testing for inventory - add items here
		
		//addItem(Item.yellowKeyItem.createNewPickedUp(1));
		//addItem(Item.bucketFullItem.createNewPickedUp(1));
		//addItem(Item.faucetHandleItem.createNewPickedUp(1));
		
	}

	public void tick(){
		
		// Closes inventory
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_E))
			active = !active;
		if(!active)
			return;
		
		// Traversing through list:
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_W)) {
			selectedItem--;
			Assets.inventorySelect.playSound();
		}
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_S)) {
			selectedItem++;
			Assets.inventorySelect.playSound();
		}
		
		if(selectedItem < 0)
			selectedItem = inventoryItems.size() - 1;
		else if(selectedItem >= inventoryItems.size())
			selectedItem = 0;
		
		
		//Selecting an item:
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ENTER)) {
			if(inventoryItems.isEmpty()) {
				System.out.println("You have nothing in your inventory!");
			} else if (inventoryItems.get(selectedItem).getCount() == 0) {
				System.out.println("You do not have enough " + inventoryItems.get(selectedItem).getName().toUpperCase() + "S");
			} else {
				itemToUse = inventoryItems.get(selectedItem);
				System.out.println(itemToUse.getName().toUpperCase() + " is selected");
				active = !active;
			}
		}
	}
	
	public void render(Graphics g){
		if(!active)
			return;
		
		// Draws inventory template
		g.drawImage(Assets.inventoryScreen, invX, invY, invWidth, invHeight, null);
		
		int len = inventoryItems.size();
		if(len == 0)
			return;
		
		//Displaying each item:
		for(int i = -5;i < 6;i++) {
			if(selectedItem + i < 0 || selectedItem + i >= len)
				continue;
			if(i == 0) {
				Text.drawString(handler, "> " + inventoryItems.get(selectedItem + i).getName() + " <", invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.YELLOW, Assets.font28);
			} else {
				Text.drawString(handler, inventoryItems.get(selectedItem + i).getName(), invListCenterX, 
						invListCenterY + i * invListSpacing, true, Color.WHITE, Assets.font28);
			}
		}
		
		Item item = inventoryItems.get(selectedItem);
		g.drawImage(item.getTexture(), invImageX, invImageY, invImageWidth, invImageHeight, null);
		Text.drawString(handler, Integer.toString(item.getCount()), invCountX, invCountY, true, Color.WHITE, Assets.font28);
	}
	
	
	// Inventory methods
	
	// Adds item to inventory
	public void addItem(Item item) {
		for(Item i : inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() + item.getCount());
				return;
			}
		}
		inventoryItems.add(item);
		System.out.println("You obtained a " + item.getName().toUpperCase());
		Assets.itemPickUp.playSound();
	}
	
	// Removes item from inventory
	public void removeItem(Item item) {
		for(Item i: inventoryItems) {
			if(i.getId() == item.getId()) {
				i.setCount(i.getCount() - item.getCount());
				System.out.println("You've used up a " + item.getName().toUpperCase());
				return;
			}
		}
	}
	
	
	// GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public boolean isActive() {
		return active;
	}

	public ArrayList<Item> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(ArrayList<Item> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}

	public Item getItemToUse() {
		return this.itemToUse;
	}

	public void setItemToUse(Item itemToUse) {
		this.itemToUse = itemToUse;
	}

}
