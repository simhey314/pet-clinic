package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Visit;
import com.heyden.spring.petclinic.service.VisitService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

	@Override
	@Nullable
	public Visit save(final Visit entity) {
		if (entity == null) {
			return null;
		} else if (entity.getPet() == null || entity.getPet().getId() == null || entity.getPet().getOwner() == null || entity.getPet().getOwner().getId() == null) {
			throw new IllegalStateException("The entity contains unsaved or null child entities, cannot proceed");
		}

		return super.save(entity);
	}
}
