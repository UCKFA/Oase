package com.dbstuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONObject;

import com.userdata.User;

public class UserSqlImplement {

	private final String SQL_INSERT = "INSERT INTO users(id, name, surname, email , birth_date) VALUES (?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE  users SET notifications=? WHERE id=?";
	private final String URL = "jdbc:mysql://localhost:3306/studenti?autoReconnect=true&useSSL=false";

	private Connection conn;

	public void addItem(User o) {
		User u = o;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
			ps.setInt(1, u.getId());
			ps.setString(2, u.getName());
			ps.setString(3, u.getSurname());
			ps.setString(4, u.getEmail());
			ps.setDate(5, u.getBirthDate());

			ps.execute();

			conn.close();
			System.out.println(u.getBirthDate());

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}



	@SuppressWarnings("unchecked")
	public JSONObject findUsersByName(String name) {
		try {
			Connection conn = getConnection();
			String pattern = "\'" + name + "\'";
			PreparedStatement ps = conn.prepareStatement("select name from users  WHERE name REGEXP " + pattern);

			ResultSet rs = ps.executeQuery();
			JSONObject foundUsers = new JSONObject();
			while (rs.next()) {
				foundUsers.put(rs.getString(1), 0);
			}
			conn.close();
			return foundUsers;

		} catch (SQLException | IOException e) {
			e.printStackTrace();

			return null;
		}

	}

	/* Used to find a use by his username */
	public User findUser(String name) {

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users where name = ?");
			ps.setString(1, name);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User foundUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getDate(5));
				conn.close();
				return foundUser;
			}
			conn.close();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	/* Used to find a user by his id */
	public User findUser(int id) {

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from users where id = ?");
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				User foundUser = new User(id, rs.getString(2), rs.getString(3), rs.getString(5),
						rs.getDate(6));
				conn.close();
				return foundUser;

			}
			conn.close();

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		return DriverManager.getConnection(URL, "root", "1234");
	}

}
