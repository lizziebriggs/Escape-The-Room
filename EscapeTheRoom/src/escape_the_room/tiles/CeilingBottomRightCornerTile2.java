package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomRightCornerTile2 extends Tile {

	public CeilingBottomRightCornerTile2(int id) {
		super(Assets.ceilingBottomRightCorner2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}