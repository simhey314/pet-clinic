package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;

public class OnwerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(final String lastName) {
		return null;
	}
}
