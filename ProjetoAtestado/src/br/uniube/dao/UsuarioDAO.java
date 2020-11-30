package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.uniube.model.Usuario;
import br.uniube.model.Usuario;
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
	
	public ArrayList<Usuario> consultarUsuarioByEmail(String emailUsuario) throws Exception {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			ResultSet rs;
			conectar();
			
			String query = "select * from tb_login where email=" + emailUsuario;

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String cpf = rs.getString(2);
				String email = rs.getString(3);
				String telefone = rs.getString(4);
				String senha = rs.getString(5);
				String estilo_usuario = rs.getString(6);
				String nome = rs.getString(7);
				
				Usuario Usuario = new Usuario();
				Usuario.setId(id);
				Usuario.setNome(nome);
				Usuario.setCpf(cpf);
				Usuario.setEmail(email);
				Usuario.setSenha(senha);
				Usuario.setEstilo_usuario(estilo_usuario);
				Usuario.setTelefone(telefone);
				listaUsuarios.add(Usuario);
			}
			
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return listaUsuarios;
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
	public void atualizarUsuario(Usuario objUsuario) throws Exception {
		try {
			conectar();
			
			String query = "update tb_login set senha='"+ objUsuario.getSenha() + " where senha = '"+ objUsuario.getSenhaAntiga() +"'and email = '" + objUsuario.getEmail() + "'";
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
