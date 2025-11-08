package org.primefaces.test.ajax;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class AjaxPollBean implements Serializable {
	
	private Long count = 0l;
	
	public void incrementar() {
		count++;
	}
}