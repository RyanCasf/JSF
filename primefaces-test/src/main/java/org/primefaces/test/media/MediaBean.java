package org.primefaces.test.media;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named @ViewScoped
public class MediaBean implements Serializable {
	
	public StreamedContent getArquivo() {
		InputStream inputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/guide.pdf");
		return new DefaultStreamedContent(inputStream, "application/pdf", "guide.pdf");
	}
}