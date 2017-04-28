package dataStructures;

import java.awt.Graphics;

public class SetGraphics extends Set {
	
	protected static int x;
	protected static int y;

	/**
	 * Sets coordinates using x,y.
	 * @param y 
	 * @param x 
	 */
	public void setGraphicsCoordinates(int x, int y) {
		SetGraphics.x = x;
		SetGraphics.y = y;
	}

	/**
	 *  Paints items in the structure.
	 */
	public void paint(Graphics g) {
		assembleBlocks(g);
	}

	/**
	 * Builds the stack with graphics.
	 */
	protected void assembleBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(240 ,480);
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
