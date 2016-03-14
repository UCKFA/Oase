package com.dbstuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.userdata.Notification;
/*
public class NotificationsSql implements Serializable {
	/**
	 * 
	
	private static final long serialVersionUID = 1L;
	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;

	public void addItem(Notification n) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO notifications(type, recvFrom) VALUES (?,?)",
							Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, n.getType());
			ps.setInt(2, n.getFrom());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				n.setId(rs.getInt(1));

			}

			System.out.println("executed");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public boolean update(Notification not) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("UPDATE notifications SET accepted = ? where id = ?");
			ps.setBoolean(1, not.isAccepted());
			ps.setInt(2, not.getId());
			int affectedRows = ps.executeUpdate();
			conn.close();
			return affectedRows == 1;
		} catch (SQLException | IOException e) {
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("DELETE FROM notofications where id = ?");
			ps.setInt(1, id);
			int affectedRows = ps.executeUpdate();
			conn.close();
			return affectedRows == 1;
		} catch (SQLException | IOException e) {
			return false;
		}
	}

	public Notification findNotification(int id) {

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from notifications where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Notification foundNotification = new Notification(rs.getInt(1),
						rs.getInt(2), rs.getString(3), rs.getBoolean(4));
				conn.close();
				return foundNotification;

			}
			conn.close();

		} catch (SQLException | IOException e) {
			e.printStackTrace();

			return null;
		}

		return null;
	}

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "it15g11", "7nigyw2");
	}

}
*/