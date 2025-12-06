package org.primefaces.test.select.menu.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class SelectOneMenuLazyBean implements Serializable {
	
	private List<String> items;
	
	public List<String> getItems() {
		System.out.println("getItems");
		
		if (items == null) {
			System.out.println("init");
			items = new ArrayList<>(Arrays.asList("0", "1", "2"));
		}
		
		return items;
	}
}