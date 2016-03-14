package com.dbstuff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.imagedata.Comment;


public class CommentSqlImplement {

	private String url = "jdbc:mysql://ems.informatik.uni-oldenburg.de:55000/it15g11";
	private Connection conn;

	public void addItem(Comment comment) {

		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO comments( text, user_id, topic_id) VALUES (?, ?, ?)");
			ps.setString(1, comment.getContent());
			ps.setInt(2, comment.getUserId());
			ps.setInt(3, comment.getTopicId());
			ps.execute();
			System.out.println("executed");

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Comment> getAll() {

		ArrayList<Comment> comments;
		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("select * from comments");

			ResultSet rs = ps.executeQuery();
			
			comments = new ArrayList<Comment>();
			while (rs.next()) {
				comments.add(new Comment(rs.getInt(1), rs.getNString(2), rs.getInt(3), rs.getInt(4)));
				
			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
			return null;
		}
		return comments;
	}

	public Connection getConnection() throws SQLException,
			FileNotFoundException, IOException {

		return DriverManager.getConnection(url, "it15g11", "7nigyw2");
	}

}
