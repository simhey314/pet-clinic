package com.heyden.spring.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "vets")
public class Vet extends Person {

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "vet_speciality", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
	private Set<Speciality> specialities = new HashSet<>();

	public Vet(final String firstName, final String lastName, final String street, final String city, final String zip, final String telephone) {
		super(firstName, lastName, street, city, zip, telephone);
	}

	public void addSpeciality(final Speciality speciality) {
		specialities.add(speciality);
	}
}
