package org.primefaces.test.command.button;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CommandButtonIconBean implements Serializable {
	
	public void run() throws InterruptedException {
		Thread.sleep(1_000);
	}
}