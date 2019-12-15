package in.anandm.eshop.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Import;

import in.anandm.eshop.apigateway.config.AppConfig;

@SpringBootApplication
@Import(value= {AppConfig.class})
@EnableDiscoveryClient
@EnableZuulProxy
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
