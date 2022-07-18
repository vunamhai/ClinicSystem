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
public class CustomerReservation {

    private int id;
    private int serviceId;
    private String examinationDuration;
    private String packageTitle;
    private float price;
    private String serviceName;
    private String reservationStatus;
    private String medicalRequest;
    private Date requestExaminationDate;
    private Date confirmedExaminationDate;

    /**
     * Get examinationDuration
     *
     * @param examinationDuration String
     */
    public String getExaminationDuration() {
        return examinationDuration;
    }

    /**
     * Set examinationDuration
     *
     * @param examinationDuration
     */
    public void setExaminationDuration(String examinationDuration) {
        this.examinationDuration = examinationDuration;
    }

    /**
     * Get packageTitle
     *
     * @param packageTitle String
     */
    public String getPackageTitle() {
        return packageTitle;
    }

    /**
     * Set packageTitle
     *
     * @param packageTitle
     */
    public void setPackageTitle(String packageTitle) {
        this.packageTitle = packageTitle;
    }

    /**
     * Get price
     *
     * @param price Float
     */
    public float getPrice() {
        return price;
    }

    /**
     * Set price
     *
     * @param price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Get serviceName
     *
     * @param serviceName String
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Set serviceName
     *
     * @param serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Get reservationStatus
     *
     * @param reservationStatus String
     */
    public String getReservationStatus() {
        return reservationStatus;
    }

    /**
     * Set reservationStatus
     *
     * @param reservationStatus
     */
    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    /**
     * Get medicalRequest
     *
     * @param medicalRequest String
     */
    public String getMedicalRequest() {
        return medicalRequest;
    }

    /**
     * set medicalRequest
     *
     * @param medicalRequest
     */
    public void setMedicalRequest(String medicalRequest) {
        this.medicalRequest = medicalRequest;
    }

    /**
     * Get requestExaminationDate
     *
     * @param requestExaminationDate Date
     */
    public Date getRequestExaminationDate() {
        return requestExaminationDate;
    }

    /**
     * Set requestExaminationDate
     *
     * @param requestExaminationDate
     */
    public void setRequestExaminationDate(Date requestExaminationDate) {
        this.requestExaminationDate = requestExaminationDate;
    }

    /**
     * Get confirmedExaminationDate
     *
     * @param confirmedExaminationDate Date
     */
    public Date getConfirmedExaminationDate() {
        return confirmedExaminationDate;
    }

    /**
     * Set confirmedExaminationDate
     *
     * @param confirmedExaminationDate Date
     */
    public void setConfirmedExaminationDate(Date confirmedExaminationDate) {
        this.confirmedExaminationDate = confirmedExaminationDate;
    }

    /**
     * Get id
     *
     * @param id int
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

}
