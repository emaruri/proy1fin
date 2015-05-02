package com.unbosque.info.dao;

import com.unbosque.info.entidad.Proyecto;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectoDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addProyecto(Proyecto Proyecto) {
		getSessionFactory().getCurrentSession().save(Proyecto);

	}

	public void deleteProyecto(Proyecto Proyecto) {
		getSessionFactory().getCurrentSession().delete(Proyecto);
	}

	public void updateProyecto(Proyecto Proyecto) {
		getSessionFactory().getCurrentSession().update(Proyecto);
	}

	public Proyecto getProyectoById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Proyecto where id=?").setParameter(0, id)
				.list();
		return (Proyecto) list.get(0);
	}

	public List<Proyecto> getProyectos() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Proyecto").list();
		return list;
	}

}