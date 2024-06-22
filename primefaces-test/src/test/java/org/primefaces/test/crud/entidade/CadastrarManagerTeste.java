package org.primefaces.test.crud.entidade;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import javax.faces.context.FacesContext;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.MockedConstruction;
import org.mockito.MockedConstruction.Context;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.primefaces.context.RequestContext;
import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;
import org.primefaces.test.crud.util.CadastrarManagerGenericoTeste;

@ExtendWith(MockitoExtension.class)
@DisplayName("Cadastrar Manager")
class CadastrarManagerTeste implements CadastrarManagerGenericoTeste<CadastrarManager, EntidadeNegocio> {
	
	@InjectMocks
	private CadastrarManager manager;
	
	@Override
	public CadastrarManager setUp() {
		return new CadastrarManager();
	}
	
	@Override
	public EntidadeNegocio criarNegocio() {
		return new EntidadeNegocio();
	}
	
	@ParameterizedTest(name = "Visualizar: ''{0}''.")
	@ValueSource(booleans = { false, true })
	@DisplayName("Carregar reprovado.")
	void carregarReprovado(boolean visualizar) {
		try (MockedConstruction<EntidadeNegocio> negocio = mockConstruction(EntidadeNegocio.class, this::prepararCarregarReprovado);
				MockedStatic<RequestContext> requestContext = mockStatic(RequestContext.class);
				MockedStatic<FacesContext> facesContext = mockStatic(FacesContext.class);) {
			
			FacesContext facesContextMock = mock(FacesContext.class);
			facesContext.when(() -> FacesContext.getCurrentInstance()).thenReturn(facesContextMock);
			
			RequestContext requestContextMock = mock(RequestContext.class);
			requestContext.when(() -> RequestContext.getCurrentInstance()).thenReturn(requestContextMock);
			
			manager.carregar(0l, visualizar);
			
			assertAll(
				() -> assertEquals(visualizar, manager.isVisualizar()),
				() -> assertNotNull(manager.getNegocio())
			);
		}
	}
	
	private void prepararCarregarReprovado(EntidadeNegocio negocio, Context context) {
		when(negocio.carregar(0l)).thenReturn(new RetornoNegocio(Resultado.REPROVADO, ""));
	}
	
	@ParameterizedTest(name = "Visualizar: ''{0}''.")
	@ValueSource(booleans = { false, true })
	@DisplayName("Carregar ceito.")
	void carregarAceito(boolean visualizar) {
		try (MockedConstruction<EntidadeNegocio> negocio = mockConstruction(EntidadeNegocio.class, this::prepararCarregarAceito);
				MockedStatic<RequestContext> requestContext = mockStatic(RequestContext.class)) {
			
			RequestContext requestContextMock = mock(RequestContext.class);
			requestContext.when(() -> RequestContext.getCurrentInstance()).thenReturn(requestContextMock);
			
			manager.carregar(0l, visualizar);
			
			assertAll(
				() -> assertEquals(visualizar, manager.isVisualizar()),
				() -> assertNotNull(manager.getNegocio())
			);
		}
	}
	
	private void prepararCarregarAceito(EntidadeNegocio negocio, Context context) {
		when(negocio.carregar(0l)).thenReturn(new RetornoNegocio(Resultado.ACEITO, ""));
	}
}