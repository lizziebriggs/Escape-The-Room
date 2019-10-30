package escape_the_room.rooms;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import escape_the_room.Handler;

public class RoomManager {
	
	private Handler handler;
	private ArrayList<Room> rooms;

	public RoomManager(Handler handler) {
		
		this.handler = handler;
		this.rooms = new ArrayList<Room>();
	}
	
	public void tick() {
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext()) {
			Room r = iterator.next();
			if(r.isCurrent)
				r.tick();
		}
	}
	
	public void render(Graphics g) {
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext()) {
			Room r = iterator.next();
			if(r.isCurrent) {
				r.render(g);
			}
		}
	}
	
	public void addRoom(Room r) {
		rooms.add(r);
	}
	
	
	//GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Room getCurrentRoom() {
		Iterator<Room> iterator = rooms.iterator();
		while(iterator.hasNext()) {
			Room r = iterator.next();
			if(r.isCurrent)
				return r;
		}
		return null;
	}

}