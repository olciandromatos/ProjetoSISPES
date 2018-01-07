package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_tipo")
public class TipoDeQuestao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codTipoDeQuestao;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	private String observacoes;

	public Integer getCodTipoDeQuestao() {
		return codTipoDeQuestao;
	}

	public void setCodTipoDeQuestao(Integer codTipoDeQuestao) {
		this.codTipoDeQuestao = codTipoDeQuestao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getDuvidas() {
		return observacoes;
	}

	public void setDuvidas(String duvidas) {
		this.observacoes = duvidas;
	}

	@Override
	public String toString() {
		return "TipoDeQuestao [codTipoDeQuestao=" + codTipoDeQuestao + ", tipo=" + tipo + ", observacoes=" + observacoes
				+ "]";
	}

}
