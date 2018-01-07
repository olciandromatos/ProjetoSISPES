package br.com.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_empresaComPesquisa")
public class RelacionamentoEmpresaComPesquisa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer codRelacionamento;
	private Calendar dataVigenciaInicial;
	private Calendar dataVigenciaFinal;
	private String observacoesExtras;
	private String hiperLink;
	@ManyToOne
	@JoinColumn(nullable=false, name="tb_pesquisa")
	private Pesquisa pesquisa;
	@ManyToOne
	@JoinColumn(nullable=false)
	private Empresa empresa;

	public Integer getCodRelacionamento() {
		return codRelacionamento;
	}

	public void setCodRelacionamento(Integer codRelacionamento) {
		this.codRelacionamento = codRelacionamento;
	}

	public Calendar getDataVigenciaInicial() {
		return dataVigenciaInicial;
	}

	public void setDataVigenciaInicial(Calendar dataVigenciaInicial) {
		this.dataVigenciaInicial = dataVigenciaInicial;
	}

	public Calendar getDataVigenciaFinal() {
		return dataVigenciaFinal;
	}

	public void setDataVigenciaFinal(Calendar dataVigenciaFinal) {
		this.dataVigenciaFinal = dataVigenciaFinal;
	}

	public String getObservacoesExtras() {
		return observacoesExtras;
	}

	public void setObservacoesExtras(String observacoesExtras) {
		this.observacoesExtras = observacoesExtras;
	}

	public String getHiperLink() {
		return hiperLink;
	}

	public void setHiperLink(String hiperLink) {
		this.hiperLink = hiperLink;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


}
