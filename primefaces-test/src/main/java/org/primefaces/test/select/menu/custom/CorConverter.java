package org.primefaces.test.select.menu.custom;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Cor.class, value = "corConverter")
public class CorConverter implements Converter<Cor> {
	
	@Override
	public Cor getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.isEmpty()) {
            return null;
        }
		
        return Cor.valueOf(value.toUpperCase());
	}
	
	@Override
	public String getAsString(FacesContext context, UIComponent component, Cor value) {
		if (value != null) {
			return value.name();
		}
		
		return null;
	}
}