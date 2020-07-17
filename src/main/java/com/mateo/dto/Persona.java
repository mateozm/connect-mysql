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
	
	@Column(name="id_trabajo")
	private int id_trabajo;
	
	@OneToOne
	 @JoinColumn(name = "id_trabajo", referencedColumnName = "id_trabajo", insertable = false, updatable = false)
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
	
	public int getId_trabajo() {
		return id_trabajo;
	}

	public void setId_trabajo(int id_trabajo) {
		this.id_trabajo = id_trabajo;
	}

	public Trabajo getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}

	@Override
	public String toString() {
		
		return "nombre: " + nombre + " edad: " + edad + " trabajo: " + trabajo.getNombreTrabajo();
	}	

	
	


	
	
	
}
