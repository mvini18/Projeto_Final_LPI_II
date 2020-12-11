package br.uniube.app;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.uniube.model.Atestado;
import br.uniube.model.Cidades;
import br.uniube.model.Medico;
import br.uniube.model.Usuario;

public class GeraTabelas {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
//		cfg.addAnnotatedClass(Cid.class);
//		cfg.addAnnotatedClass(Usuario.class);
//		cfg.addAnnotatedClass(Atestado.class);
		cfg.addAnnotatedClass(Medico.class);
//		cfg.addAnnotatedClass(Cidades.class);
		new SchemaExport(cfg).create(true,true);
	}
}
