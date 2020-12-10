package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.uniube.model.Medico;

public class MedicoDAO extends AcessoBancoDAO {
	public void atualizarInfoMedico(Medico objMedico,String cpfMedico) throws Exception {
		try {
			conectar();
			String crmMedico = objMedico.getCrm().toUpperCase();
			String query = "UPDATE tb_medico set cep='" + objMedico.getCep() + "'," + " cidade = '" + objMedico.getCidade() + "'"
					+ "," + "  crm = '" + crmMedico + "'"
					+ "," + " endereco = '" + objMedico.getEndereco() + "'"
							+ "," + " especialidade = '" + objMedico.getEspecialidade() + "'"
									+ "," + " estado = '" + objMedico.getEstado() + "'"
											+ "," + " rqe = '" + objMedico.getRqe() + "'"
							+ " where cpf_medico = '" + cpfMedico + "'";
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

	public void inserirInfoMedico(Medico objMedico,String cpfMedico) throws Exception {
		try {
			conectar();
			String crmMedico = objMedico.getCrm().toUpperCase();
			String query = "Insert INTO tb_medico (cep,cidade,cpf_medico,crm,endereco,especialidade,estado,rqe) "
					+ "VALUES ('" +objMedico.getCep() + "','" + objMedico.getCidade() + "'"
					+ ",'" + cpfMedico + "','" + crmMedico + "'"
					+ ", '"+ objMedico.getEndereco() + "','" + objMedico.getEspecialidade() + "'"
					+ ", '" + objMedico.getEstado() + "','" + objMedico.getRqe() + "' )";
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

	public Medico consultarMedicoByCpf(String cpfMedico) throws Exception {
		Medico objMedico = new Medico();
		try {
			ResultSet rs;
			conectar();
			String query = "select id,cep,cidade,cpf_medico,crm,endereco,especialidade,estado,rqe "
					+ "from tb_medico where cpf_medico = '" +  cpfMedico + "'";

			Statement instrucao = getConexao().createStatement();
			rs = instrucao.executeQuery(query);

			if (rs.next()) {
				int id = rs.getInt(1);
				String cep = rs.getString(2);
				String cidade = rs.getString(3);
				String cpf_medico = rs.getString(4);
				String crm = rs.getString(5);
				String endereco = rs.getString(6);
				String especialidade = rs.getString(7);
				String estado = rs.getString(8);
				String rqe = rs.getString(9);

				objMedico.setId(id);
				objMedico.setCep(cep);
				objMedico.setCidade(cidade);
				objMedico.setCpf_medico(cpf_medico);
				objMedico.setCrm(crm);
				objMedico.setEndereco(endereco);
				objMedico.setEspecialidade(especialidade);
				objMedico.setEstado(estado);
				objMedico.setRqe(rqe);
			}

		} catch (SQLException ex) {
			throw new SQLException(ex);
		} catch (Exception ex) {
			throw new Exception(ex);
		} finally {
			desconectar();
		}
		return objMedico;
	}
}
