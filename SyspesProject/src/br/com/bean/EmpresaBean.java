package br.com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.EmpresaDao;
import br.com.dao.EstadoDao;
import br.com.modelo.Empresa;
import br.com.modelo.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EmpresaBean implements Serializable {
	private Estado estado = new Estado();
	private List<Estado> estadoList;
	private List<Empresa> empresas = new ArrayList<>();
	private Empresa empresa = new Empresa();
	private EmpresaDao dao = new EmpresaDao();

	public void novo() {
		empresa = new Empresa();

	}

	public EmpresaBean() {
		ListagemEstados();
	}

	public void cadastrar() {
		try {

			dao.update(empresa);
			Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
			novo();
			empresas = dao.listar();

		} catch (SQLException e) {
			e.printStackTrace();
			Messages.addFlashGlobalError("erro ao tentar cadastrar");
		}

		System.out.println("Cadastrou! : bean");
	}

	public void ListagemEstados() {

		EstadoDao dao = new EstadoDao();

		try {
			estadoList = dao.listar();
			System.out.println("Entrou");
		} catch (SQLException e) {
			Messages.addFlashGlobalError("Erro ao tentar listar os  estados");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			empresa = (Empresa) evento.getComponent().getAttributes().get("itemSelecionado");

			dao.deletar(empresa);

			empresas = dao.listar();

			Messages.addGlobalInfo("Empresa removida com sucesso! ");
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar excluir");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		empresa = (Empresa) evento.getComponent().getAttributes().get("itemSelecionado");

	}

	@PostConstruct
	public void listar() {

		try {
			empresas = dao.listar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String principal() {
		System.out.println("Chegou Index");
		return "principal";
	}

	public String bemvindo() {
		System.out.println("Chegou aqui");
		return "cadastro/BemVindo";
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
