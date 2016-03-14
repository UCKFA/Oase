package com.oase.main;
import com.oase.graphics.DrawRoom;
import com.oase.gui.Display;


public class Main {
	
	private static Display display;
	
	
	public static void main(String[] args) {
		display = Display.getInstance();
		display.generateInitialWindow();
		display.generateFileChooser();
	

		DrawRoom drawRoom = new DrawRoom();
	}
	
}
