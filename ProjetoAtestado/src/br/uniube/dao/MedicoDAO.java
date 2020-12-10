package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import br.uniube.model.Medico;

public class MedicoDAO extends AcessoBancoDAO {
	public void inserirInfoMedico(Medico objMedico) throws Exception {
		try {
			conectar();
			String query = "Insert INTO tb_medico (cep,cidade,cpf_medico,crm,endereco,especialidade,estado,rqe) " + "VALUES ('"
					+ objMedico.getCep() + "','" + objMedico.getCidade() + "'," + objMedico.getCrm() + "', '"
					+ objMedico.getEndereco() + "'," + objMedico.getEspecialidade() + "', " + objMedico.getEstado() + "',"
							+ "" + objMedico.getRqe() + "' )";
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
}
