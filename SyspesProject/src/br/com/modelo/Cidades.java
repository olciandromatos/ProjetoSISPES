package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_cidade")
public class Cidades {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String uf;
	private String nome;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Estado estados;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstados() {
		return estados;
	}

	public void setEstados(Estado estados) {
		this.estados = estados;
	}

	@Override
	public String toString() {
		return "Cidades [id=" + id + ", uf=" + uf + ", nome=" + nome + ", estados=" + estados + "]";
	}

}
