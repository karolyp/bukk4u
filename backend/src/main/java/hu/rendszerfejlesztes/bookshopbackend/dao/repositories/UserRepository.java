package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<Customer, Integer> {
    Customer findOne(Integer id);

    Customer findOneByEmailAndPassword(String email, String password);

    Customer findOneByEmail(String email);

    Customer findOneByToken(String token);
}

