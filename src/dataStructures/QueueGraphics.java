package dataStructures;

import java.awt.Graphics;

/**
 * Extends the Stack class for graphical to output a visual version of the stack. 
 * @author Benjamin Wilson
 *
 */
public class QueueGraphics extends Queue {

	protected static int x;
	protected static int y;

	/**
	 * Sets coordinates using x,y.
	 * @param y 
	 * @param x 
	 */
	private void setGraphicsCoordinates(int x, int y) {
		QueueGraphics.x = x;
		QueueGraphics.y = y;
	}


	public void paint(Graphics g) {
		assembleBlocks(g);
	}


	protected void assembleBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(240 ,480);
		drawFlags = true;
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			if (drawFlags) {
				drawHeadItemFlag(g);
				drawTailItemFlag(g);
			}
			buildBlock(g);
			y = y + 30;
		}
	}

	/**
	 * Checks if the item is the "Head" item to place a indicator(Head->) next to it. 
	 */
	private void drawHeadItemFlag(Graphics g) {
			setBlockFlag("Head");
			drawFlag(g, x - 40,  yPixelHeightOffset() + 10);
			drawFlags = false;
	}
	
	protected int yPixelHeightOffset() {
		return y - getPixelHeight();
	}
	
	private void drawTailItemFlag(Graphics g) {
		setBlockFlag("Tail");
		drawFlag(g, x - 35,  y);
	}
	

}
