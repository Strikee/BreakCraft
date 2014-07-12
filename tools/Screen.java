package com.breakcraft.tools;

import com.breakcraft.window.Window;

public class Screen extends Window {
	
	public Screen() { }
	
	public void drawRect(int x1, int y1, int x2, int y2, int edgeColor, int rectColor) {
		drawRectEdge(x1, y1, x2, y2, edgeColor);
		drawRect(x1, y1, x2, y2, rectColor);
	}

	private void drawRectEdge(int x1, int y1, int x2, int y2, int color) {
		drawRect(x1, y1, x1 - 1, y2, color);
		drawRect(x2, y1, x2 + 1, y2, color);
		drawRect(x1 - 1, y1, x2 + 1, y1 - 1, color);
		drawRect(x1 - 1, y2, x2 + 1, y2 + 1, color);
	}
	
	public int getScreenWidth() {
		return width;
	}
	
	public int getScreenHeight() {
		return height;
	}
}
