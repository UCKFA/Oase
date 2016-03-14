package com.oase.procedures;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.oase.graphics.InterestPoint;
import com.oase.gui.Display;
import com.oase.gui.ImagePanel;

/**
 * @author Brinzi's
 *
 */
/**
 * @author Brinzi's
 *
 */
public class MainProc {
	BackProc back = new BackProc();
	SideProc side = new SideProc();
	static Display display = Display.getInstance();
	static ImagePanel imagePanel = display.getMainImagePanel();
    static List<InterestPoint> points = new ArrayList<InterestPoint>(); 
	
	
	
	public static void mainProc(int x,int y){
		points.add(new InterestPoint(x,y));
		System.out.println(points.toString()+ " asa");
	}
	
	/*
	 * The main analyaztion of the intereset points.
	 * */
	public static  void analyze(){
		System.out.println(points.get(0));
		imagePanel.drawLine(points.get(0),points.get(1));
		points.remove(0);
		//make analisis
		
		//generateReport();
	}
	private static void generateReport() {
		
		
	}
	/*
	public BufferedImage selectLeftShoulder( BufferedImage image ){
		return image;
		
	}
	*/
}
