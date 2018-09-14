package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.repository.PetRepository;
import com.heyden.spring.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetJPAService extends AbstractJPAService<Pet, Long, PetRepository> implements PetService {

	public PetJPAService(final PetRepository repository) {
		super(repository);
	}
}
