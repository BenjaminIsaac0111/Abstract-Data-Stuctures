package dataStructures;

import java.awt.Graphics;

/**
 * Extends the Stack class for graphical to output a visual version of the stack. 
 * @author Benjamin Wilson
 *
 */
public class StackGraphics extends Stack {
	//private String stackItemString;
	private boolean isFirstItem;

	/**
	 * Builds and paints stack items.
	 */
	public void paintStack(Graphics g) {
		buildStrings();
		isFirstItem = true;
		assembleStackBlocks(g);
	}

	/**
	 * 
	 */
	private void assembleStackBlocks(Graphics g) {
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			buildBlock(g);
			isFirstItem = drawFlagIfTopItem(g);
		}
	}

	/**
	 * Builds the block for each item in the stack.
	 */
//	private void buildStackBlock(Graphics g) {
//		g.drawString(itemString, x + 60, y + 16 - getStackPixelHeight());
//		g.drawRect(x, y - getStackPixelHeight(), 180, 32);
//		g.drawRect(x+2, y+2 - getStackPixelHeight(), 176, 28);
//	}

	/**
	 * Checks if the item is the top item to place a indicator(top->) next to it. 
	 */
	private boolean drawFlagIfTopItem(Graphics g) {
		if (isFirstItem) {
			drawFlag(g);
			isFirstItem = false;
		}
		return isFirstItem;
	}
	
	/**
	 * Returns the blocks y height * the size of the stack.
	 */
	private int getStackPixelHeight(){
		return 30 * getStackSize();
	}
}
