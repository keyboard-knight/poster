/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.persist.impl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import su.lambda.example.spring.webmvc.application.model.Post;
import su.lambda.example.spring.webmvc.application.model.User;
import su.lambda.example.spring.webmvc.application.persist.PostDAO;

/**
 *
 * @author stepan
 */
@Transactional
public class PostDAOImpl extends GenericDAOImpl<Post, Long> implements PostDAO {

    public PostDAOImpl() {
        super(Post.class);
    }

    @Override
    public List<Post> getRecentPosts() {
        return findAll();
    }

    @Override
    public List<Post> getRecentPosts(long count) {
        return findAll();
    }

    @Override
    public List<Post> getRecentPosts(User author, long count) {
        return findAll();
    }
}
