package com.oase.gui;


public class MenuActions {
	
	public static Display display ;
	
	public static void open(){
		display =Display.getInstance();
		display.getImLoader().openImage();		
	}

}
