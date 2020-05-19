package com.mateo.adapter;

import java.util.ArrayList;
import java.util.List;

import com.mateo.dto.Persona;
import com.mateo.http.PersonaResponse;


public class PersonaAdapter {
	
	
	public PersonaResponse convert(List<Persona> personas) {
		PersonaResponse response = new PersonaResponse();

		response.setPersonas(personas);

		return response;

	}

}
