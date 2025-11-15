package org.primefaces.test.crud.contexto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContextoTest {
	
	@Nested
	class UsuatioLogado {
		
		@Test
		void aceito() {
			assertNotNull(Contexto.getUsuatioLogado());
		}
	}
}