package org.primefaces.test.datatable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;

public class LazyVirtualScrollingModel extends LazyDataModel<Entidade> {
	
	@Override
	public List<Entidade> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {
		return load(first, pageSize, null, null, null);
	}
	
	public List<Entidade> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		System.out.println("first: " + first);
		System.out.println("pageSize: " + pageSize);
		System.out.println("calc: " + (first + pageSize));
		System.out.println("-------------------");
		
		setRowCount(2_000);
		return LongStream.rangeClosed(first, (first + pageSize))
		        .mapToObj(Entidade::new)
		        .collect(Collectors.toList());
	}
}