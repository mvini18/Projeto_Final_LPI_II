package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.uniube.model.Atestado;
/**
 * Classe de acesso ao banco de dados
 * 
 */
public class AtestadoDAO extends AcessoBancoDAO {
	public void inserirAtestado(Atestado objAtestado) throws Exception{
		try {
			conectar();

			String query = "Insert INTO tb_atestado (cpf_usuario,nascimento,dia_atual"
					+ "sexo,finalidade,cid10,periodo,texto_paciente,status) VALUES "
					+ "('"+ objAtestado.getCpf_usuario() + "','"+ objAtestado.getDia_atual() + "',"
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
	
}
