package br.com.abstracoes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto extends PercistenciaJPA implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		emf.createEntityManager().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		emf.createEntityManager();
		
	}

}
