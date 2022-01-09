package com.springframework.sfepetclinic.services.springdatajpa;

import com.springframework.sfepetclinic.model.Owner;
import com.springframework.sfepetclinic.repositories.OwnerRepository;
import com.springframework.sfepetclinic.repositories.PetRepository;
import com.springframework.sfepetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner mockOwner;

    @BeforeEach
    void setUp() {
        mockOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {

        when(ownerRepository.findByLastName(any())).thenReturn(mockOwner);

        Owner owner = ownerSDJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> mockOwners = new HashSet<>();
        mockOwners.add(Owner.builder().id(1L).build());
        mockOwners.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(mockOwners);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(mockOwner));

        Owner owner = ownerSDJpaService.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(mockOwner);

        Owner owner = ownerSDJpaService.save(ownerToSave);

        assertNotNull(owner);
    }

    @Test
    void delete() {

        ownerSDJpaService.delete(mockOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerSDJpaService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}
