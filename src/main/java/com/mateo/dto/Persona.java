package com.mateo.dto;



import java.io.Serializable;

import javax.persistence.*;


@Entity
public class Persona implements Serializable{	

	/**
	 * 
	 */
	private static final long serialVersionUID = 6525261396590677401L;

	@Id
	@Column(name="dni")
	private int dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;
	
	@Column(name="idTrabajo")
	private int idTrabajo;
	
	@OneToOne
	 @JoinColumn(name = "idTrabajo", referencedColumnName = "idTrabajo", insertable = false, updatable = false)
	private Trabajo trabajo;

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(int idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public String toString() {
		return "Persona{" +
				"dni=" + dni +
				", nombre='" + nombre + '\'' +
				", edad=" + edad +
				", idTrabajo=" + idTrabajo +
				", trabajo=" + trabajo +
				'}';
	}
}
