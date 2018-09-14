package com.heyden.spring.petclinic.bootstrap;

import com.heyden.spring.petclinic.entity.Owner;
import com.heyden.spring.petclinic.entity.Pet;
import com.heyden.spring.petclinic.entity.PetType;
import com.heyden.spring.petclinic.entity.Speciality;
import com.heyden.spring.petclinic.entity.Vet;
import com.heyden.spring.petclinic.entity.Visit;
import com.heyden.spring.petclinic.service.OwnerService;
import com.heyden.spring.petclinic.service.PetTypeService;
import com.heyden.spring.petclinic.service.SpecialityService;
import com.heyden.spring.petclinic.service.VetService;
import com.heyden.spring.petclinic.service.VisitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static com.heyden.spring.petclinic.bootstrap.OwnerBuilder.aOwner;
import static com.heyden.spring.petclinic.bootstrap.PetBuilder.aPet;
import static com.heyden.spring.petclinic.bootstrap.VetBuilder.aVet;
import static com.heyden.spring.petclinic.bootstrap.VisitBuilder.aVisit;

@Component
public class DataLoader implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);

	private OwnerService ownerService;
	private VetService vetService;
	private PetTypeService petTypeService;
	private SpecialityService specialityService;
	private VisitService visitService;

	public DataLoader(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService, final SpecialityService specialityService, final VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialityService = specialityService;
		this.visitService = visitService;
	}

	@Override
	public void run(final String... args) {

		loadOwners();
		loadVets();
	}

	private void loadOwners() {
		final PetType cat = new PetType("Cat");
		petTypeService.save(cat);
		final PetType dog = new PetType("Dog");
		petTypeService.save(dog);
		LOGGER.info("Loaded PetTypes to map service");

		final Owner owner1 = aOwner()
				.withFirstName("First").withLastName("Owner")
				.withStreet("Street").withCity("City").withZip("12345")
				.withTelephone("+491234567890")
				.withPet(aPet()
						.withName("Scoobi Doo")
						.withPetType(dog)
						.withBirthDate(LocalDate.now())
				).build();
		ownerService.save(owner1);
		final Owner owner2 = aOwner()
				.withFirstName("Second").withLastName("Owner")
				.withStreet("Road").withCity("Village").withZip("654321")
				.withTelephone("+499876543210")
				.withPet(aPet()
						.withName("Pussy")
						.withPetType(cat)
						.withBirthDate(LocalDate.now())
				).withPet(aPet()
						.withName("Kitty")
						.withPetType(cat)
						.withBirthDate(LocalDate.now())
				).withPet(aPet()
						.withName("Bud")
						.withPetType(dog)
						.withBirthDate(LocalDate.now())
				).build();
		ownerService.save(owner2);
		LOGGER.info("Loaded Owners to map service");

		Pet pet = owner1.getPets().iterator().next();
		final Visit visit1 = aVisit().withDescription("Get a new injection for love and happiness.").withDate(LocalDate.now()).withPet(pet).build();
		visitService.save(visit1);
		pet = owner2.getPets().iterator().next();
		final Visit visit2 = aVisit().withDescription("Repair the left leg").withDate(LocalDate.now()).withPet(pet).build();
		visitService.save(visit2);
		LOGGER.info("Loaded Visits to map service");
	}

	private void loadVets() {
		final Speciality radiology = new Speciality("Radiology");
		specialityService.save(radiology);
		final Speciality surgery = new Speciality("Surgery");
		specialityService.save(surgery);
		final Speciality dentistry = new Speciality("Dentistry");
		specialityService.save(dentistry);
		LOGGER.info("Loaded Specialities to map service");

		final Vet vet1 = aVet()
				.withFirstName("First").withLastName("Vet")
				.withStreet("Vetstreet").withCity("Vetcity").withZip("01234")
				.withTelephone("+491237894560")
				.withSpeciality(dentistry).withSpeciality(radiology)
				.build();
		vetService.save(vet1);
		final Vet vet2 = aVet()
				.withFirstName("Second").withLastName("Vet")
				.withStreet("Vetavenue").withCity("Vetmetropole").withZip("99999")
				.withTelephone("+49111222333444")
				.withSpeciality(surgery).withSpeciality(radiology)
				.build();
		vetService.save(vet2);
		LOGGER.info("Loaded Vets to map service");
	}
}
