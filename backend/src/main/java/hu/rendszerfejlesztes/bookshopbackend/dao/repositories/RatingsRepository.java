package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Ratings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ákos on 2017.10.31..
 */
public interface RatingsRepository extends CrudRepository<Ratings, Integer> {

}