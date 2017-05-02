package dataStructures;

import java.awt.Graphics;

public class ListGraphics extends MyList<String> {
	protected static int x;
	protected static int y;

	/**
	 * Sets coordinates using x,y.
	 * @param y 
	 * @param x 
	 */
	public void setGraphicsCoordinates(int x, int y) {
		ListGraphics.x = x;
		ListGraphics.y = y;
	}

	/**
	 *  Paints items in the structure.
	 */
	public void paint(Graphics g) {
		assembleBlocks(g);
	}

	/**
	 * Builds graphics.
	 */
	protected void assembleBlocks(Graphics g) {
		buildStrings();
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			buildBlock(g);
			y = y + 30;
		}
	}

	/**
	 * Builds the structure with graphics.
	 */
	protected void buildBlock(Graphics g) {
		buildBlock(g, x, yPixelHeightOffset());
	}
	


	protected int yPixelHeightOffset() {
		return y - getPixelHeight();
	}
	
	/**
	 * Returns the blocks y height * the size of the Structure.
	 */
	protected int getPixelHeight(){
		return 30 * getSize();
	} 
}
