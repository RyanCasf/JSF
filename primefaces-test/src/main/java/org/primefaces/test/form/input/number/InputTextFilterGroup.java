package org.primefaces.test.form.input.number;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class InputTextFilterGroup implements Serializable {
	
	private boolean matchModeStart;
	private String value;
	private boolean matchModeEnd;
	
	@Override
	public String toString() {
		return (matchModeStart ? "%" : "") + value + (matchModeEnd ? "%" : "");
	}
}