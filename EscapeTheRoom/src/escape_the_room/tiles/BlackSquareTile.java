package escape_the_room.tiles;

import escape_the_room.gfx.Assets;

public class BlackSquareTile extends Tile {

	public BlackSquareTile(int id) {
		super(Assets.blackSquare, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}