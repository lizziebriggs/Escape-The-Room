package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingRightTile2 extends Tile {

	public CeilingRightTile2(int id) {
		super(Assets.ceilingRight2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}