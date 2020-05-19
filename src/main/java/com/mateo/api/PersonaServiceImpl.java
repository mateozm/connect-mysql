package com.mateo.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.mateo.dao.PersonaDAO;
import com.mateo.dto.Persona;


@Service
public class PersonaServiceImpl implements PersonaService {
	
   // private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private PersonaDAO personaDAO;

    @Override
    @CacheEvict(value = "persona",allEntries = true) 
    public void addPersona(Persona persona) {
       // logger.info("adding book with id - {}", book.getId());
    	personaDAO.save(persona);
    }


    @Override
    @CacheEvict(value = "persona",allEntries = true) 
    public void deletePersona(int id) {
        personaDAO.deleteById(id);       
    }


	@Override
	@Cacheable(cacheNames = "personas")
	public List<Persona> getAllPersonas() {
		
		System.out.print("going to db");
		
		return personaDAO.findAll();
		
		
	}

}
