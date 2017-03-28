package dataStructures;

import java.awt.Graphics;

public class dataStructureGraphics {

	private static int x = 360;
	private static int y = 360;
	
	
	private boolean isFirstItem;
	private String blockFlag;
	protected String itemString;
	
	
	protected static int getX() {
		return x;
	}

	protected static void setX(int x) {
		dataStructureGraphics.x = x;
	}

	protected static int getY() {
		return y;
	}

	protected static void setY(int y) {
		dataStructureGraphics.y = y;
	}

	protected String getItemString() {
		return itemString;
	}

	protected void setItemString(String itemString) {
		this.itemString = itemString;
	}


	/**
	 * Builds the block for each item in the stack.
	 */
	protected void buildBlock(Graphics g) {
		try {
			g.drawString(itemString, x + 60, y + 16);
			g.drawRect(x, y, 180, 32);
			g.drawRect(x+2, y+2, 176, 28);
		} catch (Exception e) {
			
		}

	}
	
	/**
	 * Checks if the item is the top item to place a indicator(top->) next to it. 
	 */
	protected boolean drawFlag(Graphics g) {
		
		if (isFirstItem) {
			g.drawString(blockFlag +"->", x - 30, y + 22);
			isFirstItem = false;
		}
		return isFirstItem;
	}
	
	
}
