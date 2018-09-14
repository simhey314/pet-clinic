package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.PetType;
import com.heyden.spring.petclinic.repository.PetTypeRepository;
import com.heyden.spring.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class PetTypeJPAService extends AbstractJPAService<PetType, Long, PetTypeRepository> implements PetTypeService {

	public PetTypeJPAService(final PetTypeRepository repository) {
		super(repository);
	}
}
