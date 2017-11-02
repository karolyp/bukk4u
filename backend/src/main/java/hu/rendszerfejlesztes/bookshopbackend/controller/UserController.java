package hu.rendszerfejlesztes.bookshopbackend.controller;

import com.google.common.collect.Lists;
import hu.rendszerfejlesztes.bookshopbackend.controller.beans.Response;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Book;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user", method = RequestMethod.POST) // PUT
    @ResponseBody
    public ResponseEntity<Response> saveUser(@RequestBody User user){
        if(userService.saveUser(user))
            return ResponseEntity.ok(Response.successWithMessage("Sikeres regisztráció!"));
        else
            return ResponseEntity.ok(Response.failureWithMessage("Ez az e-mail cím már foglalt!")); // TODO: Karesz validate this :D
    }

    @RequestMapping(path = "/usersWithoutPassword", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsersWithoutPassword(){
        return userService.getUsersWithoutPassword();
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET) // POST
    @ResponseBody
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User u = userService.getUser(email, password);

        if (u != null) {
            return ResponseEntity.ok(u);
        } else {
            return ResponseEntity.badRequest().body(null); // TODO: szépíteni
        }
    }

    @RequestMapping(path = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getUserCart(HttpServletRequest request){
        int userID = Integer.parseInt(request.getParameter("userid"));
        return userService.getUserCart(userID);
    }
}
