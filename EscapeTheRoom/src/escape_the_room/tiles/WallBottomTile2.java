package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class WallBottomTile2 extends Tile {

	public WallBottomTile2(int id) {
		super(Assets.wallBottom2, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}