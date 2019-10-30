package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class FloorTile extends Tile {

	public FloorTile(int id) {
		super(Assets.floor, id);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}