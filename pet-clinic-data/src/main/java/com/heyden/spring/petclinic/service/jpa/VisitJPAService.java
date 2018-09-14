package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Visit;
import com.heyden.spring.petclinic.repository.VisitRepository;
import com.heyden.spring.petclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpa")
public class VisitJPAService extends AbstractJPAService<Visit, Long, VisitRepository> implements VisitService {
	public VisitJPAService(final VisitRepository repository) {
		super(repository);
	}
}
