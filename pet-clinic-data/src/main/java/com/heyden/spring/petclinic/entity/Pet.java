package com.heyden.spring.petclinic.entity;

import java.time.LocalDate;

public class Pet extends BaseEntity {
	private Owner owner;
	private PetType petType;
	private LocalDate birthDate;

	public Pet() {
	}

	public Pet(final Owner owner, final PetType petType, final LocalDate birthDate) {
		this.owner = owner;
		this.petType = petType;
		this.birthDate = birthDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(final Owner owner) {
		this.owner = owner;
	}

	public PetType getPetType() {
		return petType;
	}

	public void setPetType(final PetType petType) {
		this.petType = petType;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Pet{" +
				"owner=" + owner +
				", petType=" + petType +
				", birthDate=" + birthDate +
				"} " + super.toString();
	}
}
