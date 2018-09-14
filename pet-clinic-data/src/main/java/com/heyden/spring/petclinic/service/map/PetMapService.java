package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
