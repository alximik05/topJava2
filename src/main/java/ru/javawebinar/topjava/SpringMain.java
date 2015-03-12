package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.mock.MockUserMealRepositoryImpl;
import ru.javawebinar.topjava.repository.mock.MockUserRepositoryImpl;
import ru.javawebinar.topjava.web.meal.UserMealRestController;
import ru.javawebinar.topjava.web.user.AdminUserRestController;

import java.util.Arrays;
import java.util.List;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");

//            UserMealRestController userMealRestController = appCtx.getBean(UserMealRestController.class);
//            List<UserMeal> allMeals = userMealRestController.getAllMeals();
//            System.out.println(allMeals.size());
//            userMealRestController.clearAll();
//
//
//            MockUserMealRepositoryImpl mock = appCtx.getBean(MockUserMealRepositoryImpl.class);
//            mock.delete(33,22);




//            AdminUserRestController adminController = appCtx.getBean(AdminUserRestController.class);
//            adminController.delete(7);
//            adminController.getByMail("dummy");
        }
    }
}
