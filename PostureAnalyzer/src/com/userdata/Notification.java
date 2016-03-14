package com.userdata;

import java.io.Serializable;

public class Notification implements Serializable {
	


	private static final long serialVersionUID = 1841415603446178402L;
	
	private int id;
	private String type, from, to;
	private boolean accepted;

	/**
	 * @param id
	 * @param type
	 * @param from
	 * @param to
	 * @param accepted
	 */
	public Notification(int id, String type, String from, String to,
			boolean accepted) {
		super();
		this.id = id;
		this.type = type;
		this.from = from;
		this.to = to;
		this.accepted = accepted;
	}

	/**
	 * @param type
	 * @param from
	 * @param to
	 */
	public Notification(String type, String from, String to) {
		
		this.id=hashCode();
		this.type = type;
		this.from = from;
		this.to = to;
		this.accepted = false;
	}

	/**
	 * @param id
	 * @param type
	 * @param from
	 * @param to
	 * @param accepted
	 */
	public Notification(int id, String to, String type) {

		this.id = id;
		this.type = type;
		this.from = "";
		this.to = to;
		this.accepted = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((from == null) ? 0 : from.hashCode());
		result = prime * result + ((to == null) ? 0 : to.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notification other = (Notification) obj;
		if (from == null) {
			if (other.from != null)
				return false;
		} else if (!from.equals(other.from))
			return false;
		if (to == null) {
			if (other.to != null)
				return false;
		} else if (!to.equals(other.to))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", from=" + from + ", type=" + type
				+ ", accepted=" + accepted + "]";
	}

}
