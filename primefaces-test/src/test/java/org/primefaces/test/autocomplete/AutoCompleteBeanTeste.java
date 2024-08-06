package org.primefaces.test.autocomplete;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.primefaces.event.SelectEvent;
import org.primefaces.test.util.ParameterizedNameDefaultTest;

@DisplayName("AutoComplete Bean")
class AutoCompleteBeanTeste {
	
	private AutoCompleteBean bean;
	
	@BeforeEach
	void setUp() {
		bean = new AutoCompleteBean();
		bean.setTexto("Texto");
	}
	
	@ParameterizedNameDefaultTest
	@NullAndEmptySource
	@ValueSource(strings = { " ", "   ", "\t", "\n" })
	@DisplayName("Complete vazio.")
	void completeVazio(String value) {
		assertTrue(bean.complete(value).isEmpty());
		assertNull(bean.getTexto());
	}
	
	@ParameterizedNameDefaultTest
	@ValueSource(strings = {"String"})
	@DisplayName("Complete.")
	void complete(String value) {
		assertEquals(Arrays.asList("0", "1", "2", value), bean.complete(value));
	}
	
	@ParameterizedTest(name = "Evento nulo.")
	@NullSource
	@DisplayName("ItemSelect com evento nulo.")
	void itemSelectComEventoNulo(SelectEvent	evento) {
		assertDoesNotThrow(() -> bean.itemSelect(evento));
	}
}