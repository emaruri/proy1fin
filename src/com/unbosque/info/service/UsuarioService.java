package com.unbosque.info.service;

import java.util.Arrays;
import java.util.List;

import com.unbosque.info.dao.UsuarioDAO;
import com.unbosque.info.entidad.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// actionListener="#{actorsMB.remove(item)}"
@Service("UsuarioService")
@Transactional(readOnly = true)
public class UsuarioService {
	
	
    // CustomerDAO is injected...
    @Autowired
    UsuarioDAO usuarioDAO;
    private final static String[] tippos=new String[]{"A","U"};
    private final static String[] estados=new String[]{"A","I"};




	@Transactional(readOnly = false)
    public void addUsuario(Usuario usuario) {
        getUsuarioDAO().addUsuario(usuario);
    }

    @Transactional(readOnly = false)
    public void deleteUsuario(Usuario usuario) {
        getUsuarioDAO().deleteUsuario(usuario);
    }

    @Transactional(readOnly = false)
    public void updateUsuario(Usuario usuario) {
        getUsuarioDAO().updateUsuario(usuario);
    }

    @Transactional(readOnly = false)
    public Usuario getUsuarioById(int id) {
        return getUsuarioDAO().getUsuarioById(id);
    }
    @Transactional(readOnly = false)
    public Usuario getUsuarioByLogin(String login,String password) {
        return getUsuarioDAO().getUsuarioByLogin(login,password);
    }
    
    @Transactional(readOnly = false)
    public Usuario getUsuarioByEmail(String login,String correo){
    	return getUsuarioDAO().getUsuarioByEmail(login, correo);
    }
    
    public List<Usuario> getUsuarios() {
        return getUsuarioDAO().getUsuarios();
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    public List<String> getTippos() {
		return Arrays.asList(tippos);
	}
	public List<String> getEstados() {
		 return Arrays.asList(estados);
	}
}
