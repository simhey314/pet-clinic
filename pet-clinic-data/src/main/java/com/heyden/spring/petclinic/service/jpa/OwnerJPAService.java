package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.repository.OwnerRepository;
import com.heyden.spring.petclinic.repository.PetRepository;
import com.heyden.spring.petclinic.repository.PetTypeRepository;
import com.heyden.spring.petclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerJPAService implements OwnerService {

	private OwnerRepository ownerRepository;
	private PetRepository petRepository;
	private PetTypeRepository petTypeRepository;

	public OwnerJPAService(final OwnerRepository ownerRepository, final PetRepository petRepository, final PetTypeRepository petTypeRepository) {
		this.ownerRepository = ownerRepository;
		this.petRepository = petRepository;
		this.petTypeRepository = petTypeRepository;
	}

	@Override
	public Owner findByLastName(final String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Set<Owner> findAll() {
		final Set<Owner> owners = new HashSet<>();
		ownerRepository.findAll().iterator().forEachRemaining(owners::add);
		return owners;
	}

	@Override
	@Nullable
	public Owner findById(final Long id) {
		return ownerRepository.findById(id).orElse(null);
	}

	@Override
	public Owner save(final Owner entity) {
		return ownerRepository.save(entity);
	}

	@Override
	public void delete(final Owner entity) {
		ownerRepository.delete(entity);
	}

	@Override
	public void deleteById(final Long id) {
		ownerRepository.deleteById(id);
	}
}
