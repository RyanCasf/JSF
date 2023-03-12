package br.com.ryan.card;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS) @DisplayName("Card Manager")
class CardManagerTeste {
	
	private CardManager manager;
	
	@BeforeEach
	void novo() {
		manager = new CardManager();
	}
	
	@Test @DisplayName("Retorno do t�tulo fixo.")
	void getTitle() {
		assertEquals("Gerente", manager.getTitle());
	}
	
	@Test @DisplayName("Retorno do subt�tulo fixo.")
	void getSubTitle() {
		assertEquals("Ger�ncia geral", manager.getSubtitle());
	}
}