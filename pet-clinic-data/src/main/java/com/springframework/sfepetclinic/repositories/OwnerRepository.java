package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
