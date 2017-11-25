package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.BookOrder;
import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Cart;
import org.springframework.stereotype.Repository;

/**
 * Created by Ákos on 2017.10.31..
 */
@Repository
public interface BookOrderRepository extends CrudRepository<BookOrder, Integer> {
    //Order findOneByCart(Cart cart);
}
