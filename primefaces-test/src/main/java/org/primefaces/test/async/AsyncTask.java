package org.primefaces.test.async;

import java.io.Serializable;

public interface AsyncTask <T> extends Serializable, Runnable {
	
	T getConteudo();
	String getNomeTarefa();
}