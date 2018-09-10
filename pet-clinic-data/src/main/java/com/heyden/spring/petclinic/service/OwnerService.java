package com.heyden.spring.petclinic.service;

import com.heyden.spring.petclinic.entity.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
	Owner findByLastName(String lastName);
}
