package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bean.EstadoBean;
import br.com.modelo.Estado;
@FacesConverter(forClass = Estado.class)
public class EstadoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0) {
			
			Integer codigo = Integer.valueOf(codigoString);
			
			EstadoBean bean = new EstadoBean();
          
            return bean.pesquisaPorCodigo(codigo);
           
        }
        else {
            return null;
        }
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object estadoObjeto) {
		 if(estadoObjeto != null) {
			 Estado estado = (Estado) estadoObjeto;
	            return estado.getId().toString();
	        }
	     return null;  
	}
}
