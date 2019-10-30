package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopRightCornerTile2 extends Tile {

	public CeilingTopRightCornerTile2(int id) {
		super(Assets.ceilingTopRightCorner2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}