package br.com.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_questao")
public class Questao implements Serializable{

	private static final long serialVersionUID = 7909339630017003537L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codQuestoes;
	private String enunciado;
	private String observacoes;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
//	@ManyToOne
//	private TipoDeQuestao tipoDeQuestao;

	public Integer getCodQuestoes() {
		return codQuestoes;
	}

	public void setCodQuestoes(Integer codQuestoes) {
		this.codQuestoes = codQuestoes;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

//	public TipoDeQuestao getTipoDeQuestao() {
//		return tipoDeQuestao;
//	}
//
//	public void setTipoDeQuestao(TipoDeQuestao tipoDeQuestao) {
//		this.tipoDeQuestao = tipoDeQuestao;
//	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Questao [codQuestoes=" + codQuestoes + ", enunciado=" + enunciado + ", observacoes=" + observacoes
				+ ", tipo=" + tipo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codQuestoes == null) ? 0 : codQuestoes.hashCode());
		result = prime * result + ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Questao other = (Questao) obj;
		if (codQuestoes == null) {
			if (other.codQuestoes != null)
				return false;
		} else if (!codQuestoes.equals(other.codQuestoes))
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (observacoes == null) {
			if (other.observacoes != null)
				return false;
		} else if (!observacoes.equals(other.observacoes))
			return false;
		if (tipo != other.tipo)
			return false;
		return true;
	}
	
	

}
