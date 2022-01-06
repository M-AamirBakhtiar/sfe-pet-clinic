package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
