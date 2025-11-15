package org.primefaces.test.crud.conexao;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class FabricaDAOTest {
	
	@Nested
	class CriarHistoricoDAO {
		
		@Test
		void aceito() {
			assertNotNull(FabricaDAO.criarHistoricoDAO());
		}
	}
	
	@Nested
	class CriarEntidadeDAO {
		
		@Test
		void aceito() {
			assertNotNull(FabricaDAO.criarEntidadeDAO());
		}
	}
}