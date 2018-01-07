	package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.bean.QuestaoBean;
import br.com.modelo.Questao;

@FacesConverter(forClass = Questao.class)
public class QuestãoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String codigoString) {
		if(codigoString != null && codigoString.trim().length() > 0) {
			
			Integer codigo = Integer.valueOf(codigoString);
			QuestaoBean bean = new QuestaoBean();
          
            return bean.pesquisaPorCodigo(codigo);
           
        }
        else {
            return null;
        }
		
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object questaoObjeto) {
		 if(questaoObjeto != null) {
			 Questao questao = (Questao) questaoObjeto;
	            return questao.getCodQuestoes().toString();
	        }
	     return null;  
	}

}
