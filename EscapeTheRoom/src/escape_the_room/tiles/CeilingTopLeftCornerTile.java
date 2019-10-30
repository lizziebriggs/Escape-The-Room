package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopLeftCornerTile extends Tile {

	public CeilingTopLeftCornerTile(int id) {
		super(Assets.ceilingTopLeftCorner, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}