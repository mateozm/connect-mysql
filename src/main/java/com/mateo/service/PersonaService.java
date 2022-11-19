package com.mateo.service;

import java.util.List;
import java.util.Optional;

import com.mateo.dto.Persona;

public interface PersonaService {
	
	void addPersona(Persona p);
	
	void deletePersona (int id);
	
	List<Persona> getAllPersonas(int edad);
	
	Optional<Persona> findById(int id);
	
	void updatePersona(Persona p);
	


}
