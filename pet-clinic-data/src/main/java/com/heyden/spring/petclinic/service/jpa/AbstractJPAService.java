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

	@Override
	public Set<T> findAll() {
		final Set<T> values = new HashSet<>();
		repository.findAll().iterator().forEachRemaining(values::add);
		return values;
	}

	@Override
	@Nullable
	public T findById(final ID id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public T save(final T entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(final T entity) {
		repository.save(entity);
	}

	@Override
	public void deleteById(final ID id) {
		repository.deleteById(id);
	}
}
