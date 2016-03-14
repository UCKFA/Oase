package com.imagedata;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
/*
 * Describes the images that are processed
 * 
 * */
/**
 * @author Brinzoiu
 *
 */
public class UserImage {

	private int userId;
	private String fileName;
	//will be an array eventually
	private List<Point2D> interestPoints;

	/**
	 * 
	 */
	public UserImage() {}

	/**
	 * @param userId
	 */
	public UserImage(int userId) {

		this.userId = userId;
	}

	/**
	 * @param userId
	 * @param fileName
	 */
	public UserImage(int userId, String fileName) {

		this.userId = userId;
		this.fileName = fileName;
	}

	/**
	 * @param userId
	 * @param fileName
	 * @param interestPoints
	 */
	public UserImage(int userId, String fileName, List<Point2D> interestPoints) {
		this.userId 		= userId;
		this.fileName 		= fileName;
		this.interestPoints = interestPoints;
	}

	/**
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return
	 */
	public List<Point2D> getInterestPoints() {
		return interestPoints;
	}

	/**
	 * @param interestPoints
	 */
	public void setInterestPoints(List<Point2D> interestPoints) {
		this.interestPoints = interestPoints;
	}

	/**
	 * @return
	 */
	public ArrayList<Integer> getInterestPointsValues() {
		ArrayList<Integer> a = new ArrayList<>();
		for (Point2D p : interestPoints) {
			a.add((int) p.getX());
			a.add((int) p.getY());
		}
		return a;
	}

	

}
