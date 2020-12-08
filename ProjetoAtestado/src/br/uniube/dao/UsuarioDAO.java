package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.uniube.model.Atestado;
import br.uniube.model.Usuario;

/**
 * Classe de acesso ao banco de dados
 * 
 */
public class UsuarioDAO extends AcessoBancoDAO {
	public void inserirUsuario(Usuario objUsuario) throws Exception {
		try {
			conectar();

			String query = "Insert INTO tb_login (cpf,nome,email,telefone,senha,estilo_usuario) " + "VALUES ('"
					+ objUsuario.getCpf() + "','" + objUsuario.getNome() + "'," + "'" + objUsuario.getEmail() + "', '"
					+ objUsuario.getTelefone() + "'," + "'" + objUsuario.getSenha() + "','paciente')";
			System.out.println(query);
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
	}

	public Usuario consultarUsuarioByEmail(String emailUsuario) throws Exception {
		Usuario usuario = new Usuario();
		try {
			ResultSet rs;
			conectar();
			String query = "select id,cpf,email,telefone,senha,estilo_usuario,nome" + " from tb_login where email='"
					+ emailUsuario + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				int id = rs.getInt(1);
				String cpf = rs.getString(2);
				String email = rs.getString(3);
				String telefone = rs.getString(4);
				String senha = rs.getString(5);
				String estilo_usuario = rs.getString(6);
				String nome = rs.getString(7);

				usuario.setId(id);
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setEstilo_usuario(estilo_usuario);
				usuario.setTelefone(telefone);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
		return usuario;
	}

	public void alterarSenha(Usuario objUsuario) throws Exception {
		try {
			conectar();

			String query = "update tb_login set senha='" + objUsuario.getSenha() + "' where email = '"
					+ objUsuario.getEmail() + "'";
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
	}

	public boolean verificaSenha(String senhaAntiga, Usuario objUsuario) throws Exception {
		try {
			ResultSet rs;
			conectar();
			String query = "select senha from tb_login where email='" + objUsuario.getEmail() + "'";
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				String senha = rs.getString(1);
				if (senhaAntiga == senha) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}

	}

	public boolean loginUsuario(Usuario objUsuario) throws Exception {
		try {
			ResultSet rs;
			conectar();

			String query = "select * from tb_login where email =  '" + objUsuario.getEmail() + "' " + "and senha = '"
					+ objUsuario.getSenha() + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
	}

	public void atualizarUsuario(String objUsuarioEmail, Usuario objUsuario) throws Exception {
		try {
			conectar();

			String query = "UPDATE tb_login set nome='" + objUsuario.getNome() + "'," + "" + "cpf='"
					+ objUsuario.getCpf() + "'," + " telefone = '" + objUsuario.getTelefone() + "'," + "  email = '"
					+ objUsuario.getEmail() + "' where email = '" + objUsuarioEmail + "'";
			Statement instrucao = getConexao().createStatement();
			instrucao.executeUpdate(query);

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
	}

	public ArrayList<Usuario> consultarUsuarioConfirmado() throws Exception {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			ResultSet rs;
			conectar();

			String query = "select tb_atestado.id,nome,cpf,telefone from tb_atestado,tb_login "
					+ "where status = 'Confirmado' "
					+ "and cpf = cpf_usuario limit 4";
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);

				Usuario usuario = new Usuario();
				Atestado att = new Atestado();
				att.setId(id);
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setTelefone(telefone);

				listaUsuarios.add(usuario);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
		return listaUsuarios;
	}

	public ArrayList<Usuario> consultarUsuarioConfirmadoNome(String nomeUsuario) throws Exception {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			ResultSet rs;
			conectar();

			String query = "select tb_atestado.id,nome,cpf,telefone from tb_atestado,tb_login "
					+ "where ucase(nome) like '" + nomeUsuario.toUpperCase() + "%'"
					+ "and status = 'Confirmado' "
					+ "and cpf = cpf_usuario limit 4"; 
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			while (rs.next()) {

				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String cpf = rs.getString(3);
				String telefone = rs.getString(4);

				Usuario usuario = new Usuario();
				Atestado att = new Atestado();
				att.setId(id);
				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setTelefone(telefone);

				listaUsuarios.add(usuario);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
		return listaUsuarios;
	}



	public Usuario consultarNomeAtestado(String cpfUsuario) throws Exception {
		Usuario usuario = new Usuario();
		try {
			ResultSet rs;
			conectar();
			String query = "select cpf,email,telefone,senha,estilo_usuario,nome"
					+ " from tb_atestado,tb_login where cpf ='" + cpfUsuario + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				String cpf = rs.getString(1);
				String email = rs.getString(2);
				String telefone = rs.getString(3);
				String senha = rs.getString(4);
				String estilo_usuario = rs.getString(5);
				String nome = rs.getString(6);

				usuario.setNome(nome);
				usuario.setCpf(cpf);
				usuario.setEmail(email);
				usuario.setSenha(senha);
				usuario.setEstilo_usuario(estilo_usuario);
				usuario.setTelefone(telefone);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
		return usuario;
	}

	public boolean verificarCpfEmail(String cpf, String email) throws Exception {
		try {
			ResultSet rs;
			conectar();
			String query = "select * from tb_login where email='" + email + "' or cpf = '" + cpf + "'";
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}

	}
	public Usuario consultarUsuarioById(String idAtestado) throws Exception {
		Usuario objPaciente = new Usuario();
		try {
			ResultSet rs;
			conectar();
			String query = "select nome from tb_login,tb_atestado where tb_atestado.id='" + idAtestado + "' and cpf = cpf_usuario";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) {
				
				String nome = rs.getString(1);
				objPaciente.setNome(nome);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return objPaciente;
	}

}