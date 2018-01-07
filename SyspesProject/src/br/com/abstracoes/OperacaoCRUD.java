package br.com.abstracoes;

import java.sql.SQLException;
import java.util.List;

public interface OperacaoCRUD<E> {
	
	public void cadastrar(E entidade)throws SQLException ;
	public void deletar(E entidade) throws SQLException;
	public List<E> listar() throws SQLException;
	

}
