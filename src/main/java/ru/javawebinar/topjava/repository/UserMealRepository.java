package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {

    List<UserMeal> getAllMeals(int userId);

    List<UserMeal> filteredGet(int userId, Date startDate, Date endDate);

    boolean delete(int userId, int mealId);

    UserMeal get(int userId, int mealId);

    UserMeal add(int userId ,UserMeal userMeal);

    boolean clearAll(int userId);
}
