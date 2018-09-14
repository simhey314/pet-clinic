package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.repository.OwnerRepository;
import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class OwnerJPAService extends AbstractJPAService<Owner, Long, OwnerRepository> implements OwnerService {

	public OwnerJPAService(final OwnerRepository ownerRepository) {
		super(ownerRepository);
	}

	@Override
	public Owner findByLastName(final String lastName) {
		return repository.findByLastName(lastName);
	}
}
