package escape_the_room.states;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import escape_the_room.Handler;
import escape_the_room.entities.EntityManager;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.ItemManager;
import escape_the_room.rooms.Room1;
import escape_the_room.rooms.Room2;

public class GameState extends State {
	
	private ItemManager itemManager;
	private Inventory inventory;
	private EntityManager entityManager;
	
	//Rooms
	private Room1 room1;
	private Room2 room2;
	
	public GameState(Handler handler){
		super(handler);
		
		// Create rooms:
		
		room1 = new Room1(handler, "res\\rooms\\room1.txt");
		handler.getGame().setRoom1(room1);
		handler.getRoomManager().addRoom(handler.getGame().getRoom1());
		
		room2 = new Room2(handler, "res\\rooms\\room2.txt");
		handler.getGame().setRoom2(room2);
		handler.getRoomManager().addRoom(handler.getGame().getRoom2());
		
	}

	@Override
	public void tick() {

		// Checks if pause menu has been activated
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_ESCAPE))
			State.setCurrentState(handler.getGame().pauseGameState);
		else
			handler.getRoomManager().tick();
	}

	@Override
	public void render(Graphics g) {
		
		if(State.getCurrentState() == handler.getGame().pauseGameState)
			handler.getGame().pauseGameState.render(g);
		else
			handler.getRoomManager().render(g);
	}
	
	
	//GETTERS AND SETTERS

	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Room1 getRoom1() {
		return room1;
	}

	public void setRoom1(Room1 room1) {
		this.room1 = room1;
	}

	public Room2 getRoom2() {
		return room2;
	}

	public void setRoom2(Room2 room2) {
		this.room2 = room2;
	}

}