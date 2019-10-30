package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopTile extends Tile {

	public CeilingTopTile(int id) {
		super(Assets.ceilingTop, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}