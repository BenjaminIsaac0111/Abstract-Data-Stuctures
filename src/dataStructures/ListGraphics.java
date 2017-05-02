package dataStructures;

import java.awt.Graphics;

public class ListGraphics extends MyList<String> {
	protected static int x;
	protected static int y;
	String index = "0";

	public void setGraphicsCoordinates(int x, int y) {
		ListGraphics.x = x;
		ListGraphics.y = y;
	}


	public void paint(Graphics g) {
		assembleBlocks(g);
	}


	protected void assembleBlocks(Graphics g) {
		buildStrings();
		setGraphicsCoordinates(100, 480);
		while (stringsToPrint.hasNext()) {
			setItemString(stringsToPrint.next());
			
		
			buildBlock(g);
			y = y + 30;
		}
		setGraphicsCoordinates(100, 480);
		
		for(int i = 0; i < getSize(); i++){
			index = Integer.toString(i);
			drawIndexFlag(g);
			y = y + 30;
		}
		
	}

	protected void buildBlock(Graphics g) {
		buildBlock(g, x, yPixelHeightOffset());
	}
	

	protected int yPixelHeightOffset() {
		return y - getPixelHeight();
	}

	protected int getPixelHeight(){
		return 30 * getSize();
	} 
	
	
	private void drawIndexFlag(Graphics g) {
		setBlockFlag(index);
		drawFlag(g, x - 35,  yPixelHeightOffset() + 20);
	}
}
