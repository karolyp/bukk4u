package hu.rendszerfejlesztes.bookshopbackend.controller;

import hu.rendszerfejlesztes.bookshopbackend.controller.beans.Response;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.service.UserService;
import hu.rendszerfejlesztes.bookshopbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api")
public class BookController {

    @Autowired
    private UserService userService; // lehet nem fontos ide de még benthagytam
    @Autowired
    private BookService bookService;

    /**
     * Visszatér a könyv-listával amiknek a nevében benne van a paraméter.
     * @return List<Book>
     */
    @RequestMapping(path = "/findbooks", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Book>> getBooksByNameContaining(HttpServletRequest request){
        String nev = request.getParameter("nev");
        List<Book> booksWithNameContaining = bookService.getBooksByNameContaining(nev);
        if(!booksWithNameContaining.isEmpty()) {
            return ResponseEntity.ok(booksWithNameContaining);
        } else {
            return ResponseEntity.badRequest().body(null); // TODO: változtatni valamit rajta?
        }
    }
}
