package hu.rendszerfejlesztes.bukk4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Bukk4uApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Bukk4uApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*")
						.allowedHeaders("Content-Type", "X-Requested-With", "Authorization")
						.allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS").allowCredentials(true);
			}
		};
	}
}
