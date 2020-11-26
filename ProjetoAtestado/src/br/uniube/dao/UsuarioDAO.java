package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.uniube.model.Usuario;
/**
 * Classe de acesso ao banco de dados
 * 
 */
public class UsuarioDAO extends AcessoBancoDAO {
	public void inserirUsuario(Usuario objUsuario) throws Exception{
		try {
			conectar();

			String query = "Insert INTO tb_login (cpf,nome,email,telefone,senha,estilo_usuario) "
					+ "VALUES ('"+ objUsuario.getCpf() + "','"+ objUsuario.getNome() +"',"
							+ "'"+ objUsuario.getEmail() + "', '"+ objUsuario.getTelefone() + "',"
									+ "'"+ objUsuario.getSenha() + "','paciente')";
			System.out.println(query);
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);


		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
	public void loginUsuario(Usuario objUsuario) throws Exception{
		try {
			conectar();

			String query = "select * from tb_login where email =  '"+ objUsuario.getEmail() + "' "
					+ "and senha = '"+ objUsuario.getSenha() + "'";
			System.out.println(query);
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);


		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
}
