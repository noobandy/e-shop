package in.anandm.eshop.inventoryservice.model;

import java.util.List;

public class SearchResult {

	private Search search;
	private List<Product> results;
	private long totalMatched;
	
	public SearchResult() {
		
		super();
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public List<Product> getResults() {
		return results;
	}

	public void setResults(List<Product> results) {
		this.results = results;
	}

	public long getTotalMatched() {
		return totalMatched;
	}

	public void setTotalMatched(long totalMatched) {
		this.totalMatched = totalMatched;
	}
	
	
}
