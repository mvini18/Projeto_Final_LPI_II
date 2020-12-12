package br.uniube.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="tb_cidade")
public class Cidades {
		
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		String nome_cidade, estado;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome_cidade() {
			return nome_cidade;
		}

		public void setNome_cidade(String nome_cidade) {
			this.nome_cidade = nome_cidade;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		
}		
