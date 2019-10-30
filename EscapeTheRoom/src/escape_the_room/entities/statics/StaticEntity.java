package escape_the_room.entities.statics;

import escape_the_room.Handler;
import escape_the_room.entities.Entity;
import escape_the_room.inventory.Inventory;

public abstract class StaticEntity extends Entity {

	public StaticEntity(Handler handler, float x, float y, int height, int width, boolean interactionComplete, boolean hidden, Inventory inventory){
		super(handler, x, y, height, width, interactionComplete, hidden, inventory);
	}

}
