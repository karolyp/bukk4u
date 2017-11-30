package hu.rendszerfejlesztes.bookshopbackend.controller;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import hu.rendszerfejlesztes.bookshopbackend.service.CustomerService;
import hu.rendszerfejlesztes.bookshopbackend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/api")
public class BookController {

    @Autowired
    private CustomerService customerService; // lehet nem fontos ide de még benthagytam
    @Autowired
    private BookService bookService;

    /**
     * Visszatér a könyv-listával amiknek a nevében benne van a paraméter.
     * HA a NÉV üres ("") akkor minden könyvet visszaad.
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

    /**
     * Visszatér a könyv-listával amik a kiválasztott kategóriába tartoznak.
     * @return List<Book>
     */
    @RequestMapping(path = "/getbooksbygenre", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Book>> getBooksByGenreAndPrice(HttpServletRequest request){
        String genre = request.getParameter("genre");
        int maxPrice = Integer.parseInt(request.getParameter("maxprice"));
        List<Book> books = bookService.getBooksByGenre(genre);
        if(!books.isEmpty()) {
            if(maxPrice > 0) {
                for (Iterator<Book> iter = books.listIterator(); iter.hasNext(); ) {
                    Book tmp = iter.next();
                    if(tmp.getPrice() > maxPrice) {
                        books.remove(iter);
                    }
                }
            }
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.badRequest().body(null); // TODO: változtatni valamit rajta?
        }
    }
}
