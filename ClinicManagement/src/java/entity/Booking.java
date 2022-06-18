/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Nam Ngo
 */
public class Booking {
    private int bookingID;
    private int servicePackageID;
    private int patientID;
    private int bookingStatusID;

    public Booking() {
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getServicePackageID() {
        return servicePackageID;
    }

    public void setServicePackageID(int servicePackageID) {
        this.servicePackageID = servicePackageID;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getBookingStatusID() {
        return bookingStatusID;
    }

    public void setBookingStatusID(int bookingStatusID) {
        this.bookingStatusID = bookingStatusID;
    }
    
}
