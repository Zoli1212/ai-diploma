package org.webler.model;

import java.util.List;

public class User {
	
	private String name;
	private String gender;
	private List<String> languages;
	private String country;
	
	
	public User(String name, String gender, List<String> languages, String country) {
		super();
		this.name = name;
		this.gender = gender;
		this.languages = languages;
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
	public List<String> getLanguages() {
		return languages;
	}
	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
