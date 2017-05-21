/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.persist.impl;

import java.util.List;
import javax.transaction.Transactional;
import su.lambda.poster.model.Post;
import su.lambda.poster.model.User;
import su.lambda.poster.persist.PostDAO;

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
