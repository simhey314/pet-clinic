package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
