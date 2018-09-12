package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.BaseEntity;
import com.heyden.spring.petclinic.service.CrudService;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {
	protected Map<Long, T> map = new HashMap<>();

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

		if (entity == null) {
			throw new IllegalArgumentException("Entity cannot be null, cant save it");
		}

		if (entity.getId() == null) {
			entity.setId(getNextId());
		}

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

	private Long getNextId() {
		Long result = 1L;
		if (!map.entrySet().isEmpty()) {
			result = Collections.max(map.keySet()) + 1;
		}
		return result;
	}
}
