/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su.lambda.poster.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author stepan
 */
@Entity
@Table(name = "\"User\"")
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String login;
    private String firstName;
    private String lastName;
    private String encryptedPassword;

    @Temporal(TemporalType.TIMESTAMP)
    private Date signUpTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastSignInTime;

    public User() {

    }

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the signUpTime
     */
    public Date getSignUpTime() {
        return signUpTime;
    }

    /**
     * @param signUpTime the signUpTime to set
     */
    public void setSignUpTime(Date signUpTime) {
        this.signUpTime = signUpTime;
    }

    /**
     * @return the lastSignInTime
     */
    public Date getLastSignInTime() {
        return lastSignInTime;
    }

    /**
     * @param lastSignInTime the lastSignInTime to set
     */
    public void setLastSignInTime(Date lastSignInTime) {
        this.lastSignInTime = lastSignInTime;
    }

    /**
     * @return the encryptedPassword
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword the encryptedPassword to set
     */
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("User(");
        sb.append(login).append(", ");
        sb.append(firstName).append(", ");
        sb.append(lastName).append(")");
        return sb.toString();
    }
}
