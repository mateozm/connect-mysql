package com.mateo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mateo.dto.Persona;
import com.mateo.repository.PersonaRepository;
import com.mateo.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {	

    
    private PersonaRepository personaRepository;
    
    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}

    @Override
    @CacheEvict(value = "personas",allEntries = true) 
    public void addPersona(Persona persona) {
     
    	personaRepository.save(persona);
    }


    @Override
    @CacheEvict(value = "personas",allEntries = true) 
    public void deletePersona(int  id) {
        personaRepository.deleteById(id);       
    }


	@Override
	@Cacheable(value = "personas", key= "#edad")
	public List<Persona> getAllPersonas(int edad) {
		
		List<Persona> personas = new ArrayList<>();
		
		System.out.print("going to db");
		
		personas = personaRepository.findAll();
		
		return personas.stream().filter(p -> p.getEdad() > edad).collect(Collectors.toList());
		
		
	}


	@Override
	@Cacheable(value = "person", key= "#id")
	public Optional<Persona> findById(int id) {
		
		System.out.print("going to db 2");
		
		return personaRepository.findById(id);

	}

	@Override
	@CacheEvict(value = "personas",allEntries = true) 
	public void updatePersona(Persona persona) {
		
		personaRepository.save(persona);
		
	}



}
