package br.uniube.model;

import java.awt.image.BufferedImage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="tb_login")
public class Usuario {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String cpf, nome, email, telefone, senha, estilo_usuario;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEstilo_usuario() {
		return estilo_usuario;
	}

	public void setEstilo_usuario(String estilo_usuario) {
		this.estilo_usuario = estilo_usuario;
	}

	
	 
}
