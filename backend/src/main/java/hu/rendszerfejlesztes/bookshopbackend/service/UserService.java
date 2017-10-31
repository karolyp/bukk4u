package hu.rendszerfejlesztes.bookshopbackend.service;

import com.google.common.collect.Lists;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import hu.rendszerfejlesztes.bookshopbackend.dao.repositories.UserRepository;
import hu.rendszerfejlesztes.bookshopbackend.utils.EncryptionUtils;
import org.hibernate.cache.internal.CollectionCacheInvalidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean saveUser(User user) {
        if(userRepository.findOneByEmail(user.getEmail()) != null)
            return false;

        if(!user.isPasswordEncrtyped()){
            user.setPassword(EncryptionUtils.getMD5HashString(user.getPassword()));
        }

        userRepository.save(user);
        return true;
    }

    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public List<User> getUsersWithoutPassword() {
        return getUsers().stream().map(u -> {
            u.setPassword("");
            return u;
        }).collect(Collectors.toList());
    }

    public User getUser(String email, String password) {
        //userRepository.findOne
        String cryptedpass = EncryptionUtils.getMD5HashString(password);
        return userRepository.findOneByEmailAndPassword(email, cryptedpass);
    }
}
