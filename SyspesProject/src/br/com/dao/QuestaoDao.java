package br.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.Questao;

public class QuestaoDao extends PercistenciaJPA implements OperacaoCRUD<Questao>{
	
	@Override
	public void cadastrar(Questao questao)throws SQLException{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		if(questao == null){
		em.persist(questao);
		}else{
			em.persist(questao);
		}
		em.getTransaction().commit();
		
		em.close();
	}
	
	public void update(Questao questao) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
			manager.getTransaction().begin();
			manager.merge(questao);
			manager.getTransaction().commit();

			manager.close();
			System.out.println("Empresa cadastrada com sucesso!: dao");
	}

	@Override
	public void deletar(Questao entidade)throws SQLException {
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		Questao questao = manager.getReference(Questao.class, entidade.getCodQuestoes());
		manager.remove(questao);
		manager.getTransaction().commit();
		System.out.println("Deletado");

		manager.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Questao> listar()throws SQLException {
		EntityManager em = emf.createEntityManager();
		List<Questao> questoes = new ArrayList<>();
		Query query = em.createQuery("SELECT q FROM Questao q");
		questoes = query.getResultList();
		
		for (Questao questao : questoes) {
			questao.setCodQuestoes(questao.getCodQuestoes());
			questao.setEnunciado(questao.getEnunciado());
			questao.setObservacoes(questao.getObservacoes());
			questao.setTipo(questao.getTipo());
		}
		
		return questoes;
	}
		@SuppressWarnings("unchecked")
		public List<Questao> listarEnunciado()throws SQLException {
			EntityManager em = emf.createEntityManager();
			List<Questao> enunciados = new ArrayList<>();
			Query query = em.createQuery("SELECT q FROM Questao q");
			enunciados = query.getResultList();
			
			for (Questao questao : enunciados) {
				questao.setEnunciado(questao.getEnunciado());
			}
			
			return enunciados;
		}
		
		public 	Questao pesquisaPorCodigo(Integer codigo) {
			EntityManager manager = emf.createEntityManager();
					
			return manager.find(Questao.class, codigo);
		} 
		
		public 	Questao buscar(Integer codigo) throws SQLException{
			EntityManager manager = emf.createEntityManager();
			
			Questao resultado = manager.find(Questao.class, codigo);
			
			return resultado;
			
		}
}
