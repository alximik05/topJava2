package ru.javawebinar.topjava.model;

import java.util.Date;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMeal extends BaseEntity {
    private Date createDate;
    private String meal;
    private int calories;

    public UserMeal() {
    }

    public UserMeal(Date createDate, String meal, int calories) {

        this.createDate = createDate;
        this.meal = meal;
        this.calories = calories;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getCreateDate() {

        return createDate;
    }

    public String getMeal() {
        return meal;
    }

    public int getCalories() {
        return calories;
    }
}
