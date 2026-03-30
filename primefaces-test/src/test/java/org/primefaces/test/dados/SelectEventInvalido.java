package org.primefaces.test.dados;

import java.util.stream.Stream;

import javax.faces.component.behavior.BehaviorBase;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.primefaces.component.api.UITabPanel;
import org.primefaces.event.SelectEvent;

public class SelectEventInvalido implements ArgumentsProvider {
	
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return Stream.of(nulo(), semObjeto()).map(Arguments::of);
	}
	
	private SelectEvent nulo() {
		return null;
	}
	
	private SelectEvent semObjeto() {
		return new SelectEvent(new UITabPanel(), new BehaviorBase(), null);
	}
}