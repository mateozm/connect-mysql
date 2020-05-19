package com.mateo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mateo.adapter.PersonaAdapter;
import com.mateo.api.PersonaService;
import com.mateo.dao.PersonaDAO;
import com.mateo.dto.Persona;
import com.mateo.http.PersonaResponse;

@RestController
@RequestMapping(value="/prueba")
public class ServiceController {

	@Autowired
	PersonaService personaService;	
	
	@RequestMapping(value = "/personas")
	public PersonaResponse getPersonas()
	{
		List<Persona> personas = personaService.getAllPersonas();
		
		PersonaAdapter adapter = new PersonaAdapter();
		
		return adapter.convert(personas);
	}

}
