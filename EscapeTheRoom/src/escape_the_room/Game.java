package escape_the_room;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import escape_the_room.display.Display;
import escape_the_room.gfx.Assets;
import escape_the_room.gfx.GameCamera;
import escape_the_room.input.KeyManager;
import escape_the_room.input.MouseManager;
import escape_the_room.rooms.Room1;
import escape_the_room.rooms.Room2;
import escape_the_room.rooms.RoomManager;
import escape_the_room.states.GameState;
import escape_the_room.states.LevelsState;
import escape_the_room.states.MenuState;
import escape_the_room.states.PauseGameState;
import escape_the_room.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	public String title;

	private boolean running = false;
	private Thread thread;

	private BufferStrategy bs;
	private Graphics g;

	// States
	public State gameState;
	public State menuState;
	public State levelsState;
	public State pauseGameState;

	// Input
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	//Rooms
	private RoomManager roomManager;
	private Room1 room1;
	private Room2 room2;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	public Game(String title, int width, int height) {

		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
		roomManager = new RoomManager(handler);
	}

	private void init() {
		
		// Creating display
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();

		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		
		Assets.bgMusic.playSoundLoop();
		
		// Initiating states
		gameState = new GameState(handler);
		levelsState = new LevelsState(handler);
		menuState = new MenuState(handler);
		pauseGameState = new PauseGameState(handler);
		State.setCurrentState(menuState);
	}

	private void tick() {
		
		keyManager.tick();

		if (State.getCurrentState() != null)
			State.getCurrentState().tick();
	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = bs.getDrawGraphics();
		
		// Clears Screen
		g.clearRect(0, 0, width, height);
		
		if (State.getCurrentState() != null)
			State.getCurrentState().render(g);

		bs.show();
		g.dispose();

	}

	public void run() {

		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
			if (timer >= 1000000000) {
				timer = 0;
			}
		}
		
		stop();
	}

	public synchronized void start() {
		
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	// GETTERS AND SETTERS

	public Display getDisplay() {
		return display;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Graphics getG() {
		return g;
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public MouseManager getMouseManager() {
		return mouseManager;
	}
	
	public RoomManager getRoomManager() {
		return roomManager;
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

	public GameCamera getGameCamera() {
		return gameCamera;
	}
}
