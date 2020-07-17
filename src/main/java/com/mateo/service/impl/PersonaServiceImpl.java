package com.mateo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	@Cacheable(cacheNames = "personas")
	public List<Persona> getAllPersonas() {
		
		List<Persona> personas = new ArrayList<>();
		
		System.out.print("going to db");
		
		personas = personaRepository.findAll();
		
		return personas;
		
		
	}


	@Override
	public Optional<Persona> findById(int id) {
		
		return personaRepository.findById(id);

	}

	@Override
	@CacheEvict(value = "personas",allEntries = true) 
	public void updatePersona(Persona persona) {
		
		personaRepository.save(persona);
		
	}



}
