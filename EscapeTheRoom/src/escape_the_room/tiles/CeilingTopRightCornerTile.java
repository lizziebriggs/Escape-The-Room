package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopRightCornerTile extends Tile {

	public CeilingTopRightCornerTile(int id) {
		super(Assets.ceilingTopRightCorner, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}