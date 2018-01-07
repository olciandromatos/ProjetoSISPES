package br.com.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.RegistroDoUsuario;

public class RegistroUsuarioDao extends PercistenciaJPA implements OperacaoCRUD<RegistroDoUsuario>{
	
	@Override
	public void cadastrar(RegistroDoUsuario entidade)throws SQLException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		
		em.close();
		
	}

	@Override
	public void deletar(RegistroDoUsuario entidade) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<RegistroDoUsuario> listar() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

}
