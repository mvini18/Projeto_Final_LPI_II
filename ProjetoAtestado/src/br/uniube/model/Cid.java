package br.uniube.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="tb_cid")
public class Cid {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String codigo_cid, nome_cid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo_cid() {
		return codigo_cid;
	}

	public void setCodigo_cid(String codigo_cid) {
		this.codigo_cid = codigo_cid;
	}

	public String getNome_cid() {
		return nome_cid;
	}

	public void setNome_cid(String nome_cid) {
		this.nome_cid = nome_cid;
	}
	
	
}
