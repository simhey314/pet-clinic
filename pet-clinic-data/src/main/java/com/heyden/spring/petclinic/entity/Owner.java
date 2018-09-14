package com.heyden.spring.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "owners")
public class Owner extends Person {

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();

	public Owner(final String firstName, final String lastName, final String street, final String city, final String zip, final String telephone) {
		super(firstName, lastName, street, city, zip, telephone);
	}

	public Owner addPet(final Pet pet) {
		if (pet != null) {
			pets.add(pet);
			pet.setOwner(this);
		}
		return this;
	}
}
