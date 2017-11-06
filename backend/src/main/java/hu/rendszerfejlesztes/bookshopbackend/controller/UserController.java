package hu.rendszerfejlesztes.bookshopbackend.controller;

import hu.rendszerfejlesztes.bookshopbackend.controller.beans.Response;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.exception.BackendException;
import hu.rendszerfejlesztes.bookshopbackend.service.UserService;
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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<Response> saveUser(@RequestBody User user) {
        if (userService.saveUser(user)) {
            return ResponseEntity.ok(Response.successWithMessage("Sikeres regisztráció!"));
        } else {
            return ResponseEntity.ok(Response.failureWithMessage("Ez az e-mail cím már foglalt!")); // TODO: Karesz validate this :D
        }
    }

    @RequestMapping(path = "/usersWithoutPassword", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsersWithoutPassword() {
        return userService.getUsersWithoutPassword();
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> getUser(@RequestBody User user) {
        User u = null;
        try {
            u = userService.login(user);
            return ResponseEntity.ok(u);

        } catch (BackendException e) {
            return ResponseEntity.badRequest().body(null); // TODO: szépíteni
        }
    }

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getUserCart(HttpServletRequest request) {
        String email = request.getParameter("email");
        return userService.getUserCart(email);
    }

    @RequestMapping(path = "/user-token", method = RequestMethod.POST)
    public ResponseEntity<User> getUserForToken(HttpServletRequest request) {
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
        return ResponseEntity.ok(userService.findOneByToken(request.getParameter("token")));
    }

}
