package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
