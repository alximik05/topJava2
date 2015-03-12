package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    @Autowired
    private UserMealServiceImpl service;

    public List<UserMeal> getAllMeals() {
        int userId = LoggedUser.id();
        return service.getAllMeals(userId);
    }

    public UserMeal get(int mealId) {
        int userId = LoggedUser.id();
        return service.get(userId, mealId);
    }

    public void delete(int mealId) {
        int userId = LoggedUser.id();
        service.delete(userId, mealId);
    }

    public void add(Date createDate, String meal, int calories) {
        int userId = LoggedUser.id();
        UserMeal userMeal = new UserMeal(new Date(), meal, calories);
        service.add(userId,userMeal);
    }

    public void update(int mealId,Date createDate, String meal, int calories) {
        int userId = LoggedUser.id();
        service.update(userId,service.get(userId,mealId));
    }

    public void clearAll() {
        int userId = LoggedUser.id();
        service.clearAll(userId);
    }


    public List<UserMeal> filteredGet(Date startDate, Date endDate) {
        int userId = LoggedUser.id();
        return service.filteredGet(userId, startDate, endDate);
    }

}
