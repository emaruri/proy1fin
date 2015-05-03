package com.unbosque.info.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.dao.DataAccessException;



import com.unbosque.info.entidad.Usuario;
import com.unbosque.info.service.UsuarioService;
import com.unbosque.info.util.CifrarClave;

@ManagedBean(name = "usuarioMBController")
@ViewScoped
public class UsuarioManagedBean implements Serializable   {



	/**
	 * 
	 */
	private static final long serialVersionUID = -833450576444506528L;

	// Spring Customer Service is injected...
	@ManagedProperty(value = "#{UsuarioService}")
	UsuarioService usuarioService;


	List<Usuario> usuarioList=null;
	private CifrarClave cif=new CifrarClave();
	private Integer id;
	private String apellidosNombres;
	private String correo;
	private String estado;
	private Timestamp fechaClave;
	private Timestamp fechaCreacion;
	private String login;
	private String password;
	private String tipoUsuario;
	private Date  fecha = new Date();
	private String loginn;
	private String passwordn;
	private String correon;
	private String ApellidosNombresn;
	
	@PostConstruct
	public void init(){
		usuarioList = new ArrayList<Usuario>();
		  usuarioList.addAll(getUsuarioService().getUsuarios());
	}

    public void onCellEdit(Usuario usuario1) {
    	Usuario comp=getUsuarioService().getUsuarioById(usuario1.getId());
    	if(!comp.getPassword().equals(usuario1.getPassword()))
    	{
    		usuario1.setPassword(cif.cifradoClave(usuario1.getPassword()));
    	}
    	getUsuarioService().updateUsuario(usuario1);
    	
    }

	
	public String getLoginn() {
		return loginn;
	}

	public void setLoginn(String loginn) {
		this.loginn = loginn;
	}
    

	
	public void addUsuario() {
		try {

			RequestContext context = RequestContext.getCurrentInstance();
			FacesMessage message = null;
			
			Usuario usuario = new Usuario();
			
			
			usuario.setApellidosNombres(getApellidosNombres());
			usuario.setCorreo(getCorreo());
			usuario.setEstado("A");  
	        usuario.setFechaClave(new Timestamp(fecha.getTime())); 
     		usuario.setFechaCreacion(new Timestamp(fecha.getTime())); 
		
			usuario.setLogin(getLogin()); 
			usuario.setPassword(cif.cifradoClave(getPassword())); 
			usuario.setTipoUsuario("U"); 

			getUsuarioService().addUsuario(usuario);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Registro agregado exitosamente.");
			usuarioList=getUsuarioService().getUsuarios();

		} catch (DataAccessException e) {
			e.printStackTrace();
		}

	}
	
	public void verificar() throws IOException{
		RequestContext context = RequestContext.getCurrentInstance();
		ExternalContext extcont = FacesContext.getCurrentInstance().getExternalContext();
		
		FacesMessage message = null;
		
		Usuario usuario=getUsuarioService().getUsuarioByLogin(getLogin(),cif.cifradoClave(getPassword()));
		boolean logeado=false;
		if(usuario!=null){
		message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Correcto");
		logeado=true;
		if(usuario.getTipoUsuario().equals("A"))
		extcont.redirect("paneladmin.xhtml"); //redirigo
		else{
		extcont.redirect("panelusuario.xhtml");
		}
		}
		else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Incorrecto");
			
		}
		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("logeado", logeado);
		
	}

	
	public String getPasswordn() {
		return passwordn;
	}

	public void setPasswordn(String passwordn) {
		this.passwordn = passwordn;
	}

	public String getCorreon() {
		return correon;
	}

	public void setCorreon(String correon) {
		this.correon = correon;
	}

	public String getApellidosNombresn() {
		return ApellidosNombresn;
	}

	public void setApellidosNombresn(String apellidosNombresn) {
		ApellidosNombresn = apellidosNombresn;
	}

	public void borrar(Usuario usuario){
		getUsuarioService().deleteUsuario(usuario);
		usuarioList=getUsuarioService().getUsuarios();
	}
	
	
    public void reset() {
    	
    	this.setApellidosNombres("");
    	this.setCorreo("");
 
    	this.setLogin("");
    	this.setPassword("");
    	
    	      
    }
 public void reset2() {
    	
    	this.setApellidosNombres("");
    	this.setCorreo("");
        this.setEstado("");
    	this.setLogin("");
    	this.setPassword("");
    	this.setTipoUsuario("");
    	      
    }



	public List<Usuario> getUsuariosList() {
		usuarioList.addAll(getUsuarioService().getUsuarios());
		return usuarioList;
	}





	public UsuarioService getUsuarioService() {
		return usuarioService;
	}





	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}





	public List<Usuario> getUsuarioList() {

		return usuarioList;
	}

	


	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getApellidosNombres() {
		return apellidosNombres;
	}





	public void setApellidosNombres(String apellidosNombres) {
		this.apellidosNombres = apellidosNombres;
	}



	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}


	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getEstado() {
		return estado;
	}





	public void setEstado(String estado) {
		this.estado = estado;
	}



	public List<String> getTippos() {
		return getUsuarioService().getTippos();
	}

	public List<String> getEstados() {
		return getUsuarioService().getEstados();
	}

	
	public Timestamp getFechaClave() {
		return fechaClave;
	}





	public void setFechaClave(Timestamp fechaClave) {
		this.fechaClave = fechaClave;
	}





	public Timestamp getFechaCreacion() {
		return fechaCreacion;
	}





	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}





	




	public String getLogin() {
		return login;
	}





	public void setLogin(String login) {
		this.login = login;
	}





	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getTipoUsuario() {
		return tipoUsuario;
	}





	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	



}