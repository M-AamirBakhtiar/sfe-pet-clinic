package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
