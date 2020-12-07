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
public class AtestadoDAO extends AcessoBancoDAO {
	public void inserirAtestado(Atestado objAtestado) throws Exception{
		try {
			conectar();

			String query = "Insert INTO tb_atestado (cpf_usuario,nascimento,dia_atual,"
					+ "sexo,finalidade,cid10,periodo,texto_paciente,status) VALUES "
					+ "('"+ objAtestado.getCpf_usuario() + "','"+ objAtestado.getNascimento() + "','"+ objAtestado.getDia_atual() + "',"
					+ "'"+ objAtestado.getSexo() + "','"+ objAtestado.getFinalidade() + "',"
					+ "'"+ objAtestado.getCid10() + "','"+ objAtestado.getPeriodo() + "',"
					+ "'"+ objAtestado.getTexto_paciente() + "', 'Pendente')";
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
	
	public Atestado consultarAtestadoByCpf(String cpf) throws Exception {
		Atestado objAtestado = new Atestado();
		try {
			ResultSet rs;
			conectar();
			String query = "select id,cid10, cpf_usuario, dia_atual, finalidade, nascimento, periodo, sexo, status, texto_paciente"
					+ " from tb_atestado where cpf_usuario='" + cpf + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) {
				int id = rs.getInt(1);
				String cid10 = rs.getString(2);
				String cpf_usuario = rs.getString(3);
				String dia_atual = rs.getString(4);
				String finalidade = rs.getString(5);
				String nascimento = rs.getString(6);
				String periodo = rs.getString(7);
				String sexo = rs.getString(8);
				String status = rs.getString(9);
				String texto_paciente = rs.getString(10);

				objAtestado.setId(id);
				objAtestado.setCid10(cid10);
				objAtestado.setCpf_usuario(cpf_usuario);
				objAtestado.setDia_atual(dia_atual);
				objAtestado.setFinalidade(finalidade);
				objAtestado.setNascimento(nascimento);
				objAtestado.setPeriodo(periodo);
				objAtestado.setSexo(sexo);
				objAtestado.setStatus(status);
				objAtestado.setTexto_paciente(texto_paciente);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return objAtestado;
	}

	public Atestado consultarAtestadoByStatus(String statusAtestado) throws Exception {
		Atestado objAtestado = new Atestado();
		try {
			ResultSet rs;
			conectar();
			String query = "select id, cid10, cpf_usuario, dia_atual, finalidade, nascimento, periodo, sexo, status, texto_paciente"
					+ " from tb_atestado where status='" + statusAtestado + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) {
				int id = rs.getInt(1);
				String cid10 = rs.getString(2);
				String cpf_usuario = rs.getString(3);
				String dia_atual = rs.getString(4);
				String finalidade = rs.getString(5);
				String nascimento = rs.getString(6);
				String periodo = rs.getString(7);
				String sexo = rs.getString(8);
				String status = rs.getString(9);
				String texto_paciente = rs.getString(10);

				objAtestado.setId(id);
				objAtestado.setCid10(cid10);
				objAtestado.setCpf_usuario(cpf_usuario);
				objAtestado.setDia_atual(dia_atual);
				objAtestado.setFinalidade(finalidade);
				objAtestado.setNascimento(nascimento);
				objAtestado.setPeriodo(periodo);
				objAtestado.setSexo(sexo);
				objAtestado.setStatus(status);
				objAtestado.setTexto_paciente(texto_paciente);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return objAtestado;
	}
	
	public Atestado mostrarStatusUsuario(String cpf) throws Exception {
		Atestado objAtestado = new Atestado();
		try {
			ResultSet rs;
			conectar();
			String query = "select status from tb_atestado where cpf_usuario= '" + cpf + "' order by id desc";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) {
				String status = rs.getString(1);
			
				objAtestado.setStatus(status);
				
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch(Exception ex) {
			throw new Exception(ex);
		} finally{
			desconectar();
		}
		return objAtestado;
	}
	
	public void confirmarAtestado(String cpf,int id) throws Exception {
		try {
			conectar();
			String query = "update tb_atestado set status= 'Confirmado' where cpf_usuario = '" + cpf + "'"
					+ "and id = '"+ id + "'";

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
	
	public void rejeitarAtestado(String cpf, int id) throws Exception {
		try {
			conectar();
			String query = "update tb_atestado set status= 'Rejeitado' where cpf_usuario = '" + cpf + "'"
					+ "and id = '" + id + "'";

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
	
	public boolean usuarioAtestadoPendente(String cpf) throws Exception {
		try {
			ResultSet rs;
			conectar();
			String query = "select * from tb_atestado where cpf_usuario ='" + cpf +"' and status = 'Pendente'";
			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) 
			{
				return true;
			} 
			else 
			{
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

}
