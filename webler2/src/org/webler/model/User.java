package org.webler.model;

import java.util.List;

public class User {
	
	private String name;
	private String gender;
	private List<String> lanquages;
	private String country;
	
	
	
	public User(String name, String gender, List<String> lanquages, String country) {
		super();
		this.name = name;
		this.gender = gender;
		this.lanquages = lanquages;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public List<String> getLanquages() {
		return lanquages;
	}
	public void setLanquages(List<String> lanquages) {
		this.lanquages = lanquages;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

}
