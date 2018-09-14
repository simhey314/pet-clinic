package com.heyden.spring.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "visits")
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

	@ManyToOne
	@JoinColumn(name = "pet_id")
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
