package br.com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.TipoDeQuestao;

public class TipoDao extends PercistenciaJPA implements OperacaoCRUD<TipoDeQuestao>{

	@Override
	public void cadastrar(TipoDeQuestao entidade) throws SQLException{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public void deletar(TipoDeQuestao entidade) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TipoDeQuestao> listar() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}
	

}
