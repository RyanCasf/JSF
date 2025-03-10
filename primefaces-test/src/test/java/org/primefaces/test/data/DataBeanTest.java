package org.primefaces.test.data;

import static org.mockito.Mockito.mockStatic;

import javax.faces.context.FacesContext;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Data Bean")
@ExtendWith(MockitoExtension.class)
class DataBeanTest {
	
	@InjectMocks
	private DataBean bean;
	
	@Nested
	@DisplayName("Selecionar Data")
	class SelecionarData {
		
		@Mock
		private FacesContext facesContextMock;
		
		@Test
		@DisplayName("Aceito.")
		void aceito() {
			try (MockedStatic<FacesContext> facesContext = mockStatic(FacesContext.class)) {
				facesContext.when(() -> FacesContext.getCurrentInstance()).thenReturn(facesContextMock);
				
				Assertions.assertDoesNotThrow(() -> bean.selecionarData());
				
				facesContext.verify(() -> FacesContext.getCurrentInstance());
				facesContext.verifyNoMoreInteractions();
			}
		}
	}
}