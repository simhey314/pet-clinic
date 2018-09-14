package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
