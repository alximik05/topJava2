package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javawebinar.topjava.model.UserMeal;

/**
 * Created by alximik on 01/04/15.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {

}
