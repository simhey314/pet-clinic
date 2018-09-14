package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.repository.VetRepository;
import com.heyden.spring.petclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetJPAService implements VetService {
	private VetRepository vetRepository;

	public VetJPAService(final VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	@Override
	public Set<Vet> findAll() {
		final Set<Vet> vets = new HashSet<>();
		vetRepository.findAll().iterator().forEachRemaining(vets::add);
		return vets;
	}

	@Override
	@Nullable
	public Vet findById(final Long aLong) {
		return vetRepository.findById(aLong).orElse(null);
	}

	@Override
	public Vet save(final Vet entity) {
		return vetRepository.save(entity);
	}

	@Override
	public void delete(final Vet entity) {
		vetRepository.delete(entity);
	}

	@Override
	public void deleteById(final Long aLong) {
		vetRepository.deleteById(aLong);
	}
}
