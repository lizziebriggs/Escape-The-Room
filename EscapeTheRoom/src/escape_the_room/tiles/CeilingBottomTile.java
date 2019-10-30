package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingBottomTile extends Tile {

	public CeilingBottomTile(int id) {
		super(Assets.ceilingBottom, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}