package hu.rendszerfejlesztes.bukk4u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class Bukk4uApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Bukk4uApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(Bukk4uApplication.class, args);
	}

}
