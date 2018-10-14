package com.heyden.spring.petclinic.service;

import com.heyden.spring.petclinic.entity.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);

	List<Owner> findAllByLastNameLike(String lastName);
}
