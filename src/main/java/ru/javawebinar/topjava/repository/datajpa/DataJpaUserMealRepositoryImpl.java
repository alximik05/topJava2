package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 27.03.2015.
 */
@Repository
public class DataJpaUserMealRepositoryImpl implements UserMealRepository{
    @Autowired
    ProxyUserMealRepository proxy;

    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        return proxy.save(userMeal);
    }

    @Override
    public boolean delete(int id, int userId) {
        return proxy.delete(id) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return proxy.findOne(id);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return proxy.findAll(userId);
    }

    @Override
    public void deleteAll(int userId) {
        proxy.deleteAll(userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return proxy.findByStartDateBetween(startDate,endDate,userId);
    }
}
