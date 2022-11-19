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
	@Column(name = "idTrabajo")
	private Integer idTrabajo;

	@Column(name = "nombreTrabajo")
	private String nombreTrabajo;


	public Integer getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	@Override
	public String toString() {
		return "Trabajo{" +
				"idTrabajo=" + idTrabajo +
				", nombreTrabajo='" + nombreTrabajo + '\'' +
				'}';
	}
}
