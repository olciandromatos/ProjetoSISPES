package br.com.teste;

import java.sql.SQLException;

import org.junit.Test;

import br.com.dao.TipoDao;
import br.com.modelo.Tipo;
import br.com.modelo.TipoDeQuestao;

public class TipoTest {

	@Test
	public void salvar(){
		TipoDeQuestao t = new TipoDeQuestao();
		t.setTipo(Tipo.VERDADEIRO_FALSO);
		
		TipoDao dao = new TipoDao();
		try {
			dao.cadastrar(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
