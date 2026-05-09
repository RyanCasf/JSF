package org.primefaces.test.layout.sped.ecd;

import java.io.Serializable;
import java.util.List;

import org.primefaces.test.layout.sped.SPEDGerarLinha;
import org.primefaces.test.layout.sped.SPEDInterface;
import org.primefaces.test.layout.sped.SPEDTabela;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ECD implements Serializable, SPEDInterface {
	
	@SPEDGerarLinha(
			title = "Bloco 0",
			description = "Abertura, Identificação e Referências")
	private ECDBloco0 bloco0 = new ECDBloco0();
	
	private List<SPEDTabela> tabela;
}