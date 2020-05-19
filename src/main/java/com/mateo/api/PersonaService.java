package com.mateo.api;

import java.util.List;

import com.mateo.dto.Persona;

public interface PersonaService {
	
	void addPersona(Persona p);
	
	void deletePersona (int id);
	
	List<Persona> getAllPersonas();

}
