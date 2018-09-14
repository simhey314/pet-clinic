package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.entity.Visit;

import java.time.LocalDate;

public final class VisitBuilder {
	private LocalDate date;
	private Pet pet;
	private String description;

	private VisitBuilder() {
	}

	public static VisitBuilder aVisit() {
		return new VisitBuilder();
	}

	public VisitBuilder withDate(final LocalDate date) {
		this.date = date;
		return this;
	}

	public VisitBuilder withPet(final Pet pet) {
		this.pet = pet;
		return this;
	}

	public VisitBuilder withDescription(final String description) {
		this.description = description;
		return this;
	}

	public VisitBuilder but() {
		return aVisit().withDate(date).withPet(pet).withDescription(description);
	}

	public Visit build() {
		final Visit visit = new Visit();
		visit.setDate(date);
		visit.setPet(pet);
		visit.setDescription(description);
		return visit;
	}
}
