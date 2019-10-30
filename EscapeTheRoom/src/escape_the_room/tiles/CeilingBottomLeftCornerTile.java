package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomLeftCornerTile extends Tile {

	public CeilingBottomLeftCornerTile(int id) {
		super(Assets.ceilingBottomLeftCorner, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}