package hu.rendszerfejlesztes.bookshopbackend.controller;

import hu.rendszerfejlesztes.bookshopbackend.controller.beans.Response;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Customer;
import hu.rendszerfejlesztes.bookshopbackend.exception.BackendException;
import hu.rendszerfejlesztes.bookshopbackend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Response> saveUser(@RequestBody Customer user) { // ez így a tokent kliensoldalról fogja kapni!!
        if (customerService.saveUser(user)) {
            return ResponseEntity.ok(Response.successWithMessage("Sikeres regisztráció!"));
        } else {
            return ResponseEntity.ok(Response.failureWithMessage("Ez az e-mail cím már foglalt!"));
        }
    }

    @RequestMapping(path = "/usersWithoutPassword", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getUsersWithoutPassword() {
        return customerService.getUsersWithoutPassword();
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @ResponseBody
    public List<Customer> getUsers() {
        return customerService.getUsers();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Customer> getUser(@RequestBody Customer user) {
        Customer u = null;
        try {
            u = customerService.login(user);
            return ResponseEntity.ok(u);

        } catch (BackendException e) {
            return ResponseEntity.badRequest().body(null); // TODO: szépíteni
        }
    }

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getUserCart(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        String token = request.getParameter("token");
        return customerService.getUserCart(id, token);
    }

    @RequestMapping(path = "/user-token", method = RequestMethod.POST)
    public ResponseEntity<Customer> getUserForToken(HttpServletRequest request) {
        request.getParameterMap()
                .entrySet()
                .stream()
                .forEach(p -> {
                    System.out.println(p.getKey());
                    Arrays.asList(p.getValue())
                            .stream()
                            .forEach(f -> System.out.println("\t" + f));
                });
        System.out.println(request.getParameter("token"));
        return ResponseEntity.ok(customerService.findOneByToken(request.getParameter("token")));
    }

}
