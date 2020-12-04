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
					+ "'"+ objAtestado.getTexto_paciente() + "', 'pendente')";
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

	public Atestado consultarAtestadoByStatus(String statusAtestado) throws Exception {
		Atestado objAtestado = new Atestado();
		try {
			ResultSet rs;
			conectar();
			String query = "select cid10, cpf_usuario, dia_atual, finalidade, nascimento, periodo, sexo, status, texto_paciente"
					+ " from tb_atestado where status='" + statusAtestado + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if(rs.next()) {
				String cid10 = rs.getString(1);
				String cpf_usuario = rs.getString(2);
				String dia_atual = rs.getString(3);
				String finalidade = rs.getString(4);
				String nascimento = rs.getString(5);
				String periodo = rs.getString(6);
				String sexo = rs.getString(7);
				String status = rs.getString(8);
				String texto_paciente = rs.getString(9);

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

}
