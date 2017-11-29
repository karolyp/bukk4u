package hu.rendszerfejlesztes.bookshopbackend.service;

import com.google.common.collect.Lists;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Category;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book>getBooksByNameContaining(String nev) {
        if(nev == "")
            return Lists.newArrayList(bookRepository.findAll());
        else return Lists.newArrayList(bookRepository.findByTitleContaining(nev));
    }

    public List<Book>getBooksByGenre(String genre) {
        return Lists.newArrayList(bookRepository.findByCategory(Category.valueOf(genre)));
    }
}
