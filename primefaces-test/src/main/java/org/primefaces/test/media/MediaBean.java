package org.primefaces.test.media;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.test.util.media.ContentType;

@Named
@ViewScoped
public class MediaBean implements Serializable {
	
	public StreamedContent getArquivo() {
		return DefaultStreamedContent.builder()
				.stream(() -> FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/guide.pdf"))
				.contentType(ContentType.PDF.getContent())
				.name("PrimeFaces Guide.pdf")
				.build();
	}
}