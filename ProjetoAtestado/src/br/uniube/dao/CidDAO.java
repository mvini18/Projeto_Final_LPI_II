package br.uniube.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.uniube.model.Cid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CidDAO extends AcessoBancoDAO {

	public List consultarCid(Cid objCid) throws Exception{
		try {
			conectar();

			String query = "select * from tb_cid";
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
		return null;
	}
}
