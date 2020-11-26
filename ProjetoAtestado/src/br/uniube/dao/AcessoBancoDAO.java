package br.uniube.dao;

import java.sql.*;
/**
 * Classe genérica para conexão com o banco de dados
 * 
 */
public class AcessoBancoDAO {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String DATABASE_NAME = "projeto_atestado";
	private final String HOSTNAME = "localhost";
	private final String PORTA = "3306";
	private final String USER = "root";
	private final String PASSWORD = "123";
	private Connection conexao;

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}

	public void conectar() throws Exception {
		try {
			Class.forName(DRIVER);
			conexao = DriverManager.getConnection("jdbc:mysql://" + HOSTNAME
					+ ":" + PORTA + "/" + DATABASE_NAME, USER, PASSWORD);
		} catch (ClassNotFoundException ex) {
			throw new Exception(ex);
		} catch (SQLException ex) {
			throw new Exception(ex);
		}
	}

	public void desconectar() throws Exception {
		try {
			getConexao().close();
		} catch (SQLException ex) {
			throw new Exception(ex);
		}
	}

}
