/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author uyenc
 */
public class FeedbackReply {

    private int id;
    private int feedback;
    private String content;
    private Date date;

    /**
     * Create an instance of <code>FeedbackReply</code> object with value of
     * attributes of <code>FeedbackReply</code>
     *
     * @param feedback the value of feedback attribute. It's a
     * <code>java.lang.String</code> object
     * @param content the value of content attribute. It's a
     * <code>java.lang.String</code> object
     * @param date the value of date attribute. It's a
     * <code>java.sql.Date</code> object
     */
    public FeedbackReply(int feedback, String content, Date date) {
        this.feedback = feedback;
        this.content = content;
        this.date = date;
    }

    /**
     * Create an instance of <code>FeedbackReply</code> object
     */
    public FeedbackReply() {
    }

    /**
     * Return the value of Id attribute of the <code>FeedbackReply</code>
     * object.
     */
    public int getId() {
        return id;
    }

    /**
     * Set userId value of the <code>FeedbackReply</code> object.
     *
     * @param id is a <code>java.lang.int</code> this value is the id of the
     * User.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the value of Feedback attribute of the <code>FeedbackReply</code>
     * object.
     */
    public int getFeedback() {
        return feedback;
    }

    /**
     * Set Feedback value of the <code>FeedbackReply</code> object.
     *
     * @param feedback is a <code>java.lang.String</code> this value is the id
     * of the User.
     */
    public void setFeedback(int feedback) {
        this.feedback = feedback;
    }

    /**
     * Return the value of Content attribute of the <code>FeedbackReply</code>
     * object.
     */
    public String getContent() {
        return content;
    }

    /**
     * Set Content value of the <code>FeedbackReply</code> object.
     *
     * @param content is a <code>java.lang.String</code> this value is the id of
     * the User.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Return the value of Date attribute of the <code>FeedbackReply</code>
     * object.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set Date value of the <code>FeedbackReply</code> object.
     *
     * @param date is a <code>java.lang.String</code> this value is the id of
     * the User.
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
