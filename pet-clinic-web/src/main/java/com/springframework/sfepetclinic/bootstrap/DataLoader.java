package com.springframework.sfepetclinic.bootstrap;

import com.springframework.sfepetclinic.model.Owner;
import com.springframework.sfepetclinic.model.Vet;
import com.springframework.sfepetclinic.services.OwnerService;
import com.springframework.sfepetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Josh");
        owner1.setLastName("Wellington");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Rob");
        owner2.setLastName("Peterson");

        ownerService.save(owner2);

        System.out.println("Loaded all owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Scot");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lauren");
        vet2.setLastName("Hailey");

        vetService.save(vet2);

        System.out.println("Loaded all vets...");
    }
}
