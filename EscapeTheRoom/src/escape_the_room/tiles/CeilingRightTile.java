package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingRightTile extends Tile {

	public CeilingRightTile(int id) {
		super(Assets.ceilingRight, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}