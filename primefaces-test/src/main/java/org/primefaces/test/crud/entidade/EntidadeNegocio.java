package org.primefaces.test.crud.entidade;

import static org.primefaces.test.crud.conexao.FabricaDAO.criarEntidadeDAO;
import static org.primefaces.test.crud.conexao.FabricaDAO.criarHistoricoDAO;
import static org.primefaces.test.crud.contexto.Contexto.getUsuatioLogado;

import java.io.Serializable;
import java.util.Date;

import org.primefaces.test.crud.historico.HistoricoInterface;
import org.primefaces.test.crud.historico.Operacao;
import org.primefaces.test.crud.retorno.RetornoNegocio;
import org.primefaces.test.crud.retorno.RetornoNegocio.Resultado;
import org.primefaces.test.crud.util.EntidadeNegocioGenerico;

public class EntidadeNegocio implements Serializable, EntidadeNegocioGenerico {
	
	private Entidade entidade = new Entidade();
	
	public RetornoNegocio salvar() {
		if (entidade.getMensagem() == null || entidade.getMensagem().trim().isEmpty()) {
			return new RetornoNegocio(Resultado.REPROVADO, "...");
		}
		
		EntidadeInterface eDAO = criarEntidadeDAO();
		eDAO.salvar(entidade);
		
		HistoricoInterface hDAO = criarHistoricoDAO();
		hDAO.registrar(new Operacao(new Date(), "Entidade salva", getUsuatioLogado()));
		
		return new RetornoNegocio(Resultado.ACEITO, "...");
	}
	
	public RetornoNegocio carregar(long chave) {
		EntidadeInterface eDAO = criarEntidadeDAO();
		entidade = eDAO.obter(chave);
		
		if (entidade == null) {
			return new RetornoNegocio(Resultado.REPROVADO, "Entidade não foi encontrada!");
		}
		
		return new RetornoNegocio(Resultado.ACEITO, "");
	}
}