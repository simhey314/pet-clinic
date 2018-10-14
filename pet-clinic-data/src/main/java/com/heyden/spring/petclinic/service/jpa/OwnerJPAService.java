package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.repository.OwnerRepository;
import com.heyden.spring.petclinic.repository.PetRepository;
import com.heyden.spring.petclinic.repository.PetTypeRepository;
import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class OwnerJPAService extends AbstractJPAService<Owner, Long, OwnerRepository> implements OwnerService {

	private PetTypeRepository petTypeRepository;
	private PetRepository petRepository;

	public OwnerJPAService(OwnerRepository ownerRepository, PetTypeRepository petTypeRepository, PetRepository petRepository) {
		super(ownerRepository);
		this.petTypeRepository = petTypeRepository;
		this.petRepository = petRepository;
	}

	@Override
	public Owner findByLastName(final String lastName) {
		return repository.findByLastNameLike(lastName);
	}

	@Override
	public List<Owner> findAllByLastNameLike(final String lastName) {
		return repository.findAllByLastNameContainingIgnoreCase(lastName);
	}
}
