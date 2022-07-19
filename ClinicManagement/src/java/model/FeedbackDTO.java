/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author uyenc
 */
public class FeedbackDTO {

    private int feedbackId;
    private String customer;
    private String username;
    private String service;
    private String examination;
    private String feedbackContent;
    private Date feedbackTime;
    private int examinationId;
    private int serviceId;
    List<String> feedbackReply = new ArrayList<>();

    public FeedbackDTO(int feedbackId, String customer, String service, String examination, String feedbackContent, Date feedbackTime, int examinationId, int serviceId) {
        this.feedbackId = feedbackId;
        this.customer = customer;
        this.service = service;
        this.examination = examination;
        this.feedbackContent = feedbackContent;
        this.feedbackTime = feedbackTime;
        this.examinationId = examinationId;
        this.serviceId = serviceId;
    }

    public FeedbackDTO() {
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getExamination() {
        return examination;
    }

    public void setExamination(String examination) {
        this.examination = examination;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(int examinationId) {
        this.examinationId = examinationId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public List<String> getFeedbackReply() {
        return feedbackReply;
    }

    public void setFeedbackReply(List<String> feedbackReply) {
        this.feedbackReply = feedbackReply;
    }

}
