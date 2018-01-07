package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import br.com.bean.PesquisaBean;
import br.com.modelo.Pesquisa;

public class PesquisaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0) {
			
			Integer codigo = Integer.valueOf(codigoString);
			PesquisaBean bean = new PesquisaBean();
          
            return bean.pesquisaPorCodigo(codigo);
           
        }
        else {
            return null;
        }
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object pesquisaObjeto) {
		 if(pesquisaObjeto != null) {
			 Pesquisa pesquisa = (Pesquisa) pesquisaObjeto;
	            return pesquisa.getCodPesquisa().toString();
	        }
	     return null;  
	}


}
