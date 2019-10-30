package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomRightCornerTile extends Tile {

	public CeilingBottomRightCornerTile(int id) {
		super(Assets.ceilingBottomRightCorner, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}