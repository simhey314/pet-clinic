package com.heyden.spring.petclinic.entity;

import java.time.LocalDate;

public class Visit extends BaseEntity {

	private LocalDate date;
	private Pet pet;
	private String description;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(final LocalDate date) {
		this.date = date;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(final Pet pet) {
		this.pet = pet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Visit{" +
				"date=" + date +
				", pet=" + pet +
				"} " + super.toString();
	}
}
