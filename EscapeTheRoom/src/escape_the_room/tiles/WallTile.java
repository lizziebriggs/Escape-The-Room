package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class WallTile extends Tile {

	public WallTile(int id) {
		super(Assets.wall, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}