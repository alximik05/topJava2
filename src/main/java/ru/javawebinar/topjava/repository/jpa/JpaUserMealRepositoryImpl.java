package ru.javawebinar.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 20.03.2015.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepositoryImpl implements UserMealRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {
        if (userMeal.isNew()) {
            User ref = entityManager.getReference(User.class, userId);
            userMeal.setUser(ref);
            entityManager.persist(userMeal);

        }
        else {
//entityManager.createNamedQuery("update from meal where").setParameter("userMeal", userMeal).executeUpdate() != 0;
//            entityManager.createNamedQuery(UserMeal.UPDATE).setParameter("calories",userMeal.getCalories()).setParameter("dateTime", userMeal.getDateTime()).setParameter("description",userMeal.getDescription()).setParameter("id",userMeal.getId()).setParameter()
                    entityManager.createQuery("update UserMeal um set um.description=:description, um.dateTime=:dateTime, um.calories=:calories where um.id=:id and um.user=:user",UserMeal.class)
                    .setParameter("description", userMeal.getDescription())
                    .setParameter("dateTime", userMeal.getDateTime())
                    .setParameter("calories", userMeal.getCalories())
                    .setParameter("id", userMeal.getId())
                    .setParameter("user", entityManager.getReference(User.class, userId))
                    .executeUpdate();
        }
        return userMeal;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return entityManager.createQuery("delete from UserMeal meal where meal.id=:id AND meal.user=:user",UserMeal.class)
                .setParameter("id",id)
                .setParameter("user",entityManager.getReference(User.class,userId))
                .executeUpdate() != 0;

    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> m = entityManager.createQuery("select  meal from UserMeal meal where meal.id=:id and meal.user=:user", UserMeal.class)
                .setParameter("id", id)
                .setParameter("user", entityManager.getReference(User.class, userId)).getResultList();
        return org.springframework.util.CollectionUtils.isEmpty(m) ? null : DataAccessUtils.requiredSingleResult(m);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return entityManager.createQuery("select meal from UserMeal meal where meal.user=:user order by meal.dateTime", UserMeal.class)
                .setParameter("user", entityManager.getReference(User.class, userId))
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteAll(int userId) {
        entityManager.createQuery("delete from UserMeal meal where meal.user=:user", UserMeal.class)
                .setParameter("user", entityManager.getReference(User.class, userId))
                .getResultList();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return entityManager.createQuery("select meal from UserMeal meal where meal.user=:user AND meal.dateTime >=: startDate AND meal.dateTime <: endDate order by meal.dateTime", UserMeal.class)
                .setParameter("user", entityManager.getReference(User.class, userId))
                .setParameter("startDate", startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
