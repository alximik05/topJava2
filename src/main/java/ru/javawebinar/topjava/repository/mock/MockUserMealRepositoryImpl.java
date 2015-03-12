package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
@Repository
public class MockUserMealRepositoryImpl implements UserMealRepository {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepositoryImpl.class);


    @Override
    public List<UserMeal> getAllMeals(int userId) {
        LOG.info("get all");
        return Collections.emptyList();
    }

    @Override
    public List<UserMeal> filteredGet(int userId, Date startDate, Date endDate) {
        LOG.info("get filtered");
        return Collections.emptyList();
    }

    @Override
    public boolean delete(int userId, int mealId) {
        LOG.info("delete");
        return true;
    }

    @Override
    public UserMeal get(int userId, int mealId) {
        LOG.info("get userId " + userId + " mealId " + mealId);
        return null;
    }

    @Override
    public UserMeal add(int userId, UserMeal userMeal) {
        LOG.info("add " + userId + " mealId " + userMeal.getId());
        return null;
    }

    @Override
    public boolean clearAll(int userId) {
        LOG.info("clear all");
        return true;
    }
}
