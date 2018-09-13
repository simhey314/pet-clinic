package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.entity.PetType;

import java.time.LocalDate;

public final class PetBuilder {
	private Owner owner;
	private PetType petType;
	private LocalDate birthDate;
	private String name;

	private PetBuilder() {
	}

	public static PetBuilder aPet() {
		return new PetBuilder();
	}

	public PetBuilder withOwner(final Owner owner) {
		this.owner = owner;
		return this;
	}

	public PetBuilder withPetType(final PetType petType) {
		this.petType = petType;
		return this;
	}

	public PetBuilder withPetType(final String petType) {
		this.petType = new PetType(petType);
		return this;
	}

	public PetBuilder withBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}

	public PetBuilder withName(final String name) {
		this.name = name;
		return this;
	}

	public PetBuilder but() {
		return aPet().withOwner(owner).withPetType(petType).withBirthDate(birthDate).withName(name);
	}

	public Pet build() {
		final Pet pet = new Pet(name);
		pet.setOwner(owner);
		pet.setPetType(petType);
		pet.setBirthDate(birthDate);
		return pet;
	}
}
