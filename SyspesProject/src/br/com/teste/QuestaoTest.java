package br.com.teste;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.QuestaoDao;
import br.com.modelo.Questao;
import br.com.modelo.Tipo;

public class QuestaoTest {
	
	@Ignore
	@Test
	public void cadastro(){
		Questao q = new Questao();
		q.setTipo(Tipo.VERDADEIRO_FALSO);
		q.setEnunciado("Você Fuma ?");
		q.setObservacoes("tudo certo");

		QuestaoDao dao = new QuestaoDao();
		try {
			dao.cadastrar(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void listar(){
		QuestaoDao dao = new QuestaoDao();
		List<Questao> questoes;
		try {
			questoes = dao.listar();
			for(Questao questao: questoes){
				System.out.println("Enunciado: "+ questao.getEnunciado());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void buscar(){
		Integer codigo = 7;
		QuestaoDao dao = new QuestaoDao();
		
		try {
			Questao q = dao.buscar(codigo);
			System.out.println("Codigo: "+ q.getCodQuestoes());
			System.out.println("Enunciado: "+ q.getEnunciado());
			System.out.println("Tipo: "+ q.getTipo());
			
			dao.deletar(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
