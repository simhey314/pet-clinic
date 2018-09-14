package com.heyden.spring.petclinic.service.jpa;

import com.heyden.spring.petclinic.service.CrudService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractJPAService<T, ID, R extends CrudRepository<T, ID>> implements CrudService<T, ID> {

	protected R repository;

	public AbstractJPAService(final R repository) {
		this.repository = repository;
	}

	public Set<T> findAll() {
		Set<T> values = new HashSet<>();
		repository.findAll().iterator().forEachRemaining(values::add);
		return values;
	}

	@Nullable
	public T findById(ID id) {
		return repository.findById(id).orElse(null);
	}

	public T save(T entity) {
		return repository.save(entity);
	}

	public void delete(T entity) {
		repository.save(entity);
	}

	public void deleteById(ID id) {
		repository.deleteById(id);
	}
}
