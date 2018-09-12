package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.service.OwnerService;
import com.heyden.spring.petclinic.service.VetService;
import com.heyden.spring.petclinic.service.map.OnwerMapService;
import com.heyden.spring.petclinic.service.map.VetMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

	private OwnerService ownerService;
	private VetService vetService;

	public DataLoader() {
		ownerService = new OnwerMapService();
		vetService = new VetMapService();
	}

	@Override
	public void run(final String... args) {
		Owner owner = new Owner("First", "Owner");
		owner.setId(1L);
		ownerService.save(owner);
		owner = new Owner("Second", "Owner");
		owner.setId(2L);
		ownerService.save(owner);

		LOGGER.info("Loaded Owners to map service");

		Vet vet = new Vet("First", "Vet");
		vet.setId(1L);
		vetService.save(vet);
		vet = new Vet("Second", "Vet");
		vet.setId(2L);
		vetService.save(vet);

		LOGGER.info("Loaded Vets to map service");
	}
}
