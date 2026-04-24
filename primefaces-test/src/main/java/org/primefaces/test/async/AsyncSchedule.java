package org.primefaces.test.async;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.model.StreamedContent;

import lombok.Getter;

@Named
@ViewScoped
public class AsyncSchedule implements Serializable {
	
	private String nomeClasse;
	
	@Getter
	private DownloadContext resultado;
	
	public void disparar(String nomeClasse) {
		this.nomeClasse = nomeClasse;
		PrimeFaces.current().executeScript("PF('pollAsync').start()");
    }
	
	public <T> void verificar() {
		if (resultado == null) {
			resultado = new DownloadContext();
			resultado.setStatus(AsyncStatus.EM_ANDAMENTO);
			
			AsyncTask<T> task = null;
			try {
		        Class<?> clazz = Class.forName(nomeClasse);
		        task = (AsyncTask<T>) clazz.newInstance();
		    }
			catch (Exception e) {
		        e.printStackTrace();
		    }
			
			try {
	            task.run();
	            T conteudo = task.getConteudo();
	            
	            if (conteudo instanceof StreamedContent) {
	                resultado.setStreamedContent((StreamedContent) conteudo);
	            }
	            
	            resultado.setStatus(AsyncStatus.CONCLUIDO);
	        }
			catch (Exception e) {
	        	e.printStackTrace();
	        	resultado.setStatus(AsyncStatus.ERRO);
	        }
			
			return;
		}
		
		if (resultado.getStatus() != AsyncStatus.EM_ANDAMENTO) {
			PrimeFaces.current().executeScript("PF('pollAsync').stop()");
		}
	}
}