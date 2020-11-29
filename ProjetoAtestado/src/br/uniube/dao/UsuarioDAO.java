package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public boolean loginUsuario(Usuario objUsuario) throws Exception{
		try {
			ResultSet rs;
			conectar();

			String query = "select * from tb_login where email =  '"+ objUsuario.getEmail() + "' "
					+ "and senha = '"+ objUsuario.getSenha() + "'";
			
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);
			
			
			if(rs.next()) {
                return true;
            } else {
                return false;
            }
			
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
	}
	
	public Usuario consultarUsuarioByEmail(String email) throws Exception {
		Usuario Usuario = null;
		try {
			ResultSet rs;
			conectar();
			
			String query = "select nome from tb_login where email=" + email;
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);
			
			if(rs.next()) {
				String nome = rs.getString(1);

				Usuario = new Usuario();
				Usuario.setNome(nome);
			}
			
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return Usuario;
	}
}
