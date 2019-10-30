package escape_the_room.entities.statics;

import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.tiles.Tile;

public class SinkEmpty extends StaticEntity {

	public SinkEmpty(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
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
			g.drawImage(Assets.sinkEmpty, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
	}

	@Override
	public void interaction() {
		
		// All rooms : Changes sink to full
		handler.getRoomManager().getCurrentRoom().getSinKFull().setHidden(false);
		this.setInteractionComplete(true);
		this.setActive(false);
	}

}
