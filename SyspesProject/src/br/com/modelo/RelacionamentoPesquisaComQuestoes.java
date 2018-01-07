package br.com.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_pesquisaComQuestao")
public class RelacionamentoPesquisaComQuestoes {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codRelacionamento;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Pesquisa pesquisa;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Questao questoes;
	private boolean obrigatorio;

	public Integer getCodRelacionamento() {
		return codRelacionamento;
	}

	public void setCodRelacionamento(Integer codRelacionamento) {
		this.codRelacionamento = codRelacionamento;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Questao getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Questao questoes) {
		this.questoes = questoes;
	}

	public boolean isObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

}
