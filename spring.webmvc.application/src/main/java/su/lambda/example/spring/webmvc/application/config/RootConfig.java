/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.config;

import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import su.lambda.example.spring.webmvc.application.persist.DatabaseFacade;
import su.lambda.example.spring.webmvc.application.persist.PostDAO;
import su.lambda.example.spring.webmvc.application.persist.UserDAO;
import su.lambda.example.spring.webmvc.application.persist.impl.PostDAOImpl;
import su.lambda.example.spring.webmvc.application.persist.impl.UserDAOImpl;

/**
 *
 * @author stepan
 */
@Configuration
@EnableTransactionManagement
public class RootConfig {

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
    public UserDAOImpl userDAO() {
        return new UserDAOImpl();
    }

    @Bean
    public PostDAOImpl postDAO() {
        return new PostDAOImpl();
    }

    @Bean
    DatabaseFacade databaseFacade(UserDAO userDAO, PostDAO postDAO) {
        DatabaseFacade facade = new DatabaseFacade();
        facade.setPostDAO(postDAO);
        facade.setUserDAO(userDAO);
        return facade;
    }

}
