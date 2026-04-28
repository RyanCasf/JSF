package org.primefaces.test.async;

public interface AsyncTask <T> extends Runnable  {
	
	T getConteudo();
}