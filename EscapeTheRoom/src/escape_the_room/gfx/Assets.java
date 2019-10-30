package escape_the_room.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

import escape_the_room.audio.AudioPlayer;

public class Assets {
	
	private static final int width = 32, height = 32;
	
	// Number at end of name refers to font size
	public static Font font22;
	public static Font font28;
	public static Font font64;
	
	// Single image objects
	public static BufferedImage // Environment 1
								wallBottom, wall, floor, firePlaceOut, blackSquare,
								ceilingRight, ceilingLeft, ceilingTop, ceilingBottom,
								ceilingBottomLeftCorner, ceilingTopRightCorner, ceilingBottomRightCorner, ceilingTopLeftCorner,
								
								// Environment 2
								wallBottom2, wall2, floor2,
								ceilingRight2, ceilingLeft2, ceilingTop2, ceilingBottom2,
								ceilingBottomLeftCorner2, ceilingTopRightCorner2, ceilingBottomRightCorner2, ceilingTopLeftCorner2,
								
								// Entities								
								doorClosed, doorOpen,
								sinkWithoutHandle, sinkEmpty, sinkFull, 
								bedCovered, bedUncovered, closetClosed, closetOpen, chestClosed, chestOpen,
								
								// Items
								greenKey, redKey, blueKey, yellowKey,
								bucketEmpty, bucketFull, faucetHandle,
								
								// Player interaction
								player_selDown, player_selUp, player_selLeft, player_selRight;
	
	// Larger images
	public static BufferedImage inventoryScreen, menuBG;
	
	// Multiple image objects (animations)
	public static BufferedImage[] 	// Player animation
									player_down, player_up, player_left, player_right,
									
									// Buttons
									startButton, levelButton, exitButton, soundButton, menuButton, resumeButton,
									level1, level2,						
									
									// Entities
									firePlaceLit;
	
	// Audio 	
	public static AudioPlayer bgMusic, itemPickUp, inventorySelect; 
	
	
	public static void init() {
		
		//FONTS
		
		font22 = FontLoader.loadFont("res\\fonts\\slkscr.ttf", 22);
		font28 = FontLoader.loadFont("res\\fonts\\slkscr.ttf", 28);
		font64 = FontLoader.loadFont("res\\fonts\\slkscr.ttf", 64);
		
		
		// IMAGE SHEETS
		
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res\\sheets\\sheet.png"));
		SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("res\\sheets\\playerSheet.png"));
		SpriteSheet levelButtonSheet = new SpriteSheet(ImageLoader.loadImage("res\\sheets\\levelButtonSheet.png"));
		
		
		// LARGER IMAGES
		
		inventoryScreen = ImageLoader.loadImage("res\\sheets\\inventoryScreen.png");
		menuBG = ImageLoader.loadImage("res\\sheets\\menuBG.png");
		
		
		// SOUNDS
		
		bgMusic = new AudioPlayer("res\\sounds\\bgMusic.wav");
		itemPickUp = new AudioPlayer("res\\sounds\\itemPickUp.wav");
		inventorySelect = new AudioPlayer("res\\sounds\\inventorySelect.wav");
		
		
		// MENU
		
		startButton = new BufferedImage[2];
		startButton[0] = sheet.crop(width, height*5, width*2, height);
		startButton[1] = sheet.crop(width, height*6, width*2, height);
		
		levelButton = new BufferedImage[2];
		levelButton[0] = sheet.crop(width*11, height*4, width*2, height);
		levelButton[1] = sheet.crop(width*11, height*5, width*2, height);
		
		exitButton = new BufferedImage[2];
		exitButton[0] = sheet.crop(width*13, height*4, width*2, height);
		exitButton[1] = sheet.crop(width*13, height*5, width*2, height);
		
		menuButton = new BufferedImage[2];
		menuButton[0] = sheet.crop(width*13, height*6, width*2, height);
		menuButton[1] = sheet.crop(width*13, height*7, width*2, height);
		
		resumeButton = new BufferedImage[2];
		resumeButton[0] = sheet.crop(width*13, height*2, width*2, height);
		resumeButton[1] = sheet.crop(width*13, height*3, width*2, height);
		
		soundButton = new BufferedImage[2];
		soundButton[0] = sheet.crop(width*12, height*6, width, height);
		soundButton[1] = sheet.crop(width*12, height*7, width, height);
		
		
		//LEVELS
		
		level1 = new BufferedImage[2];
		level1[0] = levelButtonSheet.crop(0, 0, width, height);
		level1[1] = levelButtonSheet.crop(0, height, width, height);
		
		level2 = new BufferedImage[2];
		level2[0] = levelButtonSheet.crop(width, 0, width, height);
		level2[1] = levelButtonSheet.crop(width, height, width, height);
		
		
		// ENVIRONMENT 1
		
		wallBottom = sheet.crop(width * 6, 0, width, height);
		wall = sheet.crop(width * 6, height, width, height);
		floor = sheet.crop(width * 8, height * 3, width, height);
		blackSquare = sheet.crop(width * 8, height * 7, width, height);
		
