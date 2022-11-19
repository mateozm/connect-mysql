package com.mateo.service.impl;

import com.mateo.repository.PersonaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class PersonaServiceImplTest {

    private PersonaServiceImpl personaService;

    private PersonaRepository personaRepository;

    @BeforeEach
    private void setup(){

        personaRepository =Mockito.mock(PersonaRepository.class);

        personaService = new PersonaServiceImpl(personaRepository);

    }

    @Test
    public void test(){
        when(personaRepository.findAll()).thenReturn(new ArrayList<>());

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> personaService.getAllPersonas(1)
        );

        assertTrue(thrown.getMessage().contains("Stuff"));
    }


}