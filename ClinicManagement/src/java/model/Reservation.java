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
public class Reservation {

    private int reservationId;
    private User customer;
    private Service service;
    private ServicePackage servicePackage;
    private User confirmedDoctor;
    private Date requestExaminationDate;
    private Time requestExaminationTime;
    private Date confirmedExaminationDate;
    private Time confirmedExaminationTime;
    private Date reservationDate;
    private String reservationStatus;
    private String medicalRequest;

    /**
     * Create an instance of <code>Reservation</code> object
     */
    public Reservation() {
    }

    /**
     * Create an instance of <code>Reservation</code> object with value of
     * attributes of <code>Reservation</code>
     *
     * @param service the value of service attribute. It's a
     * <code>java.lang.Service</code> object
     * @param servicePackage the value of servicePackage attribute. It's a
     * <code>java.lang.servicePackage</code> object
     * @param reservationStatus the value of reservationStatus attribute. It's a
     * <code>java.lang.String</code> object
     */
    public Reservation(Service service, ServicePackage servicePackage, String reservationStatus) {
        this.service = service;
        this.servicePackage = servicePackage;
        this.reservationStatus = reservationStatus;
    }

    /**
     * Create an instance of <code>Reservation</code> object with value of
     * attributes of <code>Reservation</code>
     *
     * @param reservationId the value of reservationId attribute. It's a
     * <code>java.lang.int</code> object
     * @param customer the value of customer attribute. It's a
     * <code>java.lang.User</code> object
     * @param service the value of service attribute. It's a
     * <code>java.lang.Service</code> object
     * @param servicePackage the value of servicePackage attribute. It's a
     * <code>java.lang.servicePackage</code> object
     * @param confirmedDoctor the value of confirmedDoctor attribute. It's a
     * <code>java.lang.User</code> object
     * @param requestExaminationDate the value of requestExaminationDate
     * attribute. It's a <code>java.lang.Date</code> object
     * @param requestExaminationTime the value of requestExaminationTime
     * attribute. It's a <code>java.lang.Time</code> object
     * @param confirmedExaminationDate the value of confirmedExaminationDate
     * attribute. It's a <code>java.sql.Date</code> object
     * @param confirmedExaminationTime the value of confirmedExaminationTime
     * attribute. It's a <code>java.lang.Time</code> object
     * @param reservationDate the value of reservationDate attribute. It's a
     * <code>java.lang.Date</code> object
     * @param reservationStatus the value of reservationStatus attribute. It's a
     * <code>java.lang.String</code> object
     * @param medicalRequest the value of medicalRequest attribute. It's a
     * <code>java.lang.String</code> object
     */
    public Reservation(int reservationId, User customer, Service service, ServicePackage servicePackage, User confirmedDoctor, Date requestExaminationDate, Time requestExaminationTime, Date confirmedExaminationDate, Time confirmedExaminationTime, Date reservationDate, String reservationStatus, String medicalRequest) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.service = service;
        this.servicePackage = servicePackage;
        this.confirmedDoctor = confirmedDoctor;
        this.requestExaminationDate = requestExaminationDate;
        this.requestExaminationTime = requestExaminationTime;
        this.confirmedExaminationDate = confirmedExaminationDate;
        this.confirmedExaminationTime = confirmedExaminationTime;
        this.reservationDate = reservationDate;
        this.reservationStatus = reservationStatus;
        this.medicalRequest = medicalRequest;
    }

    /**
     * Return the value of reservationId attribute of the
     * <code>Reservation</code> object.
     */
    public int getReservationId() {
        return reservationId;
    }

    /**
     * Set reservationId value of the <code>Reservation</code> object.
     *
     * @param reservationId is a <code>java.lang.int</code> this value is the id
     * of the <code>Reservation</code> object.
     */
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Return the value of reservationId attribute of the
     * <code>Reservation</code> object.
     */
    public User getCustomer() {
        return customer;
    }

    /**
     * Set customer value of the <code>Reservation</code> object.
     *
     * @param customer is a <code>java.lang.User</code> this value is the
     * customer of the <code>Reservation</code> object.
     */
    public void setCustomer(User customer) {
        this.customer = customer;
    }

    /**
     * Return the value of service attribute of the <code>Reservation</code>
     * object.
     */
    public Service getService() {
        return service;
    }

    /**
     * Set service value of the <code>Reservation</code> object.
     *
     * @param service is a <code>java.lang.Service</code> this value is the
     * service of the <code>Reservation</code> object.
     */
    public void setService(Service service) {
        this.service = service;
    }

    /**
     * Return the value of servicePackage attribute of the
     * <code>Reservation</code> object.
     */
    public ServicePackage getServicePackage() {
        return servicePackage;
    }

    /**
     * Set servicePackage value of the <code>Reservation</code> object.
     *
     * @param servicePackage is a <code>java.lang.ServicePackage</code> this
     * value is the servicePackage of the <code>Reservation</code> object.
     */
    public void setServicePackage(ServicePackage servicePackage) {
        this.servicePackage = servicePackage;
    }

    /**
     * Return the value of confirmedDoctor attribute of the
     * <code>Reservation</code> object.
     */
    public User getConfirmedDoctor() {
        return confirmedDoctor;
    }

    /**
     * Set confirmedDoctor value of the <code>Reservation</code> object.
     *
     * @param confirmedDoctor is a <code>java.lang.User</code> this value is the
     * confirmedDoctor of the <code>Reservation</code> object.
     */
    public void setConfirmedDoctor(User confirmedDoctor) {
        this.confirmedDoctor = confirmedDoctor;
    }

    /**
     * Return the value of requestExaminationDate attribute of the
     * <code>Reservation</code> object.
     */
    public Date getRequestExaminationDate() {
        return requestExaminationDate;
    }

    /**
     * Set requestExaminationDate value of the <code>Reservation</code> object.
     *
     * @param requestExaminationDate is a <code>java.lang.Date</code> this value
     * is the requestExaminationDate of the <code>Reservation</code> object.
     */
    public void setRequestExaminationDate(Date requestExaminationDate) {
        this.requestExaminationDate = requestExaminationDate;
    }

    /**
     * Return the value of requestExaminationTime attribute of the
     * <code>Reservation</code> object.
     */
    public Time getRequestExaminationTime() {
        return requestExaminationTime;
    }

    /**
     * Set requestExaminationTime value of the <code>Reservation</code> object.
     *
     * @param requestExaminationTime is a <code>java.lang.Time</code> this value
     * is the requestExaminationTime of the <code>Reservation</code> object.
     */
    public void setRequestExaminationTime(Time requestExaminationTime) {
        this.requestExaminationTime = requestExaminationTime;
    }

    /**
     * Return the value of confirmedExaminationDate attribute of the
     * <code>Reservation</code> object.
     */
    public Date getConfirmedExaminationDate() {
        return confirmedExaminationDate;
    }

    /**
     * Set confirmedExaminationDate value of the <code>Reservation</code>
     * object.
     *
     * @param confirmedExaminationDate is a <code>java.lang.Date</code> this
     * value is the confirmedExaminationDate of the <code>Reservation</code>
     * object.
     */
    public void setConfirmedExaminationDate(Date confirmedExaminationDate) {
        this.confirmedExaminationDate = confirmedExaminationDate;
    }

    /**
     * Return the value of confirmedExaminationTime attribute of the
     * <code>Reservation</code> object.
     */
    public Time getConfirmedExaminationTime() {
        return confirmedExaminationTime;
    }

    /**
     * Set confirmedExaminationTime value of the <code>Reservation</code>
     * object.
     *
     * @param confirmedExaminationTime is a <code>java.lang.Time</code> this
     * value is the confirmedExaminationTime of the <code>Reservation</code>
     * object.
     */
    public void setConfirmedExaminationTime(Time confirmedExaminationTime) {
        this.confirmedExaminationTime = confirmedExaminationTime;
    }

    /**
     * Return the value of reservationDate attribute of the
     * <code>Reservation</code> object.
     */
    public Date getReservationDate() {
        return reservationDate;
    }

    /**
     * Set setReservationDate value of the <code>Reservation</code> object.
     *
     * @param setReservationDate is a <code>java.lang.Date</code> this value is
     * the setReservationDate of the <code>Reservation</code> object.
     */
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    /**
     * Return the value of reservationStatus attribute of the
     * <code>Reservation</code> object.
     */
    public String getReservationStatus() {
        return reservationStatus;
    }

    /**
     * Set reservationStatus value of the <code>Reservation</code> object.
     *
     * @param reservationStatus is a <code>java.lang.String</code> this value is
     * the reservationStatus of the <code>Reservation</code> object.
     */
    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    /**
     * Return the value of medicalRequest attribute of the
     * <code>Reservation</code> object.
     */
    public String getMedicalRequest() {
        return medicalRequest;
    }

    /**
     * Set medicalRequest value of the <code>Reservation</code> object.
     *
     * @param medicalRequest is a <code>java.lang.String</code> this value is
     * the reservationStatus of the <code>Reservation</code> object.
     */
    public void setMedicalRequest(String medicalRequest) {
        this.medicalRequest = medicalRequest;
    }

}
