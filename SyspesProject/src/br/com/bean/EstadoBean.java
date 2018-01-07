package br.com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.EstadoDao;
import br.com.modelo.Empresa;
import br.com.modelo.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private List<Estado> estadoList;
	private Estado estado;
	private Empresa empresa;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public void novo(){
		estado = new Estado();
	}

	public EstadoBean() {
		listar();
	}

	public void cadastrar() {
		EstadoDao dao = new EstadoDao();
		try {
			dao.cadastrar(estado);
			novo();
			Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
			System.out.println("cadastrou estado");
		} catch (SQLException e) {
			System.out.println("erro ao tentar cadastrar o estado");
			e.printStackTrace();
		}

	}

	public List<Estado> listar() {
		EstadoDao dao = new EstadoDao();
		try {
			estadoList = dao.listar();
			estado = new Estado();
			System.out.println("Entrou");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return estadoList;
	}
	
	
	public void excluir(ActionEvent evento) {
		try {
			EstadoDao dao = new EstadoDao();
			estado = (Estado) evento.getComponent().getAttributes().get("itemSelecionado");

			dao.deletar(estado);

			estadoList = dao.listar();

			Messages.addGlobalInfo("Estado removida com sucesso! ");
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar excluir");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("itemSelecionado");

	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstadoList() {
		return estadoList;
	}

	public void setEstadoList(List<Estado> estadoList) {
		this.estadoList = estadoList;
	}

	public Estado pesquisaPorCodigo(Integer codigo) {
		EstadoDao dao = new EstadoDao();

		return dao.pesquisaPorCodigo(codigo);
	}
	
	public Estado pesquisaPorUF(String uf){
		EstadoDao dao = new EstadoDao();
		return dao.pesquisaPorCodigo(uf);
	}
}
