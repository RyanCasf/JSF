package org.primefaces.test.layout.sped.ecd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ECDBloco0Registro0000Test {
	
	private ECDBloco0Registro0000 registro0000;
	
	@BeforeEach
	void setUp() {
		registro0000 = new ECDBloco0Registro0000();
	}
	
	@Nested
	class Tabela {
		
		@Test
		void accept() {
			assertEquals(0, registro0000.getSPEDTabela().size());
		}
	}
}