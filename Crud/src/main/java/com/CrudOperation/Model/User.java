package com.CrudOperation.Model;

import javax.persistence.*;


@Entity

public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column
	private String Name;
	@Column
	private String Email;
	@Column
	private String Number;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String email, String number) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Number = number;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Number=" + Number + "]";
	}
	
}
