package org.primefaces.test.layout.sped;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface SPEDInterface {
	
	default List<SPEDTabela> getSPEDTabela() {
		List<SPEDTabela> tabela = new ArrayList<>();
		recurse(tabela, this);
		
		return tabela;
	}
	
	default void recurse(List<SPEDTabela> tabela, Object instance) {
		if (instance == null) return;
		
		Field[] fields = instance.getClass().getDeclaredFields();
		for (Field field : fields) {
			SPEDGerarLinha annotation = field.getAnnotation(SPEDGerarLinha.class);
			if (annotation == null) continue;
			
			SPEDTabela temp = new SPEDTabela();
			temp.setTitle(annotation.title());
			temp.setDescription(annotation.description());
			tabela.add(temp);
			
			try {
				field.setAccessible(true);
				Object value = field.get(instance);
				
				if (value instanceof SPEDInterface) {
					recurse(tabela, value);
				}
			}
			catch (IllegalArgumentException | IllegalAccessException e) {
				throw new SPEDTabelaException(e);
			}
		}
	}
}