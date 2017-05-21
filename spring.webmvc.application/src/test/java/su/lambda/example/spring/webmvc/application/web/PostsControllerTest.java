/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.web;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.hasItems;
import org.junit.Test;

import su.lambda.example.spring.webmvc.application.model.Post;
import su.lambda.example.spring.webmvc.application.model.User;
import su.lambda.example.spring.webmvc.application.persist.PostDAO;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.;

/**
 *
 * @author stepan
 */
public class PostsControllerTest {

    private List<Post> generatePosts(long count) {
        User author = new User("vasya.pupkin", "Vasya", "Pupkin");
        List<Post> result = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            result.add(new Post(author, "Test-post #" + i));
        }
        return result;
    }

    /**
     * Test of posts method, of class PostsController.
     */
    @Test
    public void testPosts() throws Exception {
        // mock posts DAO
        final long postCount = 2;
        List<Post> recentPosts = generatePosts(postCount);
        PostDAO postDAO = mock(PostDAO.class);
        when(postDAO.getRecentPosts(postCount)).thenReturn(recentPosts);

        // create controller
        PostsController controller = new PostsController();
        controller.setPostDAO(postDAO);
        controller.setPostCount(postCount);

        // mock spring.webmvc framework
        MockMvc mockMvc = standaloneSetup(controller).setSingleView(new InternalResourceView("/posts")).build();

        // interact with PostController and verify results
        mockMvc.perform(get("/posts"))
                .andExpect(view().name("posts"))
                .andExpect(model().attributeExists("postList"))
                .andExpect(model().attribute("postList", hasItems(recentPosts.toArray())));
    }

}
