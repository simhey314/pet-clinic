package com.heyden.spring.petclinic.entity;

public class Vet extends Person {

	private Speciality speciality;

	public Vet() {
	}

	public Vet(final String firstName, final String lastName) {
		super(firstName, lastName);
	}

	public Speciality getSpeciality() {
		return speciality;
	}

	public void setSpeciality(final Speciality speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Vet{" +
				"speciality=" + speciality +
				"} " + super.toString();
	}
}
