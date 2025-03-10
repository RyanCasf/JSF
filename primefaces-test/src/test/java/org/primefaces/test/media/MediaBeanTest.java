package org.primefaces.test.media;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.InputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Media Bean")
@ExtendWith(MockitoExtension.class)
class MediaBeanTest {
	
	private MediaBean bean;
	
	@BeforeEach
	void setUp() {
		bean = new MediaBean();
	}
	
	@Nested
	@DisplayName("Arquivo")
	class Arquivo {
		
		@Mock
		private FacesContext facesContextMock;
		
		@Mock
		private ExternalContext externalContextMock;
		
		@Mock
		private InputStream inputStreamMock;
		
		@Test
		@DisplayName("Aceito.")
		void aceito() {
			try (MockedStatic<FacesContext> facesContext = mockStatic(FacesContext.class)) {
				facesContext.when(() -> FacesContext.getCurrentInstance()).thenReturn(facesContextMock);
				when(facesContextMock.getExternalContext()).thenReturn(externalContextMock);
				when(externalContextMock.getResourceAsStream("/resources/pdf/guide.pdf")).thenReturn(inputStreamMock);
				
				assertNotNull(bean.getArquivo().getStream());
				assertEquals("application/pdf", bean.getArquivo().getContentType());
				assertEquals("guide.pdf", bean.getArquivo().getName());
			}
		}
	}
}