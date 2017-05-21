/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.persist.impl;

import javax.transaction.Transactional;
import su.lambda.poster.model.User;
import su.lambda.poster.persist.UserDAO;

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
