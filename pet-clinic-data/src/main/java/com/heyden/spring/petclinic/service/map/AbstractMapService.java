package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.BaseEntity;
import com.heyden.spring.petclinic.service.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity<ID>, ID> implements CrudService<T, ID> {
	protected Map<ID, T> map = new HashMap<>();

	@Override
	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}

	@Override
	public T findById(final ID id) {
		return map.get(id);
	}

	@Override
	public T save(final T entity) {
		return map.put(entity.getId(), entity);
	}

	@Override
	public void deleteById(final ID id) {
		map.remove(id);
	}

	@Override
	public void delete(final T entity) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(entity));
	}
}
