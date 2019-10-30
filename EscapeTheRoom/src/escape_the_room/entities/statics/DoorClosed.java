package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class DoorClosed extends StaticEntity {

	public DoorClosed(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH, interactionComplete, hidden, inventory);
		
		//Bounding box
		bounds.x = 0;
		bounds.y = (int) (height / height);
		bounds.width = width;
		bounds.height = (int) (height - 20f);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		if(!hidden)
			g.drawImage(Assets.doorClosed, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void interaction() {
		
		// All rooms : Needs Yellow Key
		if(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse() != null && handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse().getId() == Item.yellowKeyItem.getId()) {
			
			System.out.println("You unlocked the DOOR");

			handler.getRoomManager().getCurrentRoom().getDoorOpen().setHidden(false);
			this.setInteractionComplete(true);
			this.setActive(false);
			
		} else {
			System.out.println("It's locked!");
			System.out.println("You need a " + Item.yellowKeyItem.getName().toUpperCase());
		}
		
	}

}
