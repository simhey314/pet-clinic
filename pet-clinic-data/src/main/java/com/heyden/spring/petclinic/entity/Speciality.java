package com.heyden.spring.petclinic.entity;

public class Speciality extends BaseEntity {

	private String description;

	public Speciality() {
	}

	public Speciality(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}
}
