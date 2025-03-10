package org.primefaces.test.datatable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.primefaces.test.util.ParameterizedNameDefaultTest;

@DisplayName("Data Table Bean")
@ExtendWith(MockitoExtension.class)
class DataTableBeanTeste {
	
	@InjectMocks
	private DataTableBean bean;
	
	@Nested
	@DisplayName("Adicionar Contato")
	class AdicionarContato {
		
		@ParameterizedNameDefaultTest
		@ArgumentsSource(DataTableTestRegistros.class)
		@DisplayName("Aceito.")
		void aceito(Contato contato) {
			bean.setContato(contato);
			
			bean.adicionarContato();
			
			assertEquals(1, bean.getContatos().size());
			assertEquals(contato.getNome(), bean.getContatos().get(0).getNome());
			assertEquals(contato.getCidade(), bean.getContatos().get(0).getCidade());
			assertNull(bean.getContato().getNome());
			assertNull(bean.getContato().getCidade());
		}
	}
}