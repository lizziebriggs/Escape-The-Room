package escape_the_room.rooms;

import java.awt.Color;
import java.awt.Graphics;

import escape_the_room.Handler;
import escape_the_room.entities.EntityManager;
import escape_the_room.entities.creatures.Player;
import escape_the_room.entities.statics.BedCovered;
import escape_the_room.entities.statics.BedUncovered;
import escape_the_room.entities.statics.ChestClosed;
import escape_the_room.entities.statics.ChestOpen;
import escape_the_room.entities.statics.ClosetClosed;
import escape_the_room.entities.statics.ClosetOpen;
import escape_the_room.entities.statics.DoorClosed;
import escape_the_room.entities.statics.DoorOpen;
import escape_the_room.entities.statics.FirePlaceLit;
import escape_the_room.entities.statics.FirePlaceOut;
import escape_the_room.entities.statics.SinkEmpty;
import escape_the_room.entities.statics.SinkFull;
import escape_the_room.entities.statics.SinkWithoutHandle;
import escape_the_room.gfx.Assets;
import escape_the_room.gfx.Text;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.ItemManager;
import escape_the_room.tiles.Tile;
import escape_the_room.utils.Utils;

public abstract class Room {
	
	protected int width, height; //Measurement = tiles (i.e. 5x5 = 5 tiles by 5 tiles)
	private int[][] tiles;
	private int spawnX, spawnY;
	
	protected Handler handler;
	
	protected ItemManager itemManager;
	protected EntityManager entityManager;
	
	protected Inventory inventory;
	
	protected boolean isCurrent = false;
	
	//ENTITIES
	protected ClosetClosed closetClosed;
	protected ClosetOpen closetOpen;
	protected ChestClosed chestClosed;
	protected ChestOpen chestOpen;
	protected BedCovered bedCovered;
	protected BedUncovered bedUncovered;
	protected FirePlaceLit firePlaceLit;
	protected FirePlaceOut firePlaceOut;
	protected SinkWithoutHandle sinkWithoutHandle;
	protected SinkEmpty sinkEmpty;
	protected SinkFull sinKFull;
	protected DoorClosed doorClosed;
	protected DoorOpen doorOpen;
	
	
	
	public Room(Handler handler, String path){
		this.handler = handler;
		
		this.inventory = new Inventory(handler);
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100, true, false, inventory));
		itemManager = new ItemManager(handler);
		
		loadRoom(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g) {
		
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);
		
		// Draws tiles
		for(int y = yStart; y < yEnd; y++){
			for(int x = xStart; x < xEnd; x++){
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), 
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		// Items
		itemManager.render(g);
		
		// Entities
		entityManager.render(g);
		
		// User instructions
		Text.drawString(handler, "WASD = Move", 48, 688, false, Color.YELLOW, Assets.font22);
		Text.drawString(handler, "E = Inventory", 268, 688, false, Color.YELLOW, Assets.font22);
		Text.drawString(handler, "Arrows = Interact", 488, 688, false, Color.YELLOW, Assets.font22);
		
	}

	// Gets tile
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) //Prevents errors
			return Tile.floorTile;
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null)
			return Tile.floorTile; //Default tile for when no tile is found
		return t;
	}

	// Takes string from file and turns to integer
	public void loadRoom(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}
	
	
	// GETTERS AND SETTERS
	
	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public ItemManager getItemManager() {
		return itemManager;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public boolean isCurrent() {
		return isCurrent;
	}

	public void setCurrent(boolean isCurrent) {
		this.isCurrent = isCurrent;
	}
	
	
	
	// ENTITIES


	public BedCovered getBedCovered() {
		return bedCovered;
	}

	public void setBedCovered(BedCovered bedCovered) {
		this.bedCovered = bedCovered;
	}

	public BedUncovered getBedUncovered() {
		return bedUncovered;
	}

	public void setBedUncovered(BedUncovered bedUncovered) {
		this.bedUncovered = bedUncovered;
	}

	public ClosetClosed getClosetClosed() {
		return closetClosed;
	}

	public void setClosetClosed(ClosetClosed closetClosed) {
		this.closetClosed = closetClosed;
	}

	public ClosetOpen getClosetOpen() {
		return closetOpen;
	}

	public void setClosetOpen(ClosetOpen closetOpen) {
		this.closetOpen = closetOpen;
	}

	public ChestClosed getChestClosed() {
		return chestClosed;
	}

	public void setChestClsoed(ChestClosed chestClosed) {
		this.chestClosed = chestClosed;
	}

	public ChestOpen getChestOpen() {
		return chestOpen;
	}

	public void setChestOpen(ChestOpen chestOpen) {
		this.chestOpen = chestOpen;
	}

	public FirePlaceLit getFirePlaceLit() {
		return firePlaceLit;
	}

	public void setFirePlaceLit(FirePlaceLit firePlaceLit) {
		this.firePlaceLit = firePlaceLit;
	}

	public FirePlaceOut getFirePlaceOut() {
		return firePlaceOut;
	}

	public void setFirePlaceOut(FirePlaceOut firePlaceOut) {
		this.firePlaceOut = firePlaceOut;
	}

	public SinkWithoutHandle getSinkWithoutHandle() {
		return sinkWithoutHandle;
	}

	public void setSinkWithoutHandle(SinkWithoutHandle sinkWithoutHandle) {
		this.sinkWithoutHandle = sinkWithoutHandle;
	}

	public SinkEmpty getSinkEmpty() {
		return sinkEmpty;
	}

	public void setSinkEmpty(SinkEmpty sinkEmpty) {
		this.sinkEmpty = sinkEmpty;
	}

	public SinkFull getSinKFull() {
		return sinKFull;
	}

	public void setSinKFull(SinkFull sinKFull) {
		this.sinKFull = sinKFull;
	}

	public DoorClosed getDoorClosed() {
		return doorClosed;
	}

	public void setDoorClosed(DoorClosed doorClosed) {
		this.doorClosed = doorClosed;
	}

	public DoorOpen getDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(DoorOpen doorOpen) {
		this.doorOpen = doorOpen;
	}

}