		ceilingRight = sheet.crop(width * 6, height * 3, width, height);
		ceilingLeft = sheet.crop(width * 6, height * 2, width, height);
		ceilingTop = sheet.crop(width * 7, height * 2, width, height);
		ceilingBottom = sheet.crop(width * 7, height * 3, width, height);
		
		ceilingBottomLeftCorner = sheet.crop(width * 7, 0, width, height);
		ceilingTopRightCorner = sheet.crop(width * 8, 0, width, height);
		ceilingBottomRightCorner = sheet.crop(width * 8, height, width, height);
		ceilingTopLeftCorner = sheet.crop(width * 7, height, width, height);
		
		
		//ENVIRONMENT 2
		
		wall2 = sheet.crop(width * 10, 0, width, height);
		wallBottom2 = sheet.crop(width * 10, height, width, height);
		floor2 = sheet.crop(width * 12, height * 3, width, height);
		
		ceilingRight2 = sheet.crop(width * 10, height * 3, width, height);
		ceilingLeft2 = sheet.crop(width * 10, height * 2, width, height);
		ceilingTop2 = sheet.crop(width * 11, height * 2, width, height);
		ceilingBottom2 = sheet.crop(width * 11, height * 3, width, height);
		
		ceilingBottomLeftCorner2 = sheet.crop(width * 11, 0, width, height);
		ceilingTopRightCorner2 = sheet.crop(width * 12, 0, width, height);
		ceilingBottomRightCorner2 = sheet.crop(width * 12, height, width, height);
		ceilingTopLeftCorner2 = sheet.crop(width * 11, height, width, height);
		
		
		//ENTITIES
		
		doorClosed = sheet.crop(width * 9, 0, width, height * 2);
		doorOpen = sheet.crop(width * 9, height * 2, width, height * 2);
		
		greenKey = sheet.crop(0, height * 4, width, height);
		redKey = sheet.crop(width, height * 4, width, height);
		blueKey = sheet.crop(width * 2, height * 4, width, height);
		yellowKey = sheet.crop(0, height * 5, width, height);
		
		bucketEmpty = sheet.crop(width * 3, height * 6, width, height);
		bucketFull = sheet.crop(width * 3, height * 7, width, height);
		faucetHandle = sheet.crop(width * 8, height * 6, width, height);
		firePlaceLit = new BufferedImage[2];
		firePlaceLit[0] = sheet.crop(width * 6, height * 4, width * 2, height * 2);
		firePlaceLit[1] = sheet.crop(width * 6, height * 6, width * 2, height * 2);
		
		firePlaceOut = sheet.crop(width * 4, height * 6, width * 2, height * 2);
		
		sinkWithoutHandle = sheet.crop(width * 8, height * 4, width, height * 2);
		sinkEmpty = sheet.crop(width * 9, height * 4, width, height * 2);
		sinkFull = sheet.crop(width * 9, height * 6, width, height * 2);
		
		bedCovered = sheet.crop(width * 4, height * 2, width * 2, height * 2);
		bedUncovered = sheet.crop(width * 4, height * 4, width * 2, height * 2);
		
		closetClosed = sheet.crop(width * 3, height * 4, width, height * 2);
		closetOpen = sheet.crop(width * 4, 0, width * 2, height * 2);
		
		chestClosed = sheet.crop(width * 10, height * 4, width, height);
		chestOpen = sheet.crop(width * 10, height * 5, width, height);
		
		
		//PLAYER
		
		player_selDown = playerSheet.crop(width*4, 0, width, height);
		player_selRight = playerSheet.crop(width*4, height, width, height);
		player_selLeft = playerSheet.crop(width*4, height*2, width, height);
		player_selUp = playerSheet.crop(width*4, height*3, width, height);
		
		
		player_down = new BufferedImage[4];
		player_down[0] = playerSheet.crop(0, 0, width, height);
		player_down[1] = playerSheet.crop(width, 0, width, height);
		player_down[2] = playerSheet.crop(width*2, 0, width, height);
		player_down[3] = playerSheet.crop(width*3, 0, width, height);
		
		player_right = new BufferedImage[4];
		player_right[0] = playerSheet.crop(0, height, width, height);
		player_right[1] = playerSheet.crop(width, height, width, height);
		player_right[2] = playerSheet.crop(width*2, height, width, height);
		player_right[3] = playerSheet.crop(width*3, height, width, height);
		
		player_left = new BufferedImage[4];
		player_left[0] = playerSheet.crop(0, height*2, width, height);
		player_left[1] = playerSheet.crop(width, height*2, width, height);
		player_left[2] = playerSheet.crop(width*2, height*2, width, height);
		player_left[3] = playerSheet.crop(width*3, height*2, width, height);
		
		
		player_up = new BufferedImage[4];
		player_up[0] = playerSheet.crop(0, height*3, width, height);
		player_up[1] = playerSheet.crop(width, height*3, width, height);
		player_up[2] = playerSheet.crop(width*2, height*3, width, height);
		player_up[3] = playerSheet.crop(width*3, height*3, width, height);
	}

}
