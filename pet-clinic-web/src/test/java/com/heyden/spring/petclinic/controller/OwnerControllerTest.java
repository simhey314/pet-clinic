package com.heyden.spring.petclinic.controller;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService ownerService;

	@InjectMocks
	private OwnerController underTest;

	private Set<Owner> expectedOwners;

	private MockMvc mockMVC;

	@BeforeEach
	void setUp() {
		expectedOwners = new HashSet<>();
		Owner owner = new Owner();
		owner.setId(1l);
		expectedOwners.add(owner);
		owner = new Owner();
		owner.setId(2l);
		expectedOwners.add(owner);

		mockMVC = MockMvcBuilders.standaloneSetup(underTest).build();
	}

	@Test
	void listOwners() throws Exception {
		when(ownerService.findAll()).thenReturn(expectedOwners);

		mockMVC.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void listOwnersIndex() throws Exception {
		when(ownerService.findAll()).thenReturn(expectedOwners);

		mockMVC.perform(get("/owners/index"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/index"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void detailOwner() throws Exception {
		Owner expected = new Owner();
		expected.setId(123l);
		when(ownerService.findById(anyLong())).thenReturn(expected);

		mockMVC.perform(get("/owners/123"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/details"))
				.andExpect(model().attribute("owner", hasProperty("id", is(123l))));
	}

	@Test
	void findOwner() throws Exception {
		mockMVC.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("notYetImplemented"));
		verifyZeroInteractions(ownerService);
	}
}