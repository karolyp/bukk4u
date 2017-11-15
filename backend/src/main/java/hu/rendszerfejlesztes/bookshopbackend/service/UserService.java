package hu.rendszerfejlesztes.bookshopbackend.service;

import com.google.common.collect.Lists;
import com.sun.media.jfxmedia.logging.Logger;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.*;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.CartRepository;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.UserRepository;
import hu.rendszerfejlesztes.bookshopbackend.exception.BackendException;
import hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    public boolean saveUser(String email, String jelszo) {
        if (userRepository.findOneByEmail(email) != null)
            return false;

        User user = new User();
        user.setEmail(email);
        String encryptedPass = EncryptionUtils.getMD5HashString(jelszo);
        user.setPassword(encryptedPass);
        user.setPasswordEncrtyped(true);
        user.setUserRole(UserRole.USER);

        userRepository.save(user);
        return true;
    }
    /*public boolean saveUser(User user) { // 2017.11.15 előtti verzsön
        if (userRepository.findOneByEmail(user.getEmail()) != null)
            return false;

        if (!user.isPasswordEncrtyped()) {
            user.setPassword(EncryptionUtils.getMD5HashString(user.getPassword()));
        }

        userRepository.save(user);
        return true;
    }*/

    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public List<User> getUsersWithoutPassword() {
        return getUsers().stream().map(u -> {
            u.setPassword("");
            return u;
        }).collect(Collectors.toList());
    }

    public User login(User u) throws BackendException {
        String encryptedPass = EncryptionUtils.getMD5HashString(u.getPassword());
        User user = userRepository.findOneByEmailAndPassword(u.getEmail(), encryptedPass);
        if (user != null) {
            return user;
        } else {
            throw new BackendException("Could not find user!");
        }
    }

    /*public User login(User u) throws BackendException { // // 2017.11.15 előtti verzsön
        String encryptedPass = EncryptionUtils.getMD5HashString(u.getPassword());
        User user = userRepository.findOneByEmailAndPassword(u.getEmail(), encryptedPass);
        if (user != null) {
            return user;
        } else {
            throw new BackendException("Could not find user!");
        }
    }*/

    public List<Book> getUserCart(String email) {
        User u = userRepository.findOneByEmail(email);
        Set<CartElement> products = cartRepository.findOneByCustomer(u).getProducts();

        List<Book> cart = Lists.newArrayList();
        products.forEach(tmp -> {
            cart.add(tmp.getBook());
        });
        return cart;
    }

    public User findOneByToken(String token){
        return userRepository.findOneByToken(token);
    }

}

