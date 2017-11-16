package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findOne(Integer id);

    User findOneByEmailAndPassword(String email, String password);

    User findOneByEmail(String email);

    User findOneByToken(String token);
}

