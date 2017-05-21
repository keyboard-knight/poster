/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.persist;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import su.lambda.example.spring.webmvc.application.model.Post;
import su.lambda.example.spring.webmvc.application.model.User;

/**
 *
 * @author stepan
 */
public class DatabaseFacade {

    protected PostDAO postDAO;
    protected UserDAO userDAO;

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
    public void cleanDatabase() {
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
        User author = new User("vasya.pupkin", "Vasya", "Pupkin");
        author = userDAO.makePersistent(author);

        for (int i = 0; i < 20; ++i) {
            Post post = new Post();
            post.setAuthor(author);
            post.setContent("Auto-generated post #" + i);
            postDAO.makePersistent(post);
        }
    }
}
