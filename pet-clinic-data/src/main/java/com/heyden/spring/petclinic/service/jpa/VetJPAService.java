package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.repository.VetRepository;
import com.heyden.spring.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VetJPAService extends AbstractJPAService<Vet, Long, VetRepository> implements VetService {

	public VetJPAService(final VetRepository vetRepository) {
		super(vetRepository);
	}
}
