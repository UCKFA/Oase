package com.imagedata;

public class Comment {

	private int id;

	private String content;

	private int userId;
	
	private int topicId;

	public Comment(String content, int userId, int topicId) {
		this.content = content;
		this.userId = userId;
		this.topicId = topicId;
	}

	public Comment(int id, String content, int userId, int topicId) {
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.topicId = topicId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
