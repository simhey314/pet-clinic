package com.heyden.spring.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
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
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
	private Set<Visit> visits = new HashSet<>();
}
