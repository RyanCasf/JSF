package org.primefaces.test.util.media;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContentType {
	
	PDF ("application/pdf");
	
	private final String content;
}