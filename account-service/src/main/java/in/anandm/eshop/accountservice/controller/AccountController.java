package in.anandm.eshop.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.anandm.eshop.accountservice.service.UserService;

@RestController
public class AccountController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String home() {
		return "Account Service";
	}
}
