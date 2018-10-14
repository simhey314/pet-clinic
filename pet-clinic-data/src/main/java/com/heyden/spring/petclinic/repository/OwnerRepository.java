package com.heyden.spring.petclinic.repository;

import com.heyden.spring.petclinic.entity.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

	Owner findByLastNameLike(String lastName);

	List<Owner> findAllByLastNameContainingIgnoreCase(String lastName);
}
