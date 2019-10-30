package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomTile2 extends Tile {

	public CeilingBottomTile2(int id) {
		super(Assets.ceilingBottom2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}