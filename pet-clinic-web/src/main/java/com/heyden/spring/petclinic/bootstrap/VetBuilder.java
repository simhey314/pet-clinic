package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Speciality;
import com.heyden.spring.petclinic.entity.Vet;

import java.util.HashSet;
import java.util.Set;

public final class VetBuilder {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String telephone;
	private Set<Speciality> specialities = new HashSet<>();

	private VetBuilder() {
	}

	public static VetBuilder aVet() {
		return new VetBuilder();
	}

	public VetBuilder withFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public VetBuilder withLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public VetBuilder withSpeciality(final Speciality speciality) {
		specialities.add(speciality);
		return this;
	}

	public VetBuilder withStreet(final String street) {
		this.street = street;
		return this;
	}

	public VetBuilder withCity(final String city) {
		this.city = city;
		return this;
	}

	public VetBuilder withZip(final String zip) {
		this.zip = zip;
		return this;
	}

	public VetBuilder withTelephone(final String telephone) {
		this.telephone = telephone;
		return this;
	}

	public VetBuilder but() {
		return aVet().withFirstName(firstName).withLastName(lastName).withSpecialities(specialities).withStreet(street).withCity(city).withZip(zip).withTelephone(telephone);
	}

	private VetBuilder withSpecialities(final Set<Speciality> specialities) {
		this.specialities = specialities;
		return this;
	}

	public Vet build() {
		final Vet vet = new Vet(firstName, lastName, street, city, zip, telephone);
		vet.setSpecialities(specialities);
		return vet;
	}
}
