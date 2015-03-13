package com.vaannila.domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="tarea")
public class Tarea {

	@Id
	private Long id;
	private String nombre;
	private String descripcion;
	private Boolean hecha;
	private Integer tipoTarea;

	
	
	public Tarea () {

	}
	
	@Id
	@GeneratedValue
	@Column(name="id")	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="nombre")
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Column(name="descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Column(name="hecha")
	public Boolean getHecha() {
		return hecha;
	}
	public void setHecha(Boolean hecha) {
		this.hecha = hecha;
	}
	
	@Column(name="tipo_tarea")
	public Integer getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(Integer tipoTarea) {
		this.tipoTarea = tipoTarea;
	}


}
