package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomLeftCornerTile2 extends Tile {

	public CeilingBottomLeftCornerTile2(int id) {
		super(Assets.ceilingBottomLeftCorner2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}