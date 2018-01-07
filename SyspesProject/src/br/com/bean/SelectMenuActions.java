package br.com.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SelectMenuActions {

	private String m_sValue;

	public void setValue(String p_sValue) {
		m_sValue = p_sValue;
	}

	public String getValue() {
		return m_sValue;
	}
}
