package escape_the_room.entities.statics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import escape_the_room.Handler;
import escape_the_room.gfx.Animation;
import escape_the_room.gfx.Assets;
import escape_the_room.inventory.Inventory;
import escape_the_room.items.Item;
import escape_the_room.tiles.Tile;

public class FirePlaceLit extends StaticEntity {
	
	private Animation fire;

	public FirePlaceLit(Handler handler, float x, float y, boolean interactionComplete, boolean hidden, Inventory inventory) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH * 2, interactionComplete, hidden, inventory);
		
		//Bounding box
		bounds.x = 0;
		bounds.y = (int) (height / height);
		bounds.width = width;
		bounds.height = (int) (height);
		
		fire = new Animation(300, Assets.firePlaceLit);
	}

	@Override
	public void tick() {
		fire.tick();
	}

	@Override
	public void render(Graphics g) {
		
		if(!hidden)	{
			g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		}
			
	}
	
	private BufferedImage getCurrentAnimationFrame(){
		return fire.getCurrentFrame();
	}

	@Override
	public void interaction() {
		
		// All rooms : Needs Full Bucket, Gives Yellow Key
		if(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse() != null && handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse().getId() == Item.bucketFullItem.getId()) {
			
			System.out.println("You put out the FIREPLACE");
			handler.getRoomManager().getCurrentRoom().getInventory().getInventoryItems().remove(handler.getRoomManager().getCurrentRoom().getInventory().getItemToUse());
			handler.getRoomManager().getCurrentRoom().getFirePlaceOut().setHidden(false);
			handler.getRoomManager().getCurrentRoom().getItemManager().addItem(Item.yellowKeyItem.createNewNotPickedUp((int) x, (int) y + (height + 30)));
			
			this.setInteractionComplete(true);
			this.setActive(false);
			
		} else {
			System.out.println("You need a " + Item.bucketFullItem.getName().toUpperCase());
		}
		
	}

}
