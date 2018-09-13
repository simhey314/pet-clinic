package com.heyden.spring.petclinic.entity;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person {

	private Set<Pet> pets = new HashSet<>();

	public Owner() {
	}

	public Owner(final String firstName, final String lastName) {
		super(firstName, lastName);
	}

	public Owner(final String firstName, final String lastName, final String street, final String city, final String zip, final String telephone) {
		super(firstName, lastName, street, city, zip, telephone);
	}

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(final Set<Pet> pets) {
		this.pets = pets;
	}
//	public void addPet(Pet pet){
//		if (pets == null) {
//			pets = new HashSet<>();
//		}
//		pets.add(pet);
//	}
}
