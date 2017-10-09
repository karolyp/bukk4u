package hu.rendszerfejlesztes.bookshopbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookshopBackendApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BookshopBackendApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<BookshopBackendApplication> applicationClass = BookshopBackendApplication.class;

}
