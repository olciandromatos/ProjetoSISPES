package br.com.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="tb_pesquisa")
public class Pesquisa implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codPesquisa;
	private String tituloDaPesquisa;
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	private Date dataPesquisa;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private RegistroDoUsuario registroDoUsuario;
	
	public RegistroDoUsuario getRegistroDoUsuario() {
		return registroDoUsuario;
	}
	
	public void setRegistroDoUsuario(RegistroDoUsuario registroDoUsuario) {
		this.registroDoUsuario = registroDoUsuario;
	}

	public Date getDataPesquisa() {
		return dataPesquisa;
	}

	public void setDataPesquisa(Date dataPesquisa) {
		this.dataPesquisa = dataPesquisa;
	}

	public Integer getCodPesquisa() {
		return codPesquisa;
	}

	public void setCodPesquisa(Integer codPesquisa) {
		this.codPesquisa = codPesquisa;
	}

	public String getTituloDaPesquisa() {
		return tituloDaPesquisa;
	}

	public void setTituloDaPesquisa(String tituloDaPesquisa) {
		this.tituloDaPesquisa = tituloDaPesquisa;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Pesquisa [codPesquisa=" + codPesquisa + ", tituloDaPesquisa=" + tituloDaPesquisa + ", descricao="
				+ descricao + ", dataPesquisa=" + dataPesquisa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPesquisa == null) ? 0 : codPesquisa.hashCode());
		result = prime * result + ((dataPesquisa == null) ? 0 : dataPesquisa.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tituloDaPesquisa == null) ? 0 : tituloDaPesquisa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pesquisa other = (Pesquisa) obj;
		if (codPesquisa == null) {
			if (other.codPesquisa != null)
				return false;
		} else if (!codPesquisa.equals(other.codPesquisa))
			return false;
		if (dataPesquisa == null) {
			if (other.dataPesquisa != null)
				return false;
		} else if (!dataPesquisa.equals(other.dataPesquisa))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (tituloDaPesquisa == null) {
			if (other.tituloDaPesquisa != null)
				return false;
		} else if (!tituloDaPesquisa.equals(other.tituloDaPesquisa))
			return false;
		return true;
	}
	
	


}
