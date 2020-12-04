package br.uniube.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExemploBanco {
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			try {
				// Registrar um driver
				Class.forName("com.mysql.jdbc.Driver");
				// Registrado o driver, vamos estabelecer uma conex�o
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_alunos",
						"root", "root");
				// Ap�s estabelecermos a conex�o com o banco de dados
				// M�todo createStatement para criar o Statement 
				Statement stm = con.createStatement();
				// CADASTRA UM ALUNO
				// Entrada de dados
				Scanner entrada = new Scanner(System.in);
				System.out.println("Informe o nome do aluno que deseja cadastrar:");
				String nomeAluno = entrada.nextLine();
				// Montar o comando SQL para inserir
				String sqlCadastro = " INSERT INTO tb_aluno (nome) VALUES ('" + nomeAluno + "')";
				stm.executeUpdate(sqlCadastro);
				// CONSULTA ALUNOS
				// Montar o comando SQL
				String sqlConsulta = " SELECT * FROM tb_aluno ORDER BY ra ";
				// Executar o SQL (a query) no banco de dados
				ResultSet rs = stm.executeQuery(sqlConsulta);
				// O m�todo next () informa se houve resultados e posiciona o cursor
				// do banco na pr�xima linha dispon�vel para recupera��o
				while (rs.next()) {
					// Os m�todos getXXX recuperam os dados de acordo com o tipo SQL do dado:
					int ra = rs.getInt("ra");
					String nome = rs.getString("nome");
					System.out.println(" RA do aluno: " + ra + 
							           " nome: " + nome);
				}
				// Fecha a conex�o
				con.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace(); // vejamos que erro foi gerado e quem o gerou
			} catch (SQLException e) {
				// se houve algum erro, uma exce��o � gerada para informar o erro
				e.printStackTrace(); // vejamos que erro foi gerado e quem o gerou
			}

		}
}
