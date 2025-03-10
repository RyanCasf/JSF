package org.primefaces.test.autocomplete;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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
	
	@Nested
	@DisplayName("Complete")
	class Complete {
		
		@ParameterizedNameDefaultTest
		@NullAndEmptySource
		@ValueSource(strings = { " ", "   ", "\t", "\n" })
		@DisplayName("Vazio.")
		void vazio(String value) {
			assertTrue(bean.complete(value).isEmpty());
			assertNull(bean.getTexto());
		}
		
		@ParameterizedNameDefaultTest
		@ValueSource(strings = { "String" })
		@DisplayName("Aceito.")
		void aceito(String value) {
			assertEquals(Arrays.asList("0", "1", "2", value), bean.complete(value));
		}
	}
	
	@Nested
	@DisplayName("Item Select")
	class ItemSelect {
		
		@ParameterizedTest(name = "Evento nulo.")
		@NullSource
		@DisplayName("Sem evento.")
		void semEvento(SelectEvent	evento) {
			assertDoesNotThrow(() -> bean.itemSelect(evento));
		}
	}
}