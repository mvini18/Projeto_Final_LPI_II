package br.uniube.app;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.uniube.model.Cid;
import br.uniube.model.Usuario;
import br.uniube.model.Atestado;

public class GeraTabelas {
	public static void main(String[] args) {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		
		cfg.addAnnotatedClass(Cid.class);
		cfg.addAnnotatedClass(Usuario.class);
		cfg.addAnnotatedClass(Atestado.class);
		new SchemaExport(cfg).create(true,true);
	}
}
