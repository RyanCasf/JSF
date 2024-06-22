package org.primefaces.test.crud.entidade;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;
import org.primefaces.test.crud.util.CadastrarManagerGenerico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class CadastrarManager implements Serializable, CadastrarManagerGenerico<EntidadeNegocio> {

	private EntidadeNegocio negocio;
	private boolean visualizar;

	public void novo() {
		negocio = new EntidadeNegocio();
		visualizar = false;
	}

	public void carregar(long chave, boolean visualizar) {
	    this.visualizar = visualizar;
	    negocio = new EntidadeNegocio();
	    
	    RetornoNegocio retorno = negocio.carregar(chave);
	    if (retorno.getResultado() == Resultado.ACEITO) {
	    	RequestContext.getCurrentInstance().execute("dlgCadastrarEntidade.show()");
	    	RequestContext.getCurrentInstance().update("formularioCadastrarEntidade");
	    }
	    else {
	    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", retorno.getMensagem()));
	    	RequestContext.getCurrentInstance().update("formularioPesquisarEntidade:mensagem");
	    }
	}
}