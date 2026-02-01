package org.primefaces.test.inicio;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LinkDTO implements Serializable {
	
	private MenuGroup group;
	private String value;
	private String outcome;
}