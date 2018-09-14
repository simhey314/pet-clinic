package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.service.SpecialityService;
import com.heyden.spring.petclinic.service.VetService;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

	private SpecialityService specialityService;

	public VetMapService(final SpecialityService specialityService) {
		this.specialityService = specialityService;
	}

	@Override
	@Nullable
	public Vet save(final Vet entity) {
		if (entity == null) {
			return null;
		}

		if (entity.getSpecialities() != null && !entity.getSpecialities().isEmpty()) {
			entity.getSpecialities().forEach(speciality -> {
				if (speciality.getId() == null) {
					specialityService.save(speciality);
				}
			});
		}

		return super.save(entity);
	}
}
