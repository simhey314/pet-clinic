package com.heyden.spring.petclinic.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	private LocalDate birthDate;
	private String name;

	public Pet() {
	}

	public Pet(final String name) {
		this.name = name;
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
				", name='" + name + '\'' +
				"} " + super.toString();
	}
}
