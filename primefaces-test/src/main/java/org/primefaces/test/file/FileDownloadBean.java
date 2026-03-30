package org.primefaces.test.file;

import java.io.InputStream;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Named
@ViewScoped
public class FileDownloadBean implements Serializable {
	
    public StreamedContent getFile() {
    	InputStream inputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/guide.pdf");
		return DefaultStreamedContent.builder()
				.stream(() -> inputStream)
				.contentType("application/pdf")
				.name("guide.pdf")
				.build();
    }
}