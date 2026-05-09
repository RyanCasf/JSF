package org.primefaces.test.layout.sped.ecd;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ECDService implements Serializable {
	
	private ECD ecd;
	
	public ECDService() {
		ecd = new ECD();
		ecd.setTabela(ecd.getSPEDTabela());
	}
}