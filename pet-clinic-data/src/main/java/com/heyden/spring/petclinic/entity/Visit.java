package com.heyden.spring.petclinic.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(callSuper = true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;
	private String description;
}
