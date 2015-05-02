package com.unbosque.info.entidad;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the proyecto database table.
 * 
 */
@Entity
@NamedQuery(name="Proyecto.findAll", query="SELECT p FROM Proyecto p")
public class Proyecto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String estado;

	private Integer id;

	@Column(name="id_ciudad")
	private Integer idCiudad;

	@Column(name="id_dpto")
	private Integer idDpto;

	private String nombre;

	public Proyecto() {
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Integer getIdDpto() {
		return this.idDpto;
	}

	public void setIdDpto(Integer idDpto) {
		this.idDpto = idDpto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}