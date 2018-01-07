package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_resposta")
public class Alternativa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codAlternativa;
	private String textoDaAlternativa;
	private int ordemDasAlternativas;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Questao questoes;

	public Integer getCodAlternativa() {
		return codAlternativa;
	}

	public void setCodAlternativa(Integer codAlternativa) {
		this.codAlternativa = codAlternativa;
	}

	public String getTextoDaAlternativa() {
		return textoDaAlternativa;
	}

	public void setTextoDaAlternativa(String textoDaAlternativa) {
		this.textoDaAlternativa = textoDaAlternativa;
	}

	public int getOrdemDasAlternativas() {
		return ordemDasAlternativas;
	}

	public void setOrdemDasAlternativas(int ordemDasAlternativas) {
		this.ordemDasAlternativas = ordemDasAlternativas;
	}


	public Questao getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao questoes) {
		this.questoes = questoes;
	}

	@Override
	public String toString() {
		return "Alternativa [codAlternativa=" + codAlternativa + ", textoDaAlternativa=" + textoDaAlternativa
				+ ", ordemDasAlternativas=" + ordemDasAlternativas + ", questoes=" + questoes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAlternativa == null) ? 0 : codAlternativa.hashCode());
		result = prime * result + ordemDasAlternativas;
		result = prime * result + ((questoes == null) ? 0 : questoes.hashCode());
		result = prime * result + ((textoDaAlternativa == null) ? 0 : textoDaAlternativa.hashCode());
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
		Alternativa other = (Alternativa) obj;
		if (codAlternativa == null) {
			if (other.codAlternativa != null)
				return false;
		} else if (!codAlternativa.equals(other.codAlternativa))
			return false;
		if (ordemDasAlternativas != other.ordemDasAlternativas)
			return false;
		if (questoes == null) {
			if (other.questoes != null)
				return false;
		} else if (!questoes.equals(other.questoes))
			return false;
		if (textoDaAlternativa == null) {
			if (other.textoDaAlternativa != null)
				return false;
		} else if (!textoDaAlternativa.equals(other.textoDaAlternativa))
			return false;
		return true;
	}
	
	

}
