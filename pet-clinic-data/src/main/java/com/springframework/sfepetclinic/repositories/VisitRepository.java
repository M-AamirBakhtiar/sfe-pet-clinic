package com.springframework.sfepetclinic.repositories;

import com.springframework.sfepetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
