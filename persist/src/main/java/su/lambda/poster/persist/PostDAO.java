/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.persist;

import java.util.List;
import su.lambda.poster.model.Post;
import su.lambda.poster.model.User;

/**
 *
 * @author stepan
 */
public interface PostDAO extends GenericDAO<Post, Long> {

    List<Post> getRecentPosts();

    List<Post> getRecentPosts(long count);

    List<Post> getRecentPosts(User author, long count);
}
