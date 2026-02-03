package org.primefaces.test.xhtml;

import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.w3c.dom.Node;

@DisplayName("p:commandButton")
class CommandButton {
	
	@Nested
	class StyleClass implements Parser {
		
		@Override
		public void action(Node node, Path path) {
			Node styleClass = node.getAttributes().getNamedItem("styleClass");
			
			if (styleClass == null) {
				fail("O atributo 'styleClass' é necessário!\n" + path.toString());
			}
			
			if (!styleClass.getTextContent().equals("botao")) {
				fail("O atributo 'styleClass' deve estar preenchido com 'botao'!\n" + path.toString());
			}
		}
		
		@Override
		public String expression() {
			return "//*[local-name()='commandButton']";
		}
	}
}