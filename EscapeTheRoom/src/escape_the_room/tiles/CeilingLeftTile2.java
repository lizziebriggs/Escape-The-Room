package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingLeftTile2 extends Tile {

	public CeilingLeftTile2(int id) {
		super(Assets.ceilingLeft2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}