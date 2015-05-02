package com.unbosque.info.dao;

import com.unbosque.info.entidad.Parametro;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ParametroDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void addParametro(Parametro Parametro) {
		getSessionFactory().getCurrentSession().save(Parametro);

	}

	public void deleteParametro(Parametro Parametro) {
		getSessionFactory().getCurrentSession().delete(Parametro);
	}

	public void updateParametro(Parametro Parametro) {
		getSessionFactory().getCurrentSession().update(Parametro);
	}

	public Parametro getParametroById(int id) {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Parametro where id=?").setParameter(0, id)
				.list();
		return (Parametro) list.get(0);
	}

	public List<Parametro> getParametros() {
		List list = getSessionFactory().getCurrentSession()
				.createQuery("from Parametro").list();
		return list;
	}

}