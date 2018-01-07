package br.com.abstracoes;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PercistenciaJPA {
	
	String m = "syspesPU";
	String p = "syspesposPU";

	public EntityManagerFactory emf = Persistence.createEntityManagerFactory(p);
}
