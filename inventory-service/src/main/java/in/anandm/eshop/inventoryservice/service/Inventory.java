package in.anandm.eshop.inventoryservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import in.anandm.eshop.inventoryservice.model.Product;
import in.anandm.eshop.inventoryservice.model.ProductRepository;
import in.anandm.eshop.inventoryservice.model.Search;
import in.anandm.eshop.inventoryservice.model.SearchResult;

public class Inventory {

	private ProductRepository productRepository;

	public SearchResult search(Search search) {
		List<Product> all = productRepository.findAll();

		List<Product> matched = all.stream().filter(p -> {
			if (search.getCategory() != null && !search.getCategory().equals(p.getCategory())) {
				return false;
			}

			if (search.getText() != null && !(p.getTitle().indexOf(search.getText()) > 0)
					|| (p.getDescription().indexOf(search.getText()) > 0)) {
				return false;
			}

			return true;
		}).collect(Collectors.toList());

		SearchResult result = new SearchResult();
		result.setSearch(search);
		List<Product> page = new ArrayList<Product>();

		if (search.getPage() != null && search.getPageSize() != null) {
			int start = (search.getPage() - 1) * search.getPageSize();
			int end = start + search.getPageSize();

			if (end > matched.size()) {
				end = matched.size();
			}

			if (start > 0 && start < matched.size() && end > 0 && end <= matched.size()) {
				result.setResults(matched.subList(start, end));
			}

		} else {
			page = matched;
		}

		result.setResults(page);

		result.setTotalMatched(matched.size());

		return result;
	}

}
