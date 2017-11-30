package hu.rendszerfejlesztes.bookshopbackend.service;

import com.google.common.collect.Lists;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.*;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.CartRepository;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.CustomerRepository;
import hu.rendszerfejlesztes.bookshopbackend.exception.BackendException;
import hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CartRepository cartRepository;

    public boolean saveUser(Customer user) {
        if (customerRepository.findOneByEmail(user.getEmail()) != null)
            return false;

        if (!user.isPasswordEncrtyped()) {
            user.setPassword(EncryptionUtils.getMD5HashString(user.getPassword()));
            user.setPasswordEncrtyped(true);
        }
        user.randomizeTokenOnce();

        user = customerRepository.save(user);
        Cart userCart = new Cart();
        userCart.setCustomer(user);

        user.setCart(userCart);
        Cart tmp = cartRepository.save(userCart);

       /* Order newOrder = new Order();
        newOrder.setCart(tmp);
        orderRepository.save(newOrder);*/
        return true;
    }

    public List<Customer> getUsers() {
        return Lists.newArrayList(customerRepository.findAll());
    }

    public List<Customer> getUsersWithoutPassword() {
        return getUsers().stream().map(u -> {
            u.setPassword("");
            return u;
        }).collect(Collectors.toList());
    }
    public Customer login(Customer u) throws BackendException {
        String encryptedPass = EncryptionUtils.getMD5HashString(u.getPassword());
        Customer user = customerRepository.findOneByEmailAndPassword(u.getEmail(), encryptedPass);
        if (user != null) {
            return user;
        } else {
            throw new BackendException("Felhasználó nem található");
        }
    }

    public List<Book> getUserCart(Integer id, String token) { // TODO: make it return how many of each book is in the cart
        Customer u = customerRepository.findOne(id);
        if(u == null)
            return null;

        if(!u.getToken().equals(token))
            return null;

        Set<CartElement> products = cartRepository.findOneByCustomer(u).getProducts();

        List<Book> cart = Lists.newArrayList();
        products.forEach(tmp -> {
            cart.add(tmp.getBook());
        });
        return cart;
    }

    public Customer findOneByToken(String token){
        return customerRepository.findOneByToken(token);
    }

}

