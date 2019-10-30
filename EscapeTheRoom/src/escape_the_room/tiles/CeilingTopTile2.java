package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class CeilingTopTile2 extends Tile {

	public CeilingTopTile2(int id) {
		super(Assets.ceilingTop2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}