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

@Entity
@Table(name = "tb_registraUsuario")
public class RegistroDoUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codRegistro;
	private String ipUsuario;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro; // data e hora
	private String respostas;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Questao questoes;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Alternativa alternativa;

	public Integer getCodRegistro() {
		return codRegistro;
	}

	public void setCodRegistro(Integer codRegistro) {
		this.codRegistro = codRegistro;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getRespostas() {
		return respostas;
	}

	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}

	public Questao getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao questoes) {
		this.questoes = questoes;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

	@Override
	public String toString() {
		return "RegistroDoUsuario [codRegistro=" + codRegistro + ", ipUsuario=" + ipUsuario + ", dataCadastro="
				+ dataCadastro + ", horaCadastro=" + ", respostas=" + respostas + ", questoes="
				+ questoes + ", alternativa=" + alternativa + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alternativa == null) ? 0 : alternativa.hashCode());
		result = prime * result + ((codRegistro == null) ? 0 : codRegistro.hashCode());
		result = prime * result + ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result + ((ipUsuario == null) ? 0 : ipUsuario.hashCode());
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
		result = prime * result + ((respostas == null) ? 0 : respostas.hashCode());
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
		RegistroDoUsuario other = (RegistroDoUsuario) obj;
		if (alternativa == null) {
			if (other.alternativa != null)
				return false;
		} else if (!alternativa.equals(other.alternativa))
			return false;
		if (codRegistro == null) {
			if (other.codRegistro != null)
				return false;
		} else if (!codRegistro.equals(other.codRegistro))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (ipUsuario == null) {
			if (other.ipUsuario != null)
				return false;
		} else if (!ipUsuario.equals(other.ipUsuario))
			return false;
		if (questoes == null) {
			if (other.questoes != null)
				return false;
		} else if (!questoes.equals(other.questoes))
			return false;
		if (respostas == null) {
			if (other.respostas != null)
				return false;
		} else if (!respostas.equals(other.respostas))
			return false;
		return true;
	}
	
	

}
