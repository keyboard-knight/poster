/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.headless.poster.spring.application.config;

import javax.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import su.lambda.poster.headless.poster.spring.application.Application;
import su.lambda.poster.persist.PostDAO;
import su.lambda.poster.persist.UserDAO;
import su.lambda.poster.persist.impl.PostDAOImpl;
import su.lambda.poster.persist.impl.UserDAOImpl;

/**
 *
 * @author stepan
 */
@Configuration
@EnableTransactionManagement
public class ApplicationConfig {

    @Bean
    public LocalEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("PosterPU");
        return factoryBean;
    }

    @Bean
    PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public PostDAO postDAO() {
        return new PostDAOImpl();
    }

    @Bean
    public Application application() {
        Application app = new Application();
        app.setPostDAO(postDAO());
        app.setUserDAO(userDAO());
        return app;
    }
}
