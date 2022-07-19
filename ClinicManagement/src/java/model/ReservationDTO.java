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
public class ReservationDTO {

    private int id;

    private Date requestDate;

    private String customerRequest;

    private int serviceId;

    private int packageId;

    /**
     * Get requestDate
     *
     * @return requestDate date
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * Set requestDate
     *
     * @param requestDate
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * Get CustomerRequest
     *
     * @return customerRequest String
     */
    public String getCustomerRequest() {
        return customerRequest;
    }

    /**
     * Set customerRequest
     *
     * @param customerRequest
     */
    public void setCustomerRequest(String customerRequest) {
        this.customerRequest = customerRequest;
    }

    /**
     * Get id
     *
     * @return id int
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

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

}
