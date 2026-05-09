package org.primefaces.test.xhtml;

import static org.junit.jupiter.api.Assertions.fail;

import java.nio.file.Path;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.w3c.dom.Node;

@DisplayName("p:commandButton")
class CommandButton {
	
	private static final String NAME_EXPRESSION = "//*[local-name()='commandButton']";
	
	@Nested
	class Action implements Parser {
		
		@Override
		public void action(Node node, Path path) {
			Node action = node.getAttributes().getNamedItem("action");
			
			if (action != null) {
				fail("O atributo 'action' é desnecessário!\n" + path.toString());
			}
		}
		
		@Override
		public String expression() {
			return NAME_EXPRESSION;
		}
	}
}