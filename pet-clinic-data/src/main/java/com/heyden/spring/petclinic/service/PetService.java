package com.heyden.spring.petclinic.service;

import com.heyden.spring.petclinic.entity.Pet;

import java.util.Set;

public interface PetService {
	Set<Pet> findAll();

	Pet findById(Long id);

	void save(Pet pet);

}
