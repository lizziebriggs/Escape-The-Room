package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingLeftTile extends Tile {

	public CeilingLeftTile(int id) {
		super(Assets.ceilingLeft, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}