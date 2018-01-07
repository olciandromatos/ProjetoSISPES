package br.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.Estado;

public class EstadoDao extends PercistenciaJPA implements OperacaoCRUD<Estado>{


	@Override
	public void cadastrar(Estado entidade) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(entidade);
		manager.getTransaction().commit();
		manager.close();
		
	}

	@Override
	public void deletar(Estado entidade) throws SQLException{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Estado estado = em.getReference(Estado.class, entidade.getId());
		em.remove(estado);
		em.getTransaction().commit();
		
		em.close();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listar() throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
		Query query = manager.createQuery("SELECT e FROM Estado e");
		List<Estado> estados = new ArrayList<Estado>();
		estados = query.getResultList();
		
		for (Estado estado : estados) {
			estado.setId(estado.getId());
			estado.setNome(estado.getNome());
			estado.setUf(estado.getUf());
		}
		return estados;
	}
	
	public 	Estado pesquisaPorCodigo(Integer codigo) {
		EntityManager manager = emf.createEntityManager();
		
		return manager.find(Estado.class, codigo);
	} 
	
	public 	Estado pesquisaPorCodigo(String uf) {
		EntityManager manager = emf.createEntityManager();
		
		return manager.find(Estado.class, uf);
	} 

}
