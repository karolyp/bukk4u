package hu.rendszerfejlesztes.bookshopbackend.dao.repositories;

import hu.rendszerfejlesztes.bookshopbackend.dao.entities.Rating;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ákos on 2017.10.31..
 */
public interface RatingsRepository extends CrudRepository<Rating, Integer> {

}