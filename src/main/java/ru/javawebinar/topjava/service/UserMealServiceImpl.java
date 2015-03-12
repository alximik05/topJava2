package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {
    @Autowired
    private UserMealRepository repository;

    @Override
    public List<UserMeal> getAllMeals(int userId) {
        return repository.getAllMeals(userId);
    }

    @Override
    public List<UserMeal> filteredGet(int userId, Date startDate, Date endDate) {
        return repository.filteredGet(userId, startDate, endDate);
    }

    @Override
    public void delete(int userId, int mealId) throws NotFoundException {
        ExceptionUtil.check(repository.delete(userId, mealId),mealId);
    }

    @Override
    public UserMeal get(int userId, int mealId) throws NotFoundException {
        return ExceptionUtil.check(repository.get(userId, mealId),mealId);
    }

    @Override
    public UserMeal add(int userId, UserMeal userMeal) {
        return repository.add(userId, userMeal);
    }

    @Override
    public boolean clearAll(int userId) {
        return repository.clearAll(userId);
    }

    @Override
    public void update(int userId, UserMeal userMeal) throws NotFoundException {
        ExceptionUtil.check(repository.add(userId, userMeal),userMeal.getId());
    }
}
