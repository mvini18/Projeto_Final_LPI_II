package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import br.uniube.model.Cid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CidDAO {

	private Session session;
	
	public void conecta() {
		session = new HibernateFactory().getSession();
	}
	public void desconecta() throws Exception{
		if (this.session != null)
			this.session.close();
	}
	
	public List consultarCid() throws Exception{
		conecta();
		List lista = this.session.createQuery("from br.uniube.model.Cid").list();
		desconecta();
		return lista;
	}
}