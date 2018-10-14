package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.service.OwnerService;
import com.heyden.spring.petclinic.service.PetService;
import com.heyden.spring.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

	private PetTypeService petTypeService;
	private PetService petService;

	public OwnerMapService(final PetTypeService petTypeService, final PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

	@Override
	@Nullable
	public Owner findByLastName(final String lastName) {
		return map.values().stream()
				.filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
				.findFirst()
				.orElse(null);
	}

	@Override
	public List<Owner> findAllByLastNameLike(final String lastName) {
		return map.values().stream()
				.filter(owner -> owner.getLastName() != null && owner.getLastName().contains(lastName))
				.collect(Collectors.toList());
	}

	@Override
	@Nullable
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
