package org.primefaces.test.layout.sped.ecd;

import java.io.Serializable;

import org.primefaces.test.layout.sped.SPEDGerarLinha;
import org.primefaces.test.layout.sped.SPEDInterface;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ECDBloco0 implements Serializable, SPEDInterface {
	
	@SPEDGerarLinha(
			title = "Registro 0000",
			description = "Abertura do Arquivo Digital e Identificação do Empresário ou da Sociedade Empresária")
	private ECDBloco0Registro0000 registro0000 = new ECDBloco0Registro0000();
}