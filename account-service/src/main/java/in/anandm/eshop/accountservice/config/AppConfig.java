package in.anandm.eshop.accountservice.config;

import org.eshop.core.security.NoOpPasswordEncoder;
import org.eshop.core.security.PasswordEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import in.anandm.eshop.accountservice.infrastructure.persistence.InMemoryUserRepository;
import in.anandm.eshop.accountservice.model.UserRepository;
import in.anandm.eshop.accountservice.service.UserService;

@Configuration
public class AppConfig {

	@Bean
	public UserRepository userRepository() {
		return new InMemoryUserRepository();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new NoOpPasswordEncoder();
	}
	
	@Bean
	@DependsOn(value= {"userRepository", "passwordEncoder"})
	public UserService userService(UserRepository userRepository, PasswordEncoder passwordEncoder)  {
		return new UserService(userRepository, passwordEncoder);
	}
}
