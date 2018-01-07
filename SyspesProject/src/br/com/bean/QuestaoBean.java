package br.com.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.dao.QuestaoDao;
import br.com.modelo.Alternativa;
import br.com.modelo.Questao;
import br.com.modelo.Tipo;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class QuestaoBean implements Serializable{
	private Tipo tipo;
	private Questao questao = new Questao();
	private List<Questao> lista = new ArrayList<>();
	private List<Tipo> tipos;
	private boolean selecionado = true;
	private SelectMenuActions select = new SelectMenuActions();
	private Alternativa alternativa;
	
	public void novo() {
		questao = new Questao();

	}

	public void cadastrar(){
		QuestaoDao dao = new QuestaoDao();
		try {
			
			dao.update(questao);
			Messages.addFlashGlobalInfo("Cadastro salvo com sucesso");
			novo();
			System.out.println("Cadastrou");
		} catch (SQLException e) {
			Messages.addFlashGlobalError("Erro ao tentar cadastrar a questao");
			e.printStackTrace();
		}	
	}

	public QuestaoBean() {
		listar();
	}

	@PostConstruct
	public void inicializar() {
		this.setTipos(Arrays.asList(Tipo.values()));
	}

	//@PostConstruct
	public void listar() {
		QuestaoDao dao = new QuestaoDao();
		try {
			lista = dao.listar();
		} catch (SQLException e) {
			Messages.addFlashGlobalError("Erro ao tentar listar os dados ");
			e.printStackTrace();
		}
	}

	public String bemvindo() {
		System.out.println("Chegou aqui");
		return "bemvindo";
	}

	public void excluir(ActionEvent evento) {
		try {
			questao = (Questao) evento.getComponent().getAttributes().get("itemSelecionado");

			QuestaoDao dao = new QuestaoDao();
			dao.deletar(questao);

			lista = dao.listar();

			Messages.addGlobalInfo("Questao removida com sucesso! ");
		} catch (SQLException e) {
			Messages.addGlobalError("Erro ao tentar excluir");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		questao = (Questao) evento.getComponent().getAttributes().get("itemSelecionado");
		
	}

	public Object pesquisaPorCodigo(Integer codigo) {
		QuestaoDao dao = new QuestaoDao();
		return dao.pesquisaPorCodigo(codigo);
	}

	public List<Questao> getLista() {
		return lista;
	}

	public void setLista(List<Questao> lista) {
		this.lista = lista;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}

	public SelectMenuActions getSelect() {
		return select;
	}

	public void setSelect(SelectMenuActions select) {
		this.select = select;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

}
