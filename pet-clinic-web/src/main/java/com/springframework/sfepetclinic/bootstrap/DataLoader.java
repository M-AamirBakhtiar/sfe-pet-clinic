package com.springframework.sfepetclinic.bootstrap;

import com.springframework.sfepetclinic.model.*;
import com.springframework.sfepetclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry  = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Josh");
        owner1.setLastName("Wellington");
        owner1.setAddress("444 Backers Street");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("555-555-8989");


        Pet joshsPet = new Pet();
        joshsPet.setPetType(savedCatPetType);
        joshsPet.setOwner(owner1);
        joshsPet.setBirthDate(LocalDate.now());
        joshsPet.setName("Lina");
        owner1.getPets().add(joshsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rob");
        owner2.setLastName("Peterson");
        owner2.setAddress("4th to 5th Ave");
        owner2.setCity("New York");
        owner2.setTelephone("444-1236-5487");

        Pet robsPet = new Pet();
        robsPet.setPetType(savedDogPetType);
        robsPet.setOwner(owner2);
        robsPet.setBirthDate(LocalDate.now());
        robsPet.setName("Courage");
        owner2.getPets().add(robsPet);

        ownerService.save(owner2);

        Visit dogVisit = new Visit();
        dogVisit.setPet(robsPet);
        dogVisit.setDate(LocalDate.now());
        dogVisit.setDescription("Sneeze Dog");

        visitService.save(dogVisit);

        System.out.println("Loaded all owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Scot");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lauren");
        vet2.setLastName("Hailey");
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded all vets...");
    }
}
