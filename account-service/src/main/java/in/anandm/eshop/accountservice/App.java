package in.anandm.eshop.accountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import in.anandm.eshop.accountservice.config.AppConfig;

@SpringBootApplication
@Import(value= {AppConfig.class})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
