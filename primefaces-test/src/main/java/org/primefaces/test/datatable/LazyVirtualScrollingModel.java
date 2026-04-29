package org.primefaces.test.datatable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

public class LazyVirtualScrollingModel extends LazyDataModel<Entidade> {
	
	@Override
	public List<Entidade> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		System.out.println("first: " + first);
		System.out.println("pageSize: " + pageSize);
		System.out.println("calc: " + (first + pageSize));
		System.out.println("-------------------");
		
		return LongStream.rangeClosed(first, (first + pageSize))
		        .mapToObj(Entidade::new)
		        .collect(Collectors.toList());
	}
	
	@Override
	public int count(Map<String, FilterMeta> filterBy) {
		return 2_000;
	}
	
	@Override
	public Entidade getRowData(String rowKey) {
		if (rowKey == null) return null;
		return new Entidade(Long.parseLong(rowKey));
	}
	
	@Override
	public String getRowKey(Entidade object) {
		if (object == null) return null;
		return Optional.ofNullable(object.getOrdem())
				.map(Object::toString)
				.orElse(null);
	}
}