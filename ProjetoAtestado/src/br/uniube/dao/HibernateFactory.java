package br.uniube.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import br.uniube.model.Atestado;
import br.uniube.model.Cid;
import br.uniube.model.Cidades;
import br.uniube.model.Medico;
import br.uniube.model.Usuario;




public class HibernateFactory {
	private static SessionFactory factory;
	
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Cid.class);
		cfg.addAnnotatedClass(Cidades.class);
		cfg.addAnnotatedClass(Atestado.class);
		cfg.addAnnotatedClass(Medico.class);
		cfg.addAnnotatedClass(Usuario.class);
		factory = cfg.buildSessionFactory();
	}
	public Session getSession() {
		return factory.openSession();
	}
}
