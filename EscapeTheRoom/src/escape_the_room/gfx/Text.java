package escape_the_room.gfx;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import escape_the_room.Handler;

public class Text {
	
	private static Graphics g;
	
	// Draws text to canvas
	public static void drawString(Handler handler, String text, int xPos, int yPos, boolean center, Color c, Font font) {
		g = handler.getGame().getG();
		g.setColor(c);
		g.setFont(font);
		int x = xPos;
		int y = yPos;
		if(center) {
			FontMetrics fm = g.getFontMetrics(font);
			x = xPos - fm.stringWidth(text) / 2;
			y = (yPos - fm.getHeight() / 2) + fm.getAscent();
		}
		g.drawString(text, x, y);
	}

}
