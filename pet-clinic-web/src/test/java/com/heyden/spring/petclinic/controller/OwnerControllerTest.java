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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

	@Mock
	private OwnerService ownerService;

	@InjectMocks
	private OwnerController underTest;

	private List<Owner> expectedOwners;

	private MockMvc mockMVC;

	@BeforeEach
	void setUp() {
		expectedOwners = new ArrayList<>();
		Owner owner = new Owner();
		owner.setId(1L);
		expectedOwners.add(owner);
		owner = new Owner();
		owner.setId(2L);
		expectedOwners.add(owner);

		mockMVC = MockMvcBuilders.standaloneSetup(underTest).build();
	}

	@Test
	void listOwnersIndex() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(expectedOwners);

		mockMVC.perform(get("/owners/index"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/list"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void detailOwner() throws Exception {
		Owner expected = new Owner();
		expected.setId(123L);
		when(ownerService.findById(anyLong())).thenReturn(expected);

		mockMVC.perform(get("/owners/123"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/details"))
				.andExpect(model().attribute("owner", hasProperty("id", is(123L))));
	}

	@Test
	void findOwner() throws Exception {
		mockMVC.perform(get("/owners/find"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/find"))
				.andExpect(model().attributeExists("owner"));
	}

	@Test
	void processOwnerReturnMany() throws Exception {
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(new ArrayList<>(expectedOwners));

		mockMVC.perform(get("/owners"))
				.andExpect(status().isOk())
				.andExpect(view().name("owners/list"))
				.andExpect(model().attribute("owners", hasSize(2)));
	}

	@Test
	void processOwnerReturnOne() throws Exception {
		Owner expectedOwner = expectedOwners.iterator().next();
		when(ownerService.findAllByLastNameLike(anyString())).thenReturn(Collections.singletonList(expectedOwner));

		mockMVC.perform(get("/owners"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/owners/" + expectedOwner.getId()));
	}
}