package br.com.teste;

import org.junit.Test;

import br.com.dao.AlternativaDao;
import br.com.modelo.Alternativa;
import br.com.modelo.Questao;

public class AlternativaTest {
	
	@Test
	public void salvar(){
		
		Questao q = new Questao();
		q.setCodQuestoes(8);
		
		
		Alternativa a = new Alternativa();
		a.setOrdemDasAlternativas(1);
		a.setTextoDaAlternativa("bçaaçç");
		a.setQuestoes(q);
		
		
		AlternativaDao dao = new AlternativaDao();
		dao.cadastrar(a);
	}

}
