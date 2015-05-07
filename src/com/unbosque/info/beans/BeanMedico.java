package com.unbosque.info.beans;

import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class BeanMedico {
	
private Date fecha;
private String tipoPaciente;
private String nombresApellidos;
private String cedula;
private String direccion;
private String correo;
private String ocupacion;
private String enfermedad;



public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getTipoPaciente() {
	return tipoPaciente;
}
public void setTipoPaciente(String tipoPaciente) {
	this.tipoPaciente = tipoPaciente;
}
public String getNombresApellidos() {
	return nombresApellidos;
}
public void setNombresApellidos(String nombresApellidos) {
	this.nombresApellidos = nombresApellidos;
}
public String getCedula() {
	return cedula;
}
public void setCedula(String cedula) {
	this.cedula = cedula;
}
public String getDireccion() {
	return direccion;
}
public void setDireccion(String direccion) {
	this.direccion = direccion;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getOcupacion() {
	return ocupacion;
}
public void setOcupacion(String ocupacion) {
	this.ocupacion = ocupacion;
}
public String getEnfermedad() {
	return enfermedad;
}
public void setEnfermedad(String enfermedad) {
	this.enfermedad = enfermedad;
}



}
