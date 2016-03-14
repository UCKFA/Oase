package com.oase.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.oase.procedures.MainProc;
import com.sun.javafx.geom.Point2D;

public class ImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980300633668954251L;
	private BufferedImage img;
	private MainProc procedure;

	public ImagePanel() {
		img = null;
		this.setPreferredSize(new Dimension(1000, 500));
		this.setVisible(true);
	};

	public ImagePanel(BufferedImage img) {
		this.img = img;
		this.setPreferredSize(new Dimension(1000, 500));
		this.setVisible(true);
		

	}

	public ImagePanel(File f) throws IOException {
		img = createImage(f);
		this.setSize(new Dimension(1000, 500));
		this.setVisible(true);
		

	}

	@Override
	public void paintComponent(Graphics g) {
		
		if(img == null ) return;
		g.drawImage(img, 0, 0, null);
		

	}
	
	public void drawCircle( int x , int y ){
		Graphics2D g = img.createGraphics();
		g.setColor(new Color(0));
		g.drawOval(x, y, 5, 5);
		
	}
	
	public void drawLine(Point2D a, Point2D b){
		Graphics2D g = img.createGraphics();
		g.setColor(new Color(0));
		g.drawLine((int)a.x, (int)a.y, (int)b.x, (int)b.y);
	}

	private BufferedImage createImage(File file) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(file);
		return bufferedImage;
	}

	public BufferedImage getImage() {
		return img;
	}

	public void setImage(BufferedImage img) {
		this.img = img;

	}

	public MainProc getProcedure() {
		return procedure;
	}

	public void setProcedure(MainProc procedure) {
		this.procedure = procedure;
	}
	
	
	
	

}
