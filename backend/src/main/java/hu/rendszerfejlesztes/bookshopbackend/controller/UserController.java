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

import java.util.List;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    // TODO: detect if user already exists
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Response> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.ok(Response.successWithMessage("User successfully registered."));
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

}
