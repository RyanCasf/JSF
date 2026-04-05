package org.primefaces.test.layout.chat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interacao implements Serializable {
	
	private List<Chat> chat = new ArrayList<>();
}