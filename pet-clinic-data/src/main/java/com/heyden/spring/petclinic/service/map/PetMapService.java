package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.service.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

}
