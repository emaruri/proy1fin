package com.unbosque.info.dao;

import java.util.List;

import com.unbosque.info.entidad.Usuario;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUsuario(Usuario usuario) {
        getSessionFactory().getCurrentSession().save(usuario);

    }

    public void deleteUsuario(Usuario usuario) {
        getSessionFactory().getCurrentSession().delete(usuario);
    }

    public void updateUsuario(Usuario usuario) {
        getSessionFactory().getCurrentSession().update(usuario);
    }

    	
    public Usuario getUsuarioById(int id) {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Usuario where id=?").setParameter(0, id)
                .list();
        return (Usuario) list.get(0);
    }
    
    public Usuario getUsuarioByname(String name){
    	try{
    	List list=getSessionFactory().getCurrentSession()
    			.createQuery("from Usuario where login=?").setParameter(0, name)
    			.list();
    	return(Usuario)list.get(0);
    	}
    	catch(IndexOutOfBoundsException e){
    		return null;
    	}
    	
    	
    }
    
    public Usuario getUsuarioByLogin(String login,String password){
    	try{
    	List list=getSessionFactory().getCurrentSession()
    			.createQuery("from Usuario where login=? and password=?").setParameter(0, login).setParameter(1, password)
    			.list();
    	return (Usuario)list.get(0);
    	}
    	catch(IndexOutOfBoundsException e){
    		return null;
    	}
    }
    
    
    public Usuario getUsuarioByEmail(String login,String correo){
    	try{
    	List list=getSessionFactory().getCurrentSession()
    			.createQuery("from Usuario where login=? and correo=?").setParameter(0, login).setParameter(1, correo)
    			.list();
    	return (Usuario)list.get(0);
    	}
    	catch(IndexOutOfBoundsException e){
    		return null;
    	}
    }

    public List<Usuario> getUsuarios() {
        List list = getSessionFactory().getCurrentSession()
                .createQuery("from Usuario").list();
        return list;
    }

}
