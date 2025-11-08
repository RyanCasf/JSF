package org.primefaces.test.datatable;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class VirtualScrollingBean implements Serializable {
	
	private LazyVirtualScrollingModel model = new LazyVirtualScrollingModel();
}