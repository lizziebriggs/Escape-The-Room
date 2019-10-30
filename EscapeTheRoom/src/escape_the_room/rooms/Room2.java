package escape_the_room.rooms;

import escape_the_room.Handler;
import escape_the_room.entities.EntityManager;
import escape_the_room.entities.statics.BedCovered;
import escape_the_room.entities.statics.BedUncovered;
import escape_the_room.entities.statics.ChestClosed;
import escape_the_room.entities.statics.ChestOpen;
import escape_the_room.entities.statics.DoorClosed;
import escape_the_room.entities.statics.DoorOpen;
import escape_the_room.entities.statics.FirePlaceLit;
import escape_the_room.entities.statics.FirePlaceOut;
import escape_the_room.entities.statics.SinkEmpty;
import escape_the_room.entities.statics.SinkFull;
import escape_the_room.entities.statics.SinkWithoutHandle;
import escape_the_room.items.Item;

public class Room2 extends Room {
	

	public Room2(Handler handler, String path) {
		super(handler, path);
		
		// Add entities here:
		// Parameters: handler,  x,  y,  height,  width,  interactionComplete,  hidden,  inventory
		
		this.chestClosed = new ChestClosed(handler, 470, 232, false, false, inventory);
		entityManager.addEntity(chestClosed);
		
		this.chestOpen = new ChestOpen(handler, 470, 232, true, true, inventory);
		entityManager.addEntity(chestOpen);
		
		this.bedCovered = new BedCovered(handler, 300, 512, false, false, inventory);
		entityManager.addEntity(bedCovered);
		
		this.bedUncovered = new BedUncovered(handler, 300, 512, true, true, inventory);
		entityManager.addEntity(this.bedUncovered);
		
		this.firePlaceLit = new FirePlaceLit(handler, 310, 200, false, false, inventory);
		entityManager.addEntity(this.firePlaceLit);
		
		this.firePlaceOut = new FirePlaceOut(handler, 310, 200, true, true, inventory);
		entityManager.addEntity(this.firePlaceOut);
		
		this.sinkWithoutHandle = new SinkWithoutHandle(handler, 702, 500, false, false, inventory);
		entityManager.addEntity(this.sinkWithoutHandle);
		
		this.sinkEmpty = new SinkEmpty(handler, 702, 500, false, true, inventory);
		entityManager.addEntity(this.sinkEmpty);
		
		this.sinKFull = new SinkFull(handler, 702, 500, false, true, inventory);
		entityManager.addEntity(this.sinKFull);
		
		this.doorClosed = new DoorClosed(handler, 200, 130, false, false, inventory);
		entityManager.addEntity(this.doorClosed);
		
		this.doorOpen = new DoorOpen(handler, 200, 130, false, true, inventory);
		entityManager.addEntity(this.doorOpen);
		
		itemManager.addItem(Item.bucketEmptyItem.createNewNotPickedUp(100, 502));
	}
		
		
	// GETTERS AND SETTERS
		
	public int getWidth() {
		return width;
	}
		
	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
		
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

}