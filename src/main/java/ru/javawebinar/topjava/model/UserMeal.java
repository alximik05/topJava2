package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.util.TimeUtil;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * GKislin
 * 06.03.2015.
 */
@Entity
@Table(name = "meals")
public class UserMeal extends BaseEntity {
    public static final String UPDATE = "UserMeal.update";

    @Column(name = "datetime")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    protected LocalDateTime dateTime;

    @Column(name = "description")
    protected String description;

    @Column(name = "calories")
    protected int calories;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public UserMeal() {
    }

    public UserMeal(UserMeal meal) {
        this(meal.id, meal.dateTime, meal.description, meal.calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String meal) {
        this.description = meal;
    }

    public int getCalories() {
        return calories;
    }

    public User getUser() {
        return user;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Meal(" + id + ", " + TimeUtil.toString(dateTime) + ", '" + description + "', calories:" + calories + ')';
    }

    public void setUser(User user) {
        this.user = user;
    }

}
