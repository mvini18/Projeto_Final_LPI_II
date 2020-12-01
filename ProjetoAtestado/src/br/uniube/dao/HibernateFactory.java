package br.uniube.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.uniube.model.Cid;




public class HibernateFactory {
	private static SessionFactory factory;
	
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Cid.class);
		factory = cfg.buildSessionFactory();
	}
	public Session getSession() {
		return factory.openSession();
	}
}
