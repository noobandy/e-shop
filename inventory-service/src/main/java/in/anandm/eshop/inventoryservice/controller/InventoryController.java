package in.anandm.eshop.inventoryservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {

	
	@GetMapping("/")
	public String home() {
		return "Inventory Controller";
	}
}
