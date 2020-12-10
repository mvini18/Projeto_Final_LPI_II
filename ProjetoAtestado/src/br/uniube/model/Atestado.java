package br.uniube.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.Max;

@Entity 
@Table(name="tb_atestado")
public class Atestado {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String cpf_usuario, nascimento, dia_atual
	, sexo, finalidade, cid10, periodo, texto_paciente, status ;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf_usuario() {
		return cpf_usuario;
	}

	public void setCpf_usuario(String cpf_usuario) {
		this.cpf_usuario = cpf_usuario;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getDia_atual() {
		return dia_atual;
	}

	public void setDia_atual(String dia_atual) {
		this.dia_atual = dia_atual;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getFinalidade() {
		return finalidade;
	}

	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
	}

	public String getCid10() {
		return cid10;
	}

	public void setCid10(String cid10) {
		this.cid10 = cid10;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getTexto_paciente() {
		return texto_paciente;
	}

	public void setTexto_paciente(String texto_paciente) {
		this.texto_paciente = texto_paciente;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	
	 
}
