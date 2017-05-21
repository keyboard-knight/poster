package su.lambda.example.spring.webmvc.application.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import su.lambda.example.spring.webmvc.application.model.Post;
import su.lambda.example.spring.webmvc.application.persist.PostDAO;

/**
 *
 * @author stepan
 */
@Controller
@RequestMapping("/posts")
public class PostsController {

    public static final long DEFAULT_POST_COUNT = 20;

    private long postCount = DEFAULT_POST_COUNT;

    @Autowired
    private PostDAO postDAO;

    public PostDAO getPostDAO() {
        return postDAO;
    }

    public void setPostDAO(PostDAO postDAO) {
        this.postDAO = postDAO;
    }

    public long getPostCount() {
        return postCount;
    }

    public void setPostCount(long postCount) {
        this.postCount = postCount;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String posts(
            @RequestParam(value = "max", required = false, defaultValue = "0") Integer max,
            @RequestParam(value = "count", required = false, defaultValue = "0") Integer count,
            Model model) {
        List<Post> recentPosts = postDAO.getRecentPosts(postCount);
        model.addAttribute(recentPosts);
        model.addAttribute("max", max);
        model.addAttribute("count", count);
        return "posts";
    }

    @RequestMapping(value = "/{index}", method = RequestMethod.GET)
    public String posts(
            @PathVariable("index") Integer index,
            Model model) {
        List<Post> recentPosts = postDAO.getRecentPosts(postCount);
        model.addAttribute("post", recentPosts.get(index));
        model.addAttribute("index", index);
        return "post";
    }

}
