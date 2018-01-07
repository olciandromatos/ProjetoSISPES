package br.com.teste;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.EstadoDao;
import br.com.modelo.Estado;

public class EstadoTest {
	@Test
	public void cadastrar(){
		Estado estado = new Estado();
		estado.setNome("Acre");
		estado.setUf("AC");
		
		Estado estado1 = new Estado();
		estado1.setNome("Alagoas");
		estado1.setUf("AL");
		
		Estado estado2 = new Estado();
		estado2.setNome("Amazonas");
		estado2.setUf("AM");
		
		Estado estado3 = new Estado();
		estado3.setNome("Amapá");
		estado3.setUf("AP");
		
		Estado estado4 = new Estado();
		estado4.setNome("Bahia");
		estado4.setUf("BA");
		
		Estado estado5 = new Estado();
		estado5.setNome("Ceará");
		estado5.setUf("CE");
		
		EstadoDao dao = new EstadoDao();
		try {
			dao.cadastrar(estado);
			dao.cadastrar(estado1);
			dao.cadastrar(estado2);
			dao.cadastrar(estado3);
			dao.cadastrar(estado4);
			dao.cadastrar(estado5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Ignore
	public void listar(){
		EstadoDao dao = new EstadoDao();
		List<Estado> estados;
		try {
			estados = dao.listar();
			for (Estado estado : estados) {
				System.out.println("ID: "+ estado.getId());
				System.out.println("nome: "+ estado.getNome());
				System.out.println("UF: "+ estado.getUf());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
