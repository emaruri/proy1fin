package com.unbosque.info.beans;

import java.util.List;

import com.unbosque.info.entidad.Dieta;

public class BeanDieta {
	
private String nombre;
private String trataEnfermedad;
private String descripcion;

List<Dieta> dietaList= null;
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTrataEnfermedad() {
	return trataEnfermedad;
}
public void setTrataEnfermedad(String trataEnfermedad) {
	this.trataEnfermedad = trataEnfermedad;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}


}
