package com.heyden.spring.petclinic.entity;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

	private Set<Speciality> specialities = new HashSet<>();

	public Vet() {
	}

	public Vet(final String firstName, final String lastName) {
		super(firstName, lastName);
	}

	public Vet(final String firstName, final String lastName, final String street, final String city, final String zip, final String telephone) {
		super(firstName, lastName, street, city, zip, telephone);
	}

	public Set<Speciality> getSpecialities() {
		return specialities;
	}

	public void setSpecialities(final Set<Speciality> specialities) {
		this.specialities = specialities;
	}

	@Override
	public String toString() {
		return "Vet{" +
				"specialities=" + specialities +
				"} " + super.toString();
	}
}
