package escape_the_room.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	
	public static Tile[] tiles = new Tile[256];
	
	// TILES:
	
	public static Tile wallBottomTile = new WallBottomTile(0);
	public static Tile wallTile = new WallTile(1);
	public static Tile floorTile = new FloorTile(2);
	
	public static Tile ceilingRightTile = new CeilingRightTile(3);
	public static Tile ceilingLeftTile = new CeilingLeftTile(4);
	public static Tile ceilingTopTile = new CeilingTopTile(5);
	public static Tile ceilingBottomTile = new CeilingBottomTile(6);

	public static Tile ceilingBottomLeftCornerTile = new CeilingBottomLeftCornerTile(7);
	public static Tile ceilingTopRightCornerTile = new CeilingTopRightCornerTile(8);
	public static Tile ceilingBottomRightCornerTile = new CeilingBottomRightCornerTile(9);
	public static Tile ceilingTopLeftCornerTile = new CeilingTopLeftCornerTile(10);
	
	public static Tile blackSquareTile = new BlackSquareTile(11);
	
	public static Tile wallBottomTile2 = new WallBottomTile2(12);
	public static Tile wallTile2 = new WallTile2(13);
	public static Tile floorTile2 = new FloorTile2(14);
	
	public static Tile ceilingRightTile2 = new CeilingRightTile2(15);
	public static Tile ceilingLeftTile2 = new CeilingLeftTile2(16);
	public static Tile ceilingTopTile2 = new CeilingTopTile2(17);
	public static Tile ceilingBottomTile2 = new CeilingBottomTile2(18);

	public static Tile ceilingBottomLeftCornerTile2 = new CeilingBottomLeftCornerTile2(19);
	public static Tile ceilingTopRightCornerTile2 = new CeilingTopRightCornerTile2(20);
	public static Tile ceilingBottomRightCornerTile2 = new CeilingBottomRightCornerTile2(21);
	public static Tile ceilingTopLeftCornerTile2 = new CeilingTopLeftCornerTile2(22);
	
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int id;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getId() {
		return id;
	}

}