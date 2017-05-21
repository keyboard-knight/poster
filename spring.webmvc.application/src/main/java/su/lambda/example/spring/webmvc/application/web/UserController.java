/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import su.lambda.example.spring.webmvc.application.model.User;
import su.lambda.example.spring.webmvc.application.persist.UserDAO;

/**
 *
 * @author stepan
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String users(Model model) {
        List<User> users = userDAO.findAll();
        model.addAttribute(users);
        return "users";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String user(@PathVariable("id") Long id, Model model) {
        User user = userDAO.findById(id);
        model.addAttribute(user);
        return "user";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String register() {
        return "user_new";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String register(User user) {
        user = userDAO.makePersistent(user);
        return "redirect:/users/" + user.getId();
    }
}
