package com.mateo.adapter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mateo.dto.Persona;
import com.mateo.http.PersonaRequest;
import com.mateo.http.PersonaResponse;

@Component
public class PersonaAdapter {
	
	
	public PersonaResponse convert(List<Persona> personas) {
		PersonaResponse response = new PersonaResponse();

		response.setPersonas(personas);

		return response;

	}
	
	public Persona convertPersona(PersonaRequest p) {
		
		Persona persona = new Persona();
		persona.setDni(p.getDni());
		persona.setEdad(p.getEdad());
		persona.setNombre(p.getNombre());
		persona.setId_trabajo(p.getId_trabajo());
		
		return persona;
		
	}

}
