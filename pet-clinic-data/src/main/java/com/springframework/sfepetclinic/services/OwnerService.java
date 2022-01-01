package com.springframework.sfepetclinic.services;

import com.springframework.sfepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
