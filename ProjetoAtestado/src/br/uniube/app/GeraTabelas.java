package br.uniube.app;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import br.uniube.model.Cid;

public class GeraTabelas {
	public static void main(String[] args) {
		// Cria  uma configuração para a classe cargo
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		// Adiciona a classe cargo
		cfg.addAnnotatedClass(Cid.class);
		new SchemaExport(cfg).create(true,true);
	}
}
