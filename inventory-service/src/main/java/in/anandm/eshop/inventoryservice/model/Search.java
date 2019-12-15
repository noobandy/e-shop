package in.anandm.eshop.inventoryservice.model;

public class Search {

	private String text;
	private Category category;
	
	private Integer page;
	private Integer pageSize;
	
	private boolean includeOutOfStock;
	
	public Search() {
		super();
		
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public boolean isIncludeOutOfStock() {
		return includeOutOfStock;
	}

	public void setIncludeOutOfStock(boolean includeOutOfStock) {
		this.includeOutOfStock = includeOutOfStock;
	}
	
	
	
	
}
