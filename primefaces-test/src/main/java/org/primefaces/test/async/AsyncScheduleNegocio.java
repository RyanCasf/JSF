package org.primefaces.test.async;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;

import lombok.Getter;

public class AsyncScheduleNegocio implements Serializable {
	
	private Future<?> future;
	@Getter private AsyncTask<?> task;
	
	public RetornoNegocio disparar(String nomeClasse) {
		try {
			Class<?> clazz = Class.forName(nomeClasse);
			task = (AsyncTask<?>) clazz.getDeclaredConstructor().newInstance();
		}
		catch (Exception e) {
			e.printStackTrace();
			return RetornoNegocio.builder().resultado(Resultado.REPROVADO).build();
		}
		
		return RetornoNegocio.builder().resultado(Resultado.ACEITO).build();
	}
	
	public AsyncStatus verificar() {
		if (task == null) {
			return AsyncStatus.ERRO;
		}
		
		inicializarAsync();
		
		if (!future.isDone()) {
			return AsyncStatus.EM_ANDAMENTO;
		}
		
		if (future.isCancelled()) {
			return AsyncStatus.ERRO;
		}
		
		Object conteudo = task.getConteudo();
        if (conteudo == null) {
        	return AsyncStatus.ERRO;
        }
        
        return AsyncStatus.CONCLUIDO;
	}
	
	private synchronized void inicializarAsync() {
		if (future != null) {
			return;
		}
		
		future = CompletableFuture.runAsync(() -> {
			try {
	            task.run();
	        }
			catch (Exception e) {
				throw new RuntimeException(e);
	        }
		});
	}
}