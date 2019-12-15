package in.anandm.eshop.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.anandm.eshop.accountservice.service.UserService;

@RestController
@RefreshScope
public class AccountController {

	@Autowired
	private UserService userService;
	
	@Value("${status}")
	private String status;
	
	@GetMapping("/")
	public String home() {
		return "Account Service: " + status;
	}
}
