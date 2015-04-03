package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by alximik on 01/04/15.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM UserMeal um WHERE um.id=:id")
    int delete(@Param("id")int id);

    @Transactional
    @Override
    UserMeal save(UserMeal userMeal);


    @Modifying
    @Query("SELECT um FROM UserMeal um WHERE um.user.id=:userId ORDER BY um.dateTime DESC")
    List<UserMeal> findAll(@Param("userId")int userId);

    @Query("DELETE FROM UserMeal um where um.user.id=:userId")
    void deleteAll(@Param("userId") int userId);

    @Modifying
    @Query("SELECT um FROM UserMeal um WHERE um.user.id=:userId AND um.dateTime>=:after and um.dateTime<:before ORDER BY um.dateTime DESC ")
    List<UserMeal> findByStartDateBetween(@Param("after")LocalDateTime after, @Param("before")LocalDateTime before, @Param("userId")int userId);


}
