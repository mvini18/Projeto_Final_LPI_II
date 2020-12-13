package br.uniube.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImportCidadesBanco {
	public static void main (String args[]) {
		
		List<String> linhas = new ArrayList();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Registrado o driver, vamos estabelecer uma conexão
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto_atestado",
					"root", "root");
			// Após estabelecermos a conexão com o banco de dados
			// Método createStatement para criar o Statement 
			Statement stm = con.createStatement();
			
			BufferedReader leitor = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\marco\\Documents\\github\\Projeto_Final_LPI_II\\ProjetoAtestado\\src\\cidades.txt"), "UTF-8"));
			
			String linha = leitor.readLine();

			while (linha != null) {
				linhas.add(linha);
				linha = leitor.readLine();
				
				if(linha != null)
				{
					String estadoCidade = linha.split(" ")[0];
					String nome = linha.substring(estadoCidade.length(), linha.length()-1);
					System.out.println("Estado: " + estadoCidade + " Nome da Cidade: " + nome);
					
					String sqlCadastro = " INSERT INTO tb_cidade (nome_cidade, estado) VALUES ('" + nome + "', '" + estadoCidade + "')";
					stm.executeUpdate(sqlCadastro);
				}
			}

			leitor.close();


		} catch (FileNotFoundException ex) {
			System.out.println("Erro: " + ex);
		} catch (IOException ex) {
			System.out.println("Erro: " + ex);
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // vejamos que erro foi gerado e quem o gerou
		} catch (SQLException e) {
			// se houve algum erro, uma exceção é gerada para informar o erro
			e.printStackTrace(); // vejamos que erro foi gerado e quem o gerou
		}

	}

}
