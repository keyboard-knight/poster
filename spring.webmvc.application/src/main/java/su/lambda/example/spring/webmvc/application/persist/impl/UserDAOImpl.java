/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.example.spring.webmvc.application.persist.impl;

import org.springframework.transaction.annotation.Transactional;
import su.lambda.example.spring.webmvc.application.model.User;
import su.lambda.example.spring.webmvc.application.persist.UserDAO;

/**
 *
 * @author stepan
 */
@Transactional
public class UserDAOImpl extends GenericDAOImpl<User, Long> implements UserDAO {

    public UserDAOImpl() {
        super(User.class);
    }
}
