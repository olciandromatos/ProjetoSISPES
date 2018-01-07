package br.com.teste;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.EmpresaDao;
import br.com.modelo.Empresa;
import br.com.modelo.Estado;

public class EmpresaTest {
	
	@Test
	@Ignore
	public void salvar(){
		Empresa e = new Empresa();
		Estado estado = new Estado();
		estado.setId(2);;
		estado.getId();
		
		e.setCnpj("0001/858.225.63-200");
		e.setNomeFantasia("livraria person");
		e.setNumeroFuncionario("100");
		e.setInstituicao("Livraria");;
		e.setUnidade("sao paulo");
		e.setUf(estado);
		e.setResponsavel("jose henrique");
		e.setEmail("j@hotmail");
		
		EmpresaDao dao = new EmpresaDao();
		try {
			dao.cadastrar(e);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	@Test
	public void listar(){
		EmpresaDao dao = new EmpresaDao();
		
		
		
		try {
			List<Empresa> empresas = dao.listar();
			
			empresas.forEach(empresa -> {
				System.out.println("---------------------------------------------------------");
				System.out.println("CNPJ: "+ empresa.getCnpj());
				System.out.println("nomeFantasia: "+ empresa.getNomeFantasia());
				System.out.println("Istituição: "+ empresa.getInstituicao());
				System.out.println("Numero de Funcionario: "+ empresa.getNumeroFuncionario());
				System.out.println("Responsavel: "+ empresa.getResponsavel());
				System.out.println("Email: "+ empresa.getEmail());
				System.out.println("---------------------------------------------------------");
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	@Ignore
	public void buscar(){
		Integer codigo = 36;
		EmpresaDao dao = new EmpresaDao();
		
		try {
			Empresa empresa = dao.buscar(codigo);
			System.out.println("CNPJ: "+ empresa.getCnpj());
			System.out.println("CNPJ: "+ empresa.getCodEmpresa());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void deletar(){
		
		Integer codigo = 43;
		
		try {
			EmpresaDao dao = new EmpresaDao();
			Empresa empresa = dao.buscar(codigo);
			dao.deletar(empresa);
			System.out.println("Excluiu");
		} catch (SQLException e1) {
			System.out.println("erro ao tentar deletar");
			e1.printStackTrace();
		}
		
	}
	

}
