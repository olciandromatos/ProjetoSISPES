package br.com.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.modelo.RelacionamentoEmpresaComPesquisa;

@ManagedBean
@ViewScoped
public class EnviarPesquisaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private RelacionamentoEmpresaComPesquisa empresaComPesquisa;

	public String bemvindo() {
		Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
		System.out.println("Chegou bemvindo");
		return "BemVindo";
	}
	
	public String voltar(){
		return "principal";
	}
	
	public String form(){
		System.out.println("Chegou form");
		return "formulario";
	}

	public RelacionamentoEmpresaComPesquisa getEmpresaComPesquisa() {
		return empresaComPesquisa;
	}

	public void setEmpresaComPesquisa(RelacionamentoEmpresaComPesquisa empresaComPesquisa) {
		this.empresaComPesquisa = empresaComPesquisa;
	}

}
