package org.primefaces.test.layout.chat;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chat implements Serializable {
	
	private String mensagem;
}