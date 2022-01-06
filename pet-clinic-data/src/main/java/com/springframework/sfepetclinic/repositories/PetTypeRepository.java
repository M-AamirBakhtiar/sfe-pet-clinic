package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
