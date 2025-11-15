package org.primefaces.test.crud.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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
		
		@BeforeEach
		void setUp() {
			negocio.getEntidade().setMensagem("Mensagem");
			
			CampoDinamico campoDinamico = new CampoDinamico();
			campoDinamico.setNome("Unidade de Medida");
			negocio.getEntidade().setCamposDinamicos(new ArrayList<>(Arrays.asList(campoDinamico)));
		}
		
		@ParameterizedTest(name = "Mensagem: ''{0}''.")
		@NullAndEmptySource
		@DisplayName("Sem mensagem.")
		void semMensagem(String mensagem) {
			negocio.getEntidade().setMensagem(mensagem);
			
			RetornoNegocio retorno = negocio.salvar();
			assertEquals(Resultado.REPROVADO, retorno.getResultado());
			assertEquals("O campo 'Mensagem' é necessário!", retorno.getMensagens().stream().collect(Collectors.joining()));
		}
		
		@ParameterizedTest(name = "Campos Dinâmicos: ''{0}''.")
		@NullAndEmptySource
		@DisplayName("Sem campos dinâmicos.")
		void semCamposDinamicos(List<CampoDinamico> camposDinamicos) {
			negocio.getEntidade().setCamposDinamicos(camposDinamicos);
			
			RetornoNegocio retorno = negocio.salvar();
			assertEquals(Resultado.REPROVADO, retorno.getResultado());
			assertEquals("A lista campos dinâmicos não pode estar vazia!", retorno.getMensagens().stream().collect(Collectors.joining()));
		}
		
		@Test
		@DisplayName("Aceito.")
		void aceito() {
			RetornoNegocio retorno = negocio.salvar();
			assertEquals(Resultado.ACEITO, retorno.getResultado());
			assertEquals("...", retorno.getMensagem());
		}
	}
}