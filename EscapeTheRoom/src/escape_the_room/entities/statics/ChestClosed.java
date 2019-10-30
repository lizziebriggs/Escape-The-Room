package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class ChestClosed extends StaticEntity {

	public ChestClosed(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT, Tile.TILEWIDTH, interactionComplete, hidden, inventory);
		
		//Bounding box
		bounds.x = 5;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width;
		bounds.height = (int) (height - height / 1.1f);
	}
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(!hidden)
			g.drawImage(Assets.chestClosed, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void interaction(){
		
		// Room 2 : Needs Blue Key, Gives Faucet Handle
		if(handler.getRoomManager().getCurrentRoom() == handler.getGame().getRoom2()) {
			if(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse() != null && handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse().getId() == Item.blueKeyItem.getId()) {
			
				System.out.println("You've unlocked the CHEST!");
			
				handler.getRoomManager().getCurrentRoom().getInventory().getInventoryItems().remove(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse());
				handler.getRoomManager().getCurrentRoom().getChestOpen().setHidden(false);
				handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.faucetHandleItem.createNewNotPickedUp((int) x + width, (int) y + height ));
			
				this.setInteractionComplete(true);
				this.setActive(false);
			
			} else {
				System.out.println("You need a " + Item.blueKeyItem.getName().toUpperCase());
			}
		}
		
	}

}
