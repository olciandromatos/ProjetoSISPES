package br.com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.PesquisaDao;
import br.com.dao.QuestaoDao;
import br.com.dao.RegistroDoUsuarioDao;
import br.com.modelo.Alternativa;
import br.com.modelo.Pesquisa;
import br.com.modelo.Questao;
import br.com.modelo.RegistroDoUsuario;
import br.com.modelo.RelacionamentoPesquisaComQuestoes;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PesquisaBean implements Serializable{
	
	private Questao questao = new Questao();
	private RelacionamentoPesquisaComQuestoes relacao = new RelacionamentoPesquisaComQuestoes();
	private List<Questao> questoes;
	private List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
	private Pesquisa pesquisa = new Pesquisa();
	private PesquisaDao dao = new PesquisaDao();
	private RegistroDoUsuario registro = new RegistroDoUsuario();
	private QuestaoDao questaoDao = new QuestaoDao();
	private Alternativa alternativa = new Alternativa();
	private List<Questao> questaoSelecionada;
	
	public void novo() {
		pesquisa = new Pesquisa();

	}
	
	public PesquisaBean() {
		listarQuestoes();
	}
	
	
	public void cadastrar() {
		//pesquisa.setDataPesquisa(new Date());
		registro.setDataCadastro(new Date());
		registro.setQuestoes(questao);
		registro.setRespostas(questao.getEnunciado());
		registro.setAlternativa(alternativa);
		
		RegistroDoUsuarioDao registroDao = new RegistroDoUsuarioDao();
		
		try {
			
			registroDao.cadastrar(registro);
			Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
			pesquisa.setRegistroDoUsuario(registro);	
			
			dao.cadastrar(pesquisa);
			
			Messages.addFlashGlobalInfo("Cadastrado com sucesso!");
			novo();
			questoes = questaoDao.listar();
			
			System.out.println("cadastrou");
		} catch (SQLException e){
			Messages.addGlobalError("Erro ao tentar cadastrar Pesquisa");
			e.printStackTrace();
		}
		
	}
	
	public void incluirItem(){
		
			questoes = new ArrayList<>();
			
		
	}
	
	public void excluir(ActionEvent evento){
		try {
			pesquisa = (Pesquisa) evento.getComponent().getAttributes().get("itemSelecionado");

			PesquisaDao dao = new PesquisaDao();
			dao.deletar(pesquisa);

			pesquisas = dao.listar();

			Messages.addGlobalInfo("Empresa removida com sucesso! ");
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar excluir");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento){
		pesquisa = (Pesquisa) evento.getComponent().getAttributes().get("itemSelecionado");
	}

	//@PostConstruct
	public void listarQuestoes(){
		
		try {
			questoes = questaoDao.listar();
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar listar");
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void listar(){
		PesquisaDao dao = new PesquisaDao();		
		try {
			//setPesquisas(dao.listar());
			pesquisas = dao.listar();
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar listar");
			e.printStackTrace();
		}
	}
	
	
	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}
	
	public List<Questao> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(List<Questao> questoes) {
		this.questoes = questoes;
	}

	public RelacionamentoPesquisaComQuestoes getRelacao() {
		return relacao;
	}

	public void setRelacao(RelacionamentoPesquisaComQuestoes relacao) {
		this.relacao = relacao;
	}
	
	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Object pesquisaPorCodigo(Integer codigo) {
		PesquisaDao dao = new PesquisaDao();
		
		return dao.pesquisaPorCodigo(codigo);
	}

	public List<Pesquisa> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<Pesquisa> pesquisas) {
		this.pesquisas = pesquisas;
	}


	public RegistroDoUsuario getRegistro() {
		return registro;
	}


	public void setRegistro(RegistroDoUsuario registro) {
		this.registro = registro;
	}

	public List<Questao> getQuestaoSelecionada() {
		return questaoSelecionada;
	}

	public void setQuestaoSelecionada(List<Questao> questaoSelecionada) {
		this.questaoSelecionada = questaoSelecionada;
	}
}
