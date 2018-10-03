package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.repository.OwnerRepository;
import com.heyden.spring.petclinic.repository.PetRepository;
import com.heyden.spring.petclinic.repository.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerJPAServiceTest {

	public static final String LAST_NAME = "lastname";

	@Mock
	OwnerRepository ownerRepository;
	@Mock
	PetTypeRepository petTypeRepository;
	@Mock
	PetRepository petRepository;

	@InjectMocks
	OwnerJPAService underTest;
	private Owner expectedOwner;

	@BeforeEach
	private void setup() {
		expectedOwner = new Owner();
		expectedOwner.setId(1L);
		expectedOwner.setLastName(LAST_NAME);
	}

	@Test
	void findByLastName() {

		when(ownerRepository.findByLastNameLike(anyString())).thenReturn(expectedOwner);

		Owner actual = underTest.findByLastName(LAST_NAME);

		assertThat(actual.getLastName()).isEqualTo(LAST_NAME);
		verify(ownerRepository, times(1)).findByLastNameLike(anyString());
	}

	@Test
	void findAll() {
	}

	@Test
	void findById() {
	}

	@Test
	void save() {
	}

	@Test
	void delete() {
	}

	@Test
	void deleteById() {
	}
}