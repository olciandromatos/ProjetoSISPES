package br.com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.dao.RegistroUsuarioDao;
import br.com.modelo.RegistroDoUsuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class RegistroUsuarioBean implements Serializable{
	
	private RegistroDoUsuario registro = new RegistroDoUsuario();
	private List<RegistroDoUsuario> registros;
	RegistroUsuarioDao dao = new RegistroUsuarioDao();
	
	public void salvar(){
		
		// registro com data e hora
		//registro.setDataCadastro( new Date());
		try {
			dao.cadastrar(registro);
			Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
		} catch (SQLException e) {
			Messages.addFlashGlobalError("Erro ao tentar cadastrar a questao");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar(){
		try {
			registros = dao.listar();
		} catch (SQLException e) {
			Messages.addFlashGlobalError("Erro ao tentar listar a questao");
			e.printStackTrace();
		}
	}

	public RegistroDoUsuario getRegistro() {
		return registro;
	}

	public void setRegistro(RegistroDoUsuario registro) {
		this.registro = registro;
	}

	public List<RegistroDoUsuario> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroDoUsuario> registros) {
		this.registros = registros;
	}
	
	
}
