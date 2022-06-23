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
public class BookScheduleDTO {

    private int reservationId;
    private String patientName;
    private String service;
    private String packageService;
    private Date requestDate;
    private Date confirmDate;
    private String status;
    private String medicalRequest;

    public BookScheduleDTO() {
    }

    public BookScheduleDTO(int reservationId, String patientName, String service, String packageService, Date requestDate, Date confirmDate, String status, String medicalRequest) {
        this.reservationId = reservationId;
        this.patientName = patientName;
        this.service = service;
        this.packageService = packageService;
        this.requestDate = requestDate;
        this.confirmDate = confirmDate;
        this.status = status;
        this.medicalRequest = medicalRequest;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getPackageService() {
        return packageService;
    }

    public void setPackageService(String packageService) {
        this.packageService = packageService;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMedicalRequest() {
        return medicalRequest;
    }

    public void setMedicalRequest(String medicalRequest) {
        this.medicalRequest = medicalRequest;
    }
}
