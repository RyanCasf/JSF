package org.primefaces.test.layout.sped.ecd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.primefaces.test.layout.sped.SPEDTabela;

class ECDBloco0Test {
	
	private ECDBloco0 bloco0;
	
	@BeforeEach
	void setUp() {
		bloco0 = new ECDBloco0();
	}
	
	@Nested
	class Tabela {
		
		@Test
		void accept() {
			List<SPEDTabela> tabela = bloco0.getSPEDTabela();
			
			assertEquals(1, tabela.size());
			assertEquals("Registro 0000", tabela.get(0).getTitle());
			assertEquals("Abertura do Arquivo Digital e Identificação do Empresário ou da Sociedade Empresária", tabela.get(0).getDescription());
		}
	}
}