 package escape_the_room;

import escape_the_room.gfx.GameCamera;
import escape_the_room.input.KeyManager;
import escape_the_room.input.MouseManager;
import escape_the_room.rooms.RoomManager;

public class Handler {
	
	private Game game;
	
	
	// GETTERS AND SETTERS
	
	public Handler(Game game){
		this.game = game;
	}
	
	public GameCamera getGameCamera(){
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager(){
		return game.getKeyManager();
	}
	
	public MouseManager getMouseManager(){
		return game.getMouseManager();
	}
	
	public RoomManager getRoomManager() {
		return game.getRoomManager();
	}
	
	public int getWidth(){
		return game.getWidth();
	}
	
	public int getHeight(){
		return game.getHeight();
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
