package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.Alternativa;

public class AlternativaDao extends PercistenciaJPA implements OperacaoCRUD<Alternativa>{
	
	

	@Override
	public void cadastrar(Alternativa entidade) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public void deletar(Alternativa entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Alternativa> listar() {
		// TODO Auto-generated method stub
		return null;
	}

}
