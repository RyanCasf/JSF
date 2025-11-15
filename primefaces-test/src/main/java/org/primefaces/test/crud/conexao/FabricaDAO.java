package org.primefaces.test.crud.conexao;

import org.primefaces.test.crud.entidade.EntidadeDAO;
import org.primefaces.test.crud.entidade.EntidadeInterface;
import org.primefaces.test.crud.historico.HistoricoDAO;
import org.primefaces.test.crud.historico.HistoricoInterface;

public class FabricaDAO {
	
	public static HistoricoInterface criarHistoricoDAO() {
		return new HistoricoDAO();
	}
	
	public static EntidadeInterface criarEntidadeDAO() {
		return new EntidadeDAO();
	}
}