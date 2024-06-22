package org.primefaces.test.crud.util;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public interface CadastrarManagerGenericoTeste<T, E> {
	
	T setUp();
	E criarNegocio();
	
	@BeforeEach
	default void beforeEach() {
		T manager = setUp();
		
		assertAll(
			() -> assertNull(((CadastrarManagerGenerico) manager).getNegocio()),
			() -> assertFalse(((CadastrarManagerGenerico) manager).isVisualizar())
		);
	}
	
	@Test
	@DisplayName("Novo.")
	default void novo() {
		T manager = setUp();
		((CadastrarManagerGenerico) manager).setVisualizar(true);
		
		((CadastrarManagerGenerico) manager).novo();
		
		assertAll(
			() -> assertNotNull(((CadastrarManagerGenerico) manager).getNegocio()),
			() -> assertFalse(((CadastrarManagerGenerico) manager).isVisualizar())
		);
	}
	
	@Test
	@DisplayName("Definir negócio.")
	default void definirNegocio() {
		T manager = setUp();
		
		E negocio = criarNegocio();
		((CadastrarManagerGenerico) manager).setNegocio(negocio);
		
		assertEquals(negocio, ((CadastrarManagerGenerico) manager).getNegocio());
	}
	
	@ParameterizedTest(name = "Valor: ''{0}''")
	@ValueSource(booleans = { true, false })
	@DisplayName("Definir visualizar.")
	default void definirVisualizar(boolean visualizar) {
		T manager = setUp();
		((CadastrarManagerGenerico) manager).setVisualizar(visualizar);
		
		assertEquals(visualizar, ((CadastrarManagerGenerico) manager).isVisualizar());
	}
}