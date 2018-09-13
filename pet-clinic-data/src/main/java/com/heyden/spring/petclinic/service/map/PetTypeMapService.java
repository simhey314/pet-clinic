package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.PetType;
import com.heyden.spring.petclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

}
