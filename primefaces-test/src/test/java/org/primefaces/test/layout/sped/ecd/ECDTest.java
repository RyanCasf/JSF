package org.primefaces.test.layout.sped.ecd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.primefaces.test.layout.sped.SPEDTabela;

class ECDTest {
	
	private ECD ecd;
	
	@BeforeEach
	void setUp() {
		ecd = new ECD();
		assertNull(ecd.getTabela());
	}
	
	@Nested
	class Tabela {
		
		@Test
		void accept() {
			List<SPEDTabela> tabela = ecd.getSPEDTabela();
			
			assertEquals(2, tabela.size());
			assertEquals("Bloco 0", tabela.get(0).getTitle());
			assertEquals("Abertura, Identificação e Referências", tabela.get(0).getDescription());
			assertEquals("Registro 0000", tabela.get(1).getTitle());
			assertEquals("Abertura do Arquivo Digital e Identificação do Empresário ou da Sociedade Empresária", tabela.get(1).getDescription());
		}
	}
}