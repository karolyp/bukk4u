package hu.rendszerfejlesztes.bookshopbackend;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
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

import static hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils.getMD5HashString;

@SpringBootApplication
@EnableJpaRepositories
public class BookshopBackendApplication extends SpringBootServletInitializer {

    private static final Logger LOGGER  = LoggerFactory.getLogger(BookshopBackendApplication.class);
    private static Class<BookshopBackendApplication> applicationClass = BookshopBackendApplication.class;

    public static void main(String[] args) {
        SpringApplication.run(BookshopBackendApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            userRepository.save(new User("Fekete Jozsi", "jozsi@teszt.hu", getMD5HashString("jozsipass"), "6666 Kamut"));
            userRepository.save(new User("Sós Julcsi", "julcsi@teszt.hu", getMD5HashString("julcsipass"), "6666 Kamut"));
            userRepository.save(new User("Kovács Mari", "jozsi@teszt.hu", getMD5HashString("maripass"), "6666 Kamut"));

            LOGGER.info("Users with findAll()");
            userRepository.findAll().forEach(u -> LOGGER.info(u.toString()));

        };
    }
}
