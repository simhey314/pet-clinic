package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Speciality;
import com.heyden.spring.petclinic.service.SpecialityService;
import org.springframework.stereotype.Service;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

}
