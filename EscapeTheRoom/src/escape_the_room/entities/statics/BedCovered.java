package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class BedCovered extends StaticEntity {

	public BedCovered(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH * 2, interactionComplete, hidden, inventory);
		
		//Bounding box
		bounds.x = 10;
		bounds.y = (int) (height / height);
		bounds.width = width;
		bounds.height = (int) (height);
	}

	@Override
	public void tick() {
			
	}

	@Override
	public void render(Graphics g) {
		if(!hidden)
			g.drawImage(Assets.bedCovered, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	@Override
	public void interaction() {
		handler.getRoomManager().getCurrentRoom().getBedUncovered().setHidden(false);
		
		// Room 1 : Gives Red Key
		if(handler.getRoomManager().getCurrentRoom() == handler.getGame().getRoom1()) {	
			handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.redKeyItem.createNewNotPickedUp((int) x - (width / 2), (int) y + (height / 2)));
			
		// Room 2 : Gives Blue Key
		} else if(handler.getRoomManager().getCurrentRoom() == handler.getGame().getRoom2()) {
			handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.blueKeyItem.createNewNotPickedUp((int) x - (width / 2), (int) y + (height / 2)));
		}
		
		this.setInteractionComplete(true);
		this.setActive(false);
	}

}
