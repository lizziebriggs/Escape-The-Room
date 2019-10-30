package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class SinkFull extends StaticEntity {

	public SinkFull(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, interactionComplete, hidden, inventory);
		
		//Bounding box
		bounds.x = (int) 50f;
		bounds.y = (int) (height - 85f);
		bounds.width = (int) (width - 60f);
		bounds.height = (int) (height - 80f);
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(!hidden)
			g.drawImage(Assets.sinkFull, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void interaction() {
		
		// All rooms : Needs Empty Bucket, Gives Filled Bucket
		if(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse() != null && handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse().getId() == Item.bucketEmptyItem.getId()) {
			
			System.out.println("You filled up the BUCKET");
			
			handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.bucketFullItem.createNewNotPickedUp((int) (x - 30), (int) y + (height - 5)));
			handler.getRoomManager().getCurrentRoom().getInventory().getInventoryItems().remove(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse());
			
			this.setInteractionComplete(true);
			
		} else {
			System.out.println("You need a " + Item.bucketEmptyItem.getName().toUpperCase());
		}
		
	}

}
