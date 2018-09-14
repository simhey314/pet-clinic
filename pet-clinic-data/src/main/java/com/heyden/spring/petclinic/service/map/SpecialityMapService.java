package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Speciality;
import com.heyden.spring.petclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
