package org.primefaces.test.ajax;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.provider.ValueSource;
import org.primefaces.test.util.ParameterizedNameDefaultTest;

@DisplayName("Ajax Poll Bean")
class AjaxPollBeanTest {
	
	private AjaxPollBean bean;
	
	@BeforeEach
	void setUp() {
		bean = new AjaxPollBean();
		assertEquals(0, bean.getCount());
	}
	
	@Nested
	@DisplayName("Incrementar")
	class Incrementar {
		
		@ParameterizedNameDefaultTest
		@ValueSource(ints = { 1 })
		@DisplayName("Aceito.")
		void aceito(int valor) {
			bean.incrementar();
			assertEquals(valor, bean.getCount());
		}
	}
}