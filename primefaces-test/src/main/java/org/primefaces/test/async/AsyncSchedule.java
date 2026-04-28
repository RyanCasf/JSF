package org.primefaces.test.async;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;

import lombok.Getter;
import lombok.Setter;

@Named
@Getter
@Setter
@ViewScoped
public class AsyncSchedule implements Serializable {
	
	private AsyncScheduleNegocio negocio;
	
	public void disparar(String nomeClasse) {
		negocio = new AsyncScheduleNegocio();
		RetornoNegocio retorno = negocio.disparar(nomeClasse);
		
		if (retorno.getResultado() == Resultado.ACEITO) {
			PrimeFaces.current().executeScript("PF('pollAsync').start()");
		}
    }
	
	public void verificar() {
		AsyncStatus retorno = negocio.verificar();
		
		System.out.println(retorno);
		if (retorno == AsyncStatus.EM_ANDAMENTO) {
			return;
		}
		else if (retorno == AsyncStatus.CONCLUIDO) {
			PrimeFaces.current().executeScript("PF('dlgAsync').hide()");
			PrimeFaces.current().executeScript("PF('pollAsync').stop()");
			PrimeFaces.current().executeScript("PF('dlgAsyncPronto').show()");
		}
		else if (retorno == AsyncStatus.ERRO) {
			PrimeFaces.current().executeScript("PF('dlgAsync').hide()");
			PrimeFaces.current().executeScript("PF('pollAsync').stop()");
			PrimeFaces.current().executeScript("PF('dlgAsyncErro').show()");
		}
	}
}