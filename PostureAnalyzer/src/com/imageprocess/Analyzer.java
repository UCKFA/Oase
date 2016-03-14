package com.imageprocess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import javafx.geometry.Point2D;

/**
 * @author Brinzoiu
 * 
 */
public class Analyzer {

	/**
	 * Makes the needed calculations and drawings
	 * 
	 * @param image
	 * @param interestPoints
	 */
	public static void analyze(BufferedImage image,
			ArrayList<Point2D> interestPoints) {
		
		
		Graphics2D g2d = image.createGraphics();
		g2d.setColor(Color.yellow);
		g2d.setStroke(new BasicStroke(3));

		for (int i = 1; i < 6; i = i + 2) {
			System.out.println("Angle between p" + (i - 1) + " and p" + i
					+ " is "
					+ interestPoints.get(i - 1).angle(interestPoints.get(i)));
			g2d.drawLine((int) interestPoints.get(i - 1).getX(),
					(int) interestPoints.get(i - 1).getY(),
					(int) interestPoints.get(i).getX(), (int) interestPoints
							.get(i).getY());

		}
		
		for (int i = 7; i <9 ; i ++){
			System.out.println("Angle between p" + (i - 1) + " and p" + i
					+ " is "
					+ interestPoints.get(i - 1).angle(interestPoints.get(i)));
			g2d.drawLine((int) interestPoints.get(i - 1).getX(),
					(int) interestPoints.get(i - 1).getY(),
					(int) interestPoints.get(i).getX(), (int) interestPoints
							.get(i).getY());
			
		
		}

	}

}
