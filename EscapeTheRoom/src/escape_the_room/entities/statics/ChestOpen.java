package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.tiles.Tile;

public class ChestOpen extends StaticEntity {

	public ChestOpen(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
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
			g.drawImage(Assets.chestOpen, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	@Override
	public void interaction(){
		// Has no interaction
	}

}
