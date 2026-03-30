package org.primefaces.test.inicio;

public enum Tema {
	
	REDMOND("redmond"),
	VELA("vela"),
	ARYA("arya"),
	SAGA("saga");
	
	private final String value;
	
	private Tema(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}