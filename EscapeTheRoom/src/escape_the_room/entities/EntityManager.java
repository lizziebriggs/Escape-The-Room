package escape_the_room.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import escape_the_room.Handler;
import escape_the_room.entities.creatures.Player;


public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	
	// Evaluates whether an entity should be rendered on top of the other or not
	private Comparator<Entity> renderSorter = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	
	public EntityManager(Handler handler, Player player) {
		
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
	}
	
	public void tick() {
		
		Iterator<Entity> iterator = entities.iterator();
		
		// Ticks each entity in list
		while(iterator.hasNext()){
			Entity e = iterator.next();
			e.tick();
			
			// Removes entity if it is not active
			if(!e.isActive())
				iterator.remove();
		}
		entities.sort(renderSorter);
	}
	
	public void render(Graphics g) {
		
		for(Entity e : entities){
			e.render(g);
		}
		
		// Renders player last so it appears on top of entities
		player.postRender(g);
	}
	
	// Adds entity to list
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	
	//GETTERS AND SETTERS

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
