package com.dbstuff;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imagedata.UserImage;

import javafx.geometry.Point2D;

public class ImageSqlImplement {

	private final String SQL_INSERT  		  = "INSERT INTO user_images(user_id, file, points) VALUES (?, ?, ?)";
	private final String SQL_GET_ALL 		  = "select * from user_images";
	private final String SQL_GET_ALL_FOR_USER = "select * from user_images where user_id = ";
			
	private String url = "jdbc:mysql://localhost:3306/studenti";
	private Connection conn;

	public void addItem(UserImage image) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
			ps.setInt(1, image.getUserId());
			ps.setString(2, image.getFileName());
			ps.setObject(3, image.getInterestPointsValues());
			ps.execute();
			conn.close();
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<UserImage> getAll() {
		return accessDb(SQL_GET_ALL);
	}
	public ArrayList<UserImage> getImagesForUser(int id){
		return accessDb(SQL_GET_ALL_FOR_USER + id);
	}
	
	
	private ArrayList<UserImage> accessDb(String statemment){
		ArrayList<UserImage> imageArray;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(statemment);
			ResultSet rs = ps.executeQuery();
			imageArray = constructList(rs);
			conn.close();
		} catch (SQLException | IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return imageArray;

		
	}
	

	private ArrayList<UserImage> constructList(ResultSet rs) throws ClassNotFoundException, SQLException, IOException {
		ArrayList<UserImage> images = new ArrayList<UserImage>();

		// read object from DB
		while (rs.next()) {

			byte[] buf = rs.getBytes(3);
			ObjectInputStream objectIn = null;
			if (buf != null)
				objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

			ArrayList<Integer> ints = ((ArrayList<Integer>) objectIn.readObject());
			ArrayList<Point2D> points = new ArrayList<>();
			for (int i = 1; i < ints.size(); i = i + 2) {
				points.add(new Point2D(ints.get(i - 1), ints.get(i)));
			}
			images.add(new UserImage(rs.getInt(1), rs.getString(2), points));
		}

		return images;
	}

	public Connection getConnection() throws SQLException, FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "root", "1234");
	}

}
