/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author uyenc
 */
public class PostEntity {

    private int id;
    private int userId;
    private String title;
    private String summary;
    private String content;
    private Date createDate;
    private String postImage;
    private Time createTime;

    public PostEntity(int id, int userId, String title, String summary, String content, Date createDate, String postImage) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.createDate = createDate;
        this.postImage = postImage;
    }

    public PostEntity(int id, String title, String summary, String content, String postImage) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.postImage = postImage;
    }

    public PostEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }

    public Time getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Time createTime) {
        this.createTime = createTime;
    }

}
