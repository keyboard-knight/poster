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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author stepan
 */
@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModificationTime;

    @ManyToOne
    private User author;

    public Post() {
    }

    public Post(User author, String content) {
        this.content = content;
        this.creationTime = new Date();
        this.lastModificationTime = this.creationTime;
        this.author = author;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the creationTime
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     * @param creationTime the creationTime to set
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * @return the lastModificationTime
     */
    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    /**
     * @param lastModificationTime the lastModificationTime to set
     */
    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    /**
     * @return the author
     */
    public User getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        int contentPreviewLength = content.length() > 19 ? 20 : content.length();
        StringBuilder sb = new StringBuilder("Post(");
        sb.append("author=").append(author.getLogin()).append(", ");
        sb.append("content='").append(content.substring(0, contentPreviewLength)).append("')");
        return sb.toString();
    }
}
