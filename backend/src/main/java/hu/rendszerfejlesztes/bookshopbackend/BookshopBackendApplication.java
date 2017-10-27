package hu.rendszerfejlesztes.bookshopbackend;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.UserRole;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.UserRepository;
import hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import static hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils.getMD5HashString;

@SpringBootApplication
@EnableJpaRepositories
public class BookshopBackendApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookshopBackendApplication.class);
    private static Class<BookshopBackendApplication> applicationClass = BookshopBackendApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(BookshopBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    @Bean
    protected CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("Admin", "admin@bukk4u", EncryptionUtils.getMD5HashString("admin"), "noaddress", UserRole.ADMIN));
        };
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
