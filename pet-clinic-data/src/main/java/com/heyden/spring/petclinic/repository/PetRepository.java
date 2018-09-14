package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
