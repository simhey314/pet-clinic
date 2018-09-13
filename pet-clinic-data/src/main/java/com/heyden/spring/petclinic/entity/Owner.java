package com.heyden.spring.petclinic.entity;

import java.util.Set;

public class Owner extends Person {

	private Set<Pet> pets;

	public Owner(final String firstName, final String lastName) {
		super(firstName, lastName);
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(final Set<Pet> pets) {
		this.pets = pets;
	}
}
