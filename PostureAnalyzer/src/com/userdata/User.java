package com.userdata;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class User {

	private String email, password, name, surname , gender;
	private int id, age;
	private Date birthDate;
	private List<Notification> myNotifications;

	public User(User e) {
		super();
		this.email = e.getEmail();
		this.password = e.getPassword();
		this.name = e.getName();
		this.id = e.getId();
	}

	/**
	 * @param id
	 * @param name
	 * @param email
	 */
	public User(int id, String name, String surname , String gender, Date bdate) {

		this.surname = surname;
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.birthDate = bdate;
		this.age = (int) getAge();
		this.myNotifications = new ArrayList<Notification>();
	}


	public User( String name, String surname, String email, String date, String password) {

		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		
		java.util.Date parsed = null;
		try {
			parsed = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.birthDate = new Date(parsed.getTime());
		this.myNotifications = new ArrayList<Notification>();
		
		System.out.println(getAge());

	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
		this.myNotifications = new ArrayList<Notification>();
	}

	public User(int id, String email, String password, String name) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void addNotification(Notification n) {
		myNotifications.add(n);

	}

	public void removeNotification(int id) {
		Iterator<Notification> iter = myNotifications.iterator();

		while (iter.hasNext()) {

			if (iter.next().getId() == id)
				iter.remove();
		}
	}

	public List<Notification> getMyNotifications() {
		return myNotifications;
	}

	public void setMyNotifications(List<Notification> myNotifications) {
		this.myNotifications = myNotifications;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}
	
	public long getAge(){
		return   ChronoUnit.YEARS.between(birthDate.toLocalDate(), LocalDate.now());
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", name=" + name + ", surname=" + surname
				+ ", gender=" + gender + ", id=" + id + ", birthDate=" + birthDate + "]";
	}

}
