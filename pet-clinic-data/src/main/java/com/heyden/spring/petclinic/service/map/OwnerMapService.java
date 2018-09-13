package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;
import com.heyden.spring.petclinic.service.PetService;
import com.heyden.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private PetTypeService petTypeService;
	private PetService petService;

	public OwnerMapService(final PetTypeService petTypeService, final PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	public Owner findByLastName(final String lastName) {
		return null;
	}

	@Override
	public Owner save(final Owner entity) {
		if (entity == null) {
			return null;
		}

		if (entity.getPets() != null && !entity.getPets().isEmpty()) {
			entity.getPets().forEach(pet -> {
				if (pet.getPetType() == null) {
					throw new IllegalStateException("Pet type is required for: " + pet);
				} else {
					if (pet.getPetType().getId() == null) {
						petTypeService.save(pet.getPetType());
					}
				}
				if (pet.getId() == null) {
					petService.save(pet);
				}
			});
		}

		return super.save(entity);
	}
}
