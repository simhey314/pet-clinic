package com.heyden.spring.petclinic.service;

import com.heyden.spring.petclinic.entity.Owner;

import java.util.Set;

public interface OwnerService {
	Set<Owner> findAll();

	Owner findById(Long id);

	Owner findByLastName(String lastName);

	void save(Owner owner);

}
