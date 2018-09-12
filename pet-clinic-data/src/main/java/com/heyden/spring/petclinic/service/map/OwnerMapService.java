package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Owner findByLastName(final String lastName) {
		return null;
	}
}
