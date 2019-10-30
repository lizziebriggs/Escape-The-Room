package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class FloorTile2 extends Tile {

	public FloorTile2(int id) {
		super(Assets.floor2, id);
	}
	
	@Override
	public boolean isSolid(){
		return false;
	}

}