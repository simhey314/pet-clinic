package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class OwnerMapServiceTest {

	public static final long ID = 1L;
	public static final String LAST_NAME = "lastname";
	private OwnerMapService underTest;

	@BeforeEach
	void setUp() {
		underTest = new OwnerMapService(new PetTypeMapService(), new PetMapService());
		Owner owner = new Owner();
		owner.setId(ID);
		owner.setLastName(LAST_NAME);
		underTest.save(owner);
	}

	@Test
	void findByLastName() {

		Owner actual = underTest.findByLastName(LAST_NAME);

		assertThat(actual.getLastName()).isEqualTo(LAST_NAME);
	}

	@Test
	void findByLastNameNotFound() {

		Owner actual = underTest.findByLastName("empty");

		assertThat(actual).isNull();
	}

	@Test
	void saveExistingId() {
		Owner owner = new Owner();
		long id = 2l;
		owner.setId(id);

		Owner actual = underTest.save(owner);

		assertThat(owner.getId()).isEqualTo(id);
	}

	@Test
	void saveNoId() {
		Owner owner = new Owner();

		Owner actual = underTest.save(owner);

		assertThat(owner.getId()).isNotNull();
	}

	@Test
	void findAll() {
		Set<Owner> actual = underTest.findAll();

		assertThat(actual.size()).isEqualTo(1);
	}

	@Test
	void findById() {
		Owner actual = underTest.findById(ID);

		assertThat(actual.getId()).isEqualTo(ID);
	}

	@Test
	void deleteById() {
		underTest.deleteById(ID);
		Set<Owner> actual = underTest.findAll();

		assertThat(actual.size()).isZero();
	}

	@Test
	void delete() {
		Owner deleteOwner = underTest.findById(ID);

		underTest.delete(deleteOwner);
		Set<Owner> actual = underTest.findAll();

		assertThat(actual.size()).isZero();
	}
}