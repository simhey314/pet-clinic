package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.PetType;
import com.heyden.spring.petclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
