package in.anandm.eshop.cartservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@GetMapping
	public String home() {
		return "Cart Service";
	}
}
