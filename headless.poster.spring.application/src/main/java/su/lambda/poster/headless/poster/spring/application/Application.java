/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.headless.poster.spring.application;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import su.lambda.poster.headless.poster.spring.application.config.ApplicationConfig;
import su.lambda.poster.model.Post;
import su.lambda.poster.model.User;
import su.lambda.poster.persist.PostDAO;
import su.lambda.poster.persist.UserDAO;

/**
 *
 * @author stepan
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        Application app = context.getBean("application", Application.class);
        app.clearDatabase();
        app.generateDatabaseContent();
        System.out.println("Success!");
        System.exit(0);
    }

    private UserDAO userDAO;
    private PostDAO postDAO;

    public PostDAO getPostDAO() {
        return postDAO;
    }

    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void clearDatabase() {
        List<User> users = userDAO.findAll();
        for (User user : users) {
            userDAO.makeTransient(user);
        }

        List<Post> posts = postDAO.findAll();
        for (Post post : posts) {
            postDAO.makeTransient(post);
        }
    }

    @Transactional
    public void generateDatabaseContent() {
        User author = userDAO.makePersistent(new User("vasya.pupkin", "Vasya", "Pupkin"));
        for (int i = 0; i < 20; ++i) {
            Post post = new Post();
            post.setAuthor(author);
            post.setContent("Headless application: auto-generated post #" + i);
            postDAO.makePersistent(post);
        }
    }
}
