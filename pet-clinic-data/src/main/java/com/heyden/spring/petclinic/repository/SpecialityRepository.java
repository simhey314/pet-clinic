package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
