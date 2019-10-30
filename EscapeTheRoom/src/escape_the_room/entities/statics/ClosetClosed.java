package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class ClosetClosed extends StaticEntity {

	public ClosetClosed(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, interactionComplete, hidden, inventory);
		
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
			g.drawImage(Assets.closetClosed, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void interaction(){
		
		// Room 1 : Needs Red Key, Gives Faucet Handle
		if(handler.getRoomManager().getCurrentRoom() == handler.getGame().getRoom1()) {
			if(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse() != null && handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse().getId() == Item.redKeyItem.getId()) {
			
				System.out.println("You've unlocked the CLOSET!");
			
				handler.getRoomManager().getCurrentRoom().getInventory().getInventoryItems().remove(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse());
				handler.getRoomManager().getCurrentRoom().getClosetOpen().setHidden(false);
				handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.faucetHandleItem.createNewNotPickedUp((int) x, (int) y + height));
			
				this.setInteractionComplete(true);
				this.setActive(false);
			
			} else {
				System.out.println("You need a " + Item.redKeyItem.getName().toUpperCase());
			}
		}
		
	}

}
