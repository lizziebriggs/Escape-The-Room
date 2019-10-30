package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.tiles.Tile;

public class DoorOpen extends StaticEntity {

	public DoorOpen(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
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
			g.drawImage(Assets.doorOpen, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void interaction() {
		System.out.println("It's open!");
		System.out.println("You've ESCAPED!");
		
		// Room 1 : Sets Room 2 as current
		if(handler.getRoomManager().getCurrentRoom() == handler.getGame().getRoom1()) {
			handler.getGame().getRoom1().setCurrent(false);
			handler.getGame().getRoom2().setCurrent(true);
		}
		
	}

}
