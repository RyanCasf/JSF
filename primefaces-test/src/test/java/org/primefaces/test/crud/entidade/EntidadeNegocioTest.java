package org.primefaces.test.crud.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;

@DisplayName("Entidade Negócio")
class EntidadeNegocioTest {
	
	private EntidadeNegocio negocio;
	
	@BeforeEach
	void setUp() {
		negocio = new EntidadeNegocio();
	}
	
	@Nested
	@DisplayName("Salvar")
	class Salvar {
		
		@ParameterizedTest(name = "Mensagem: ''{0}''.")
		@NullAndEmptySource
		@DisplayName("Sem mensagem.")
		void semMensagem(String mensagem) {
			negocio.getEntidade().setMensagem(mensagem);
			
			RetornoNegocio retorno = negocio.salvar();
			
			assertEquals(Resultado.REPROVADO, retorno.getResultado());
			assertEquals("O campo 'Mensagem' é necessário!", retorno.getMensagens().stream().collect(Collectors.joining()));
		}
	}
}