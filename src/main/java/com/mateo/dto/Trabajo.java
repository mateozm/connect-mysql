package com.mateo.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Trabajo implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3235758845620316917L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_trabajo")
	private int idTrabajo;
	
	@Column(name="nombreTrabajo")
	private String nombreTrabajo;

	public int getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}


	
	
	
	
	
	
	
	

	

}
