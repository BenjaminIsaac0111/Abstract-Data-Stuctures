package dataStructures;

import java.awt.Graphics;

/**
 * Extends the Stack class for graphical to output a visual version of the stack. 
 * @author Benjamin Wilson
 * @param <T>
 *
 */
public class ListGraphics<T> extends ListDriver {
	//private String stackItemString;
	private boolean drawHeadAndTail;

	
	protected static int x;
	protected static int y;

	/**
	 * Sets coordinates using x,y.
	 * @param y 
	 * @param x 
	 */
	private void setGraphicsCoordinates(int x, int y) {
		ListGraphics.x = x;
		ListGraphics.y = y;
	}

	/**
	 * Builds and paints stack items.
	 */
	public void paintList(Graphics g) {
		//assembleListBlocks(g);
	}

	/**
	 * Builds the stack with graphics.
	 */
	private void assembleListBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(240 ,480);
		drawHeadAndTail = true;
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			if (drawHeadAndTail) {
				drawHeadItemFlag(g);
				drawTailItemFlag(g);
				drawHeadAndTail = false;
			}
			buildListBlock(g);
			y = y + 30;
		}
	}

	/**
	 * Builds the block for each item in the stack.
	 */
	private void buildListBlock(Graphics g) {
		buildBlock(g, x, y - getPixelHeight());
	}

	/**
	 * Checks if the item is the top item to place a indicator(top->) next to it. 
	 */
	private void drawHeadItemFlag(Graphics g) {
		setBlockFlag("Head");
		drawFlag(g, x - 35, y + 22 - getPixelHeight());
	}
	
	private void drawTailItemFlag(Graphics g) {
		setBlockFlag("Tail");
		drawFlag(g, x - 35, y + 22);
	}
	
	/**
	 * Returns the blocks y height * the size of the stack.
	 */
	private int getPixelHeight(){
		return 30 * getSize();
	}
}
