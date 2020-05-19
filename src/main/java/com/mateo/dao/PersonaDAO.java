package com.mateo.dao;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.*;

import com.mateo.dto.Persona;

@Repository
public interface PersonaDAO extends CrudRepository<Persona,Integer> {
	
	List<Persona>findAll();

}
