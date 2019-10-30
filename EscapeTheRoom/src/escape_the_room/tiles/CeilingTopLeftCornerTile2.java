package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopLeftCornerTile2 extends Tile {

	public CeilingTopLeftCornerTile2(int id) {
		super(Assets.ceilingTopLeftCorner2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}