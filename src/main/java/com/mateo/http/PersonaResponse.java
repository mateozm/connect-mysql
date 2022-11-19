package com.mateo.http;

import java.util.List;

import com.mateo.dto.Persona;

public class PersonaResponse {
	
	private List<Persona> personas;
	
	public List<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}

	@Override
	public String toString() {
		return "PersonaResponse{" +
				"personas=" + personas +
				'}';
	}
}
