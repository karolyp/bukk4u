package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.User;

/**
 * Created by Ákos on 2017.10.31..
 */
public interface CartRepository extends CrudRepository<Cart, Integer> {
    Cart findOneByCustomer(User customer);
}
