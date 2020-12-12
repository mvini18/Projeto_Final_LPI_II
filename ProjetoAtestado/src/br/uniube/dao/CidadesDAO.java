package br.uniube.dao;

import java.util.List;

import org.hibernate.Session;

public class CidadesDAO {
	
	private Session session;
	
	public void conecta() {
		session = new HibernateFactory().getSession();
	}
	public void desconecta() throws Exception{
		if (this.session != null)
			this.session.close();
	}
	
	public List consultarCidades() throws Exception{
		conecta();
		List lista = this.session.createQuery("from br.uniube.model.Cidades").list();
		desconecta();
		return lista;
	}
}

