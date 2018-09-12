package com.heyden.spring.petclinic.service.map;

import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.service.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

}
