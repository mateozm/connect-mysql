package com.mateo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mateo.adapter.PersonaAdapter;
import com.mateo.dto.Persona;
import com.mateo.http.PersonaRequest;
import com.mateo.http.PersonaResponse;
import com.mateo.service.PersonaService;

import javassist.NotFoundException;

@RestController
@RequestMapping(value="/prueba")
public class ServiceController {

	
	private PersonaService personaService;		
	private PersonaAdapter personaAdapter;
	

	
	@Autowired
	public ServiceController(PersonaService personaService, PersonaAdapter personaAdapter) {
		this.personaService = personaService;
		this.personaAdapter = personaAdapter;

	}
	
	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	public PersonaResponse getPersonas()
	{
		List<Persona> personas = personaService.getAllPersonas();
		
		PersonaAdapter adapter = new PersonaAdapter();
		
		return adapter.convert(personas);
	}
	
	@RequestMapping(value = "/persona/{id}", method = RequestMethod.GET)
	public Persona getPersona(@PathVariable(value = "id") int personaId )
	{
		Optional<Persona> persona =
		        personaService
		            .findById(personaId);
		
		return persona.isPresent() ? persona.get() : null;
	}
	
	@RequestMapping(value = "/persona/create", method = RequestMethod.POST)
	public Map<String, Boolean>  createPersona(@RequestBody PersonaRequest persona)
	{
		
		personaService.addPersona(personaAdapter.convertPersona(persona));
		
		 Map<String, Boolean> response = new HashMap<>();
		    response.put("created", Boolean.TRUE);
		    return response;

	}
	
	@RequestMapping(value = "/persona/update", method = RequestMethod.PUT)
	public Map<String, Boolean>  updatePersona(@RequestBody PersonaRequest p) throws NotFoundException
	{
		  Persona persona =
			        personaService
			            .findById(p.getDni())
			            .orElseThrow(() -> new NotFoundException("Persona not found on :: " + p.getDni()));
		
		
		personaService.updatePersona(personaAdapter.convertPersona(p));
		
		 Map<String, Boolean> response = new HashMap<>();
		    response.put("updated", Boolean.TRUE);
		    return response;

	}
	
	@RequestMapping(value = "/persona/delete/{id}", method = RequestMethod.DELETE)
	public Map<String, Boolean> deletePersona(@PathVariable(value = "id") int personaId) throws NotFoundException
	{
		
		  Persona persona =
			        personaService
			            .findById(personaId)
			            .orElseThrow(() -> new NotFoundException("Persona not found on :: " + personaId));
		

		    personaService.deletePersona(personaId);
		    Map<String, Boolean> response = new HashMap<>();
		    response.put("deleted", Boolean.TRUE);
		    return response;

	}
	


}
