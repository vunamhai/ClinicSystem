/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author uyenc
 */
public class Feedback {

    private int feedbackId;
    private int customerId;
    private int serviceId;
    private int examinationId;
    private String feedbackContent;
    private Date feedbackTime;

    public Feedback(int feedbackId, int customerId, int serviceId, int examinationId, String feedbackContent, Date feedbackTime) {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.serviceId = serviceId;
        this.examinationId = examinationId;
        this.feedbackContent = feedbackContent;
        this.feedbackTime = feedbackTime;
    }

    public Feedback() {
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

}
