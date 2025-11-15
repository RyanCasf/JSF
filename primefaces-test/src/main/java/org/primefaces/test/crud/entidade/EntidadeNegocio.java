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
import org.primefaces.test.crud.util.ValidatorHelper;
import org.primefaces.test.crud.util.ValidatorHelper.RetornoValidacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntidadeNegocio implements Serializable, EntidadeNegocioGenerico {
	
	private Entidade entidade = new Entidade();
	
	public RetornoNegocio salvar() {
		RetornoValidacao retorno = ValidatorHelper.validar(entidade);
		if (retorno.getResultado() == Resultado.REPROVADO) {
			return RetornoNegocio.builder()
					.resultado(Resultado.REPROVADO)
					.mensagens(retorno.getMensagens())
					.build();
		}
		
		EntidadeInterface eDAO = criarEntidadeDAO();
		eDAO.salvar(entidade);
		
		HistoricoInterface hDAO = criarHistoricoDAO();
		hDAO.registrar(new Operacao(new Date(), "Entidade salva", getUsuatioLogado()));
		
		return RetornoNegocio.builder().resultado(Resultado.ACEITO).mensagem("...").build();
	}
	
	public RetornoNegocio carregar(long chave) {
		EntidadeInterface eDAO = criarEntidadeDAO();
		entidade = eDAO.obter(chave);
		
		if (entidade == null) {
			return RetornoNegocio.builder()
					.resultado(Resultado.REPROVADO)
					.mensagem("Entidade não foi encontrada!")
					.build();
		}
		
		return RetornoNegocio.builder().resultado(Resultado.ACEITO).mensagem("").build();
	}
}