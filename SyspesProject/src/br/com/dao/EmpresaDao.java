package br.com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.abstracoes.OperacaoCRUD;
import br.com.abstracoes.PercistenciaJPA;
import br.com.modelo.Empresa;

public class EmpresaDao extends PercistenciaJPA implements OperacaoCRUD<Empresa>{
	
	
	public void cadastrar(Empresa empresa) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
			manager.getTransaction().begin();
			if(empresa == null){
			manager.persist(empresa);
			}else{
				manager.persist(empresa);
			}
			manager.getTransaction().commit();

			manager.close();
			System.out.println("Empresa cadastrada com sucesso!: dao");
	}
	
	public void update(Empresa empresa) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
			manager.getTransaction().begin();
			manager.merge(empresa);
			manager.getTransaction().commit();

			manager.close();
			System.out.println("Empresa cadastrada com sucesso!: dao");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> listar() throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
		List<Empresa> empresas = new ArrayList<Empresa>();
		Query query = manager.createQuery("SELECT e FROM Empresa e");
		empresas = query.getResultList();
		
		for (Empresa empresa : empresas) {
			
			empresa.setCodEmpresa(empresa.getCodEmpresa());
			empresa.setCnpj(empresa.getCnpj());
			empresa.setNomeFantasia(empresa.getNomeFantasia());
			empresa.setNumeroFuncionario(empresa.getNumeroFuncionario());
			empresa.setInstituicao(empresa.getInstituicao());
			empresa.setUnidade(empresa.getUnidade());
			empresa.setUf(empresa.getUf());
			empresa.setResponsavel(empresa.getResponsavel());
			empresa.setEmail(empresa.getEmail());
		}
		
		return empresas;
		
	}

	@Override
	public void deletar(Empresa entidade) throws SQLException {
		EntityManager manager = emf.createEntityManager();
		
			manager.getTransaction().begin();
			Empresa empresa = manager.getReference(Empresa.class, entidade.getCodEmpresa());
			manager.remove(empresa);
			manager.getTransaction().commit();
			System.out.println("Deletado");
	
			manager.close();
		
	}
	
	public Empresa buscar(Integer codigo) throws SQLException{
		EntityManager manager = emf.createEntityManager();
		
		Empresa resultado = manager.find(Empresa.class, codigo);
		
		return resultado;
		
	}

	
}
