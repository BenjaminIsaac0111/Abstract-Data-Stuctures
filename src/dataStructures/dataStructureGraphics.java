package dataStructures;

import java.awt.Graphics;

public class dataStructureGraphics {

	
	
	private String blockFlag;
	protected String itemString;
	
	public String getBlockFlag() {
		return blockFlag;
	}
	public void setBlockFlag(String blockFlag) {
		this.blockFlag = blockFlag;
	}


	protected String getItemString() {
		return itemString;
	}

	protected void setItemString(String itemString) {
		this.itemString = itemString;
	}


	protected void buildBlock(Graphics g,int blockX, int blockY) {
		try {
			g.drawString(itemString, blockX + 60, blockY + 16);
			g.drawRect(blockX, blockY, 180, 32);
			g.drawRect(blockX+2, blockY+2, 176, 28);
		} catch (Exception e) {
			
		}

	}

	/**
	 * Place a indicator(top->) next to block. 
	 */
	protected void drawFlag(Graphics g,int x, int y) {		
			g.drawString(blockFlag +"->", x, y);
	}
	

	
	
}
