package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
public interface UserMealService {
    List<UserMeal> getAllMeals(int userId);

    List<UserMeal> filteredGet(int userId, Date startDate, Date endDate);

    void delete(int userId ,int mealId) throws NotFoundException;

    UserMeal get(int userId ,int mealId) throws NotFoundException;

    UserMeal add(int userId ,UserMeal userMeal);

    boolean clearAll(int userId);

    public void update(int userId, UserMeal userMeal) throws NotFoundException;
}
