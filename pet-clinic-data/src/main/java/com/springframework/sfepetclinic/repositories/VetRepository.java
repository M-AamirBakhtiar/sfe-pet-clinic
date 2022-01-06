package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
