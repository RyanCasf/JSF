package org.primefaces.test.layout.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatNegocio implements Serializable {
	
	private List<Interacao> interacoes;
	private int indexInteracao = 0;
	private Chat chat;
	
	public ChatNegocio() {
		chat = new Chat();
		interacoes = new ArrayList<>(Arrays.asList(new Interacao()));
	}
}