package br.com.teste;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.dao.PesquisaDao;
import br.com.modelo.Pesquisa;
import br.com.modelo.RegistroDoUsuario;

public class PesquisaTest {

	@Test
	public void salvar(){
		
		RegistroDoUsuario r = new RegistroDoUsuario();
		r.setCodRegistro(11);
	
		
		Pesquisa p = new Pesquisa();
		p.setTituloDaPesquisa("O atendimento na empresa");
		p.setDescricao("quero saber como está a recepção na empresa");
		p.setDataPesquisa(new Date());
		
		
		PesquisaDao dao = new PesquisaDao();
		try {
			dao.cadastrar(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void buscar(){
		Integer codigo = 27;
		PesquisaDao dao = new PesquisaDao();
		try {
			Pesquisa pesquisa = dao.buscar(codigo);
			System.out.println("Codigo"+pesquisa.getCodPesquisa());
		} catch (SQLException e) {
			System.out.println("Erro ao buscar");
			e.printStackTrace();
		}
		
	}
}
