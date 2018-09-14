package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Speciality;
import com.heyden.spring.petclinic.repository.SpecialityRepository;
import com.heyden.spring.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class SpecialityJPAService extends AbstractJPAService<Speciality, Long, SpecialityRepository> implements SpecialityService {

	public SpecialityJPAService(final SpecialityRepository repository) {
		super(repository);
	}
}
