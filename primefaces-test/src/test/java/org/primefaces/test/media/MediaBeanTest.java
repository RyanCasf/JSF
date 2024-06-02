package org.primefaces.test.media;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import java.io.InputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.MockedStatic;

@TestInstance(Lifecycle.PER_CLASS)
@DisplayName("Media Bean")
class MediaBeanTest {
	
	private MediaBean bean;
	
	@BeforeEach
	void setUp() {
		bean = new MediaBean();
	}
	
	@Test
	@DisplayName("Pegar arquivo.")
	void pegarArquivo() {
		try (MockedStatic<FacesContext> facesContext = mockStatic(FacesContext.class)) {
			FacesContext facesContextMock = mock(FacesContext.class);
			facesContext.when(() -> FacesContext.getCurrentInstance()).thenReturn(facesContextMock);
			
			ExternalContext externalContextMock = mock(ExternalContext.class);
			when(facesContextMock.getExternalContext()).thenReturn(externalContextMock);
			
			InputStream inputStreamMock = mock(InputStream.class);
			when(externalContextMock.getResourceAsStream("/resources/pdf/guide.pdf")).thenReturn(inputStreamMock);
			
			assertNotNull(bean.getArquivo().getStream());
			assertEquals("application/pdf", bean.getArquivo().getContentType());
			assertEquals("guide.pdf", bean.getArquivo().getName());
		}
	}
}