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
		LOGGER.info("Loaded PetTypes to service: " + petTypeService.getClass().getSimpleName());

		final Pet pet1 = aPet()
				.withName("Scoobi Doo")
				.withPetType(dog)
				.withBirthDate(LocalDate.now())
				.build();

		final Owner owner1 = aOwner()
				.withFirstName("First").withLastName("Owner1")
				.withStreet("Street").withCity("City").withZip("12345")
				.withTelephone("+491234567890")
				.withPet(pet1)
				.build();
		ownerService.save(owner1);

		final Pet pet2 = aPet()
				.withName("Kitty")
				.withPetType(cat)
				.withBirthDate(LocalDate.now())
				.build();

		final Owner owner2 = aOwner()
				.withFirstName("Second").withLastName("Owner2")
				.withStreet("Road").withCity("Village").withZip("654321")
				.withTelephone("+499876543210")
				.withPet(aPet()
						.withName("Pussy")
						.withPetType(cat)
						.withBirthDate(LocalDate.now())
				).withPet(pet2).withPet(aPet()
						.withName("Bud")
						.withPetType(dog)
						.withBirthDate(LocalDate.now())
				).build();
		ownerService.save(owner2);
		LOGGER.info("Loaded Owners to service: " + ownerService.getClass().getSimpleName());

		final Visit visit1 = aVisit().withDescription("Get a new injection for love and happiness.").withDate(LocalDate.now()).withPet(pet1).build();
		visitService.save(visit1);

		final Visit visit2 = aVisit().withDescription("Repair the left leg").withDate(LocalDate.now()).withPet(pet2).build();
		visitService.save(visit2);
		LOGGER.info("Loaded Visits to service: " + visitService.getClass().getSimpleName());
	}

	private void loadVets() {
		final Speciality radiology = new Speciality("Radiology");
		specialityService.save(radiology);
		final Speciality surgery = new Speciality("Surgery");
		specialityService.save(surgery);
		final Speciality dentistry = new Speciality("Dentistry");
		specialityService.save(dentistry);
		LOGGER.info("Loaded Specialities to service: " + specialityService.getClass().getSimpleName());

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
		LOGGER.info("Loaded Vets to service: " + vetService.getClass().getSimpleName());
	}
}
