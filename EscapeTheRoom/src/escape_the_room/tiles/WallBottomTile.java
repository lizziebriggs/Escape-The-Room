package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class WallBottomTile extends Tile {

	public WallBottomTile(int id) {
		super(Assets.wallBottom, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}