package com.heyden.spring.petclinic.service;

import com.heyden.spring.petclinic.entity.Vet;

import java.util.Set;

public interface VetService {
	Set<Vet> findAll();

	Vet findById(Long id);

	void save(Vet vet);

}
