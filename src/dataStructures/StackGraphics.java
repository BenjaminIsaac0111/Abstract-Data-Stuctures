package dataStructures;

import java.awt.Graphics;

public class StackGraphics extends Stack {

	private static int x = 330;
	private int y = 280;
	
	
	
	private String stackItemString;
	private boolean isFirstItem;

	public void paintStack(Graphics g) {
		buildStrings();
		y = 280;
		isFirstItem = true;
		assembleStackBlocks(g);
	}

	private void assembleStackBlocks(Graphics g) {
		while (stringsToPrint.hasNext()) {
			stackItemString = stringsToPrint.next();
			buildStackBlock(g);
			isFirstItem = checkIfTopItem(g);
			y = y + 30;
		}
	}

	private void buildStackBlock(Graphics g) {
		g.drawString(stackItemString, x + 60, y + 16 - getStackPixelHeight());
		g.drawRect(x, y - getStackPixelHeight(), 180, 32);
	}

	private boolean checkIfTopItem(Graphics g) {
		if (isFirstItem) {
			g.drawString("top->", x - 30, y + 22 - getStackPixelHeight());
			isFirstItem = false;
		}
		return isFirstItem;
	}
	
	private int getStackPixelHeight(){
		return 30 * getStackSize();
		}
}
