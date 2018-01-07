package br.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.Pesquisa;

public class PesquisaDao extends PercistenciaJPA implements OperacaoCRUD<Pesquisa>{

	@Override
	public void cadastrar(Pesquisa pesquisa)throws SQLException{
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(pesquisa);
		manager.getTransaction().commit();
		
		manager.close();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pesquisa> listar()throws SQLException{
		EntityManager em = emf.createEntityManager();
		List<Pesquisa> pesquisas = new  ArrayList<Pesquisa>();
		Query query = em.createQuery("SELECT p FROM Pesquisa p");
		pesquisas = query.getResultList();
		
		for (Pesquisa pesquisa : pesquisas) {
			
			pesquisa.setCodPesquisa(pesquisa.getCodPesquisa());
			pesquisa.setTituloDaPesquisa(pesquisa.getTituloDaPesquisa());
			pesquisa.setDataPesquisa(pesquisa.getDataPesquisa());
			pesquisa.setDescricao(pesquisa.getDescricao());
		
		}
		return pesquisas;
	}

	@Override
	public void deletar(Pesquisa entidade)throws SQLException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Pesquisa pesquisa = em.getReference(Pesquisa.class, entidade.getCodPesquisa());
		
		em.remove(pesquisa);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Object pesquisaPorCodigo(Integer codigo) {
		EntityManager manager = emf.createEntityManager();
		return manager.find(Pesquisa.class, codigo);
	}
	
	public Pesquisa buscar(Integer codigo) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
		Pesquisa resultado = manager.find(Pesquisa.class, codigo);
		
		return resultado;
		
	}
}
