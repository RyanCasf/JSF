package org.primefaces.test.async;

import java.io.Serializable;

import org.primefaces.model.StreamedContent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DownloadContext implements Serializable {
	
	private AsyncStatus status;
    private StreamedContent streamedContent;
}