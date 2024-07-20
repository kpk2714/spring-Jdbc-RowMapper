package com.spring.jdbc.usingxml;

public class Student {

	private int id;
	private String name;
	private String city;
	private String district;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Student(int id, String name, String city, String district, String state) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.district = district;
		this.state = state;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", district=" + district + ", state=" + state
				+ "]";
	}
	
	
}
