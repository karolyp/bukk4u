package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ákos on 2017.10.31..
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
    Iterable<Book> findByTitleContaining(String title);
}
