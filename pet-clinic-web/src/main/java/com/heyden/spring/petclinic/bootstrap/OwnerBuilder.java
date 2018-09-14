package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.entity.Pet;

import java.util.HashSet;
import java.util.Set;

public class OwnerBuilder {
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String zip;
	private String telephone;
	private Set<PetBuilder> petBuilders = new HashSet<>();

	private OwnerBuilder() {
	}

	public static OwnerBuilder aOwner() {
		return new OwnerBuilder();
	}

	public OwnerBuilder withFirstName(final String firstName) {
		this.firstName = firstName;
		return this;
	}

	public OwnerBuilder withLastName(final String lastName) {
		this.lastName = lastName;
		return this;
	}

	public OwnerBuilder withStreet(final String street) {
		this.street = street;
		return this;
	}

	public OwnerBuilder withCity(final String city) {
		this.city = city;
		return this;
	}

	public OwnerBuilder withZip(final String zip) {
		this.zip = zip;
		return this;
	}

	public OwnerBuilder withTelephone(final String telephone) {
		this.telephone = telephone;
		return this;
	}

	public OwnerBuilder withPet(final PetBuilder petBuilder) {
		petBuilders.add(petBuilder);
		return this;
	}

	public Owner build() {
		final Owner owner = new Owner(firstName, lastName, street, city, zip, telephone);
		final Set<Pet> pets = new HashSet<>();
		petBuilders.forEach(petBuilder -> {
			petBuilder.withOwner(owner);
			pets.add(petBuilder.build());
		});
		owner.setPets(pets);
		return owner;
	}
}