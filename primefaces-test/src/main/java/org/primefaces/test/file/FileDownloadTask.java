package org.primefaces.test.file;

import java.io.InputStream;

import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.test.async.AsyncTask;

public class FileDownloadTask implements AsyncTask<StreamedContent> {
	
	private StreamedContent streamedContent;
	
	@Override
	public String getNomeTarefa() {
		return "PrimeFaces Guide";
	}
	
	@Override
	public void run() {
		InputStream inputStream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/pdf/guide.pdf");
		streamedContent = DefaultStreamedContent.builder()
				.stream(() -> inputStream)
				.contentType("application/pdf")
				.name("guide.pdf")
				.build();
	}
	
	@Override
	public StreamedContent getConteudo() {
		return streamedContent;
	}
}