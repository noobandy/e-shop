package in.anandm.eshop.inventoryservice.model;

import java.util.List;

public interface ProductRepository {

	void add(Product product);
	
	List<Product> findAll();
}
