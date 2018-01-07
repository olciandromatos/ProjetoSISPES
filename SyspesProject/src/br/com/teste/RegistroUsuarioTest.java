package br.com.teste;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import br.com.dao.RegistroUsuarioDao;
import br.com.modelo.Alternativa;
import br.com.modelo.Questao;
import br.com.modelo.RegistroDoUsuario;

public class RegistroUsuarioTest {
	
	@Test
	public void salvar(){
		Questao q = new Questao();
		q.setCodQuestoes(9);
		
		
		Alternativa a = new Alternativa();
		a.setCodAlternativa(8);
		
		
		RegistroDoUsuario r = new RegistroDoUsuario();
		r.setDataCadastro(new Date());
		r.setIpUsuario("255.255.255.5");
		r.setRespostas("SIM");
		r.setQuestoes(q);
		r.setAlternativa(a);
		
		RegistroUsuarioDao dao = new RegistroUsuarioDao();
		try {
			dao.cadastrar(r);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